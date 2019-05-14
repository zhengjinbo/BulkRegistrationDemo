package com.example.attack.activity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.attack.R;
import com.example.attack.adapter.ResultAdapter;
import com.example.attack.entity.CaptchaBean;
import com.example.attack.entity.SignUp;
import com.example.attack.entity.UserInfoBean;
import com.example.attack.entity.api.CaptchaApi;
import com.example.attack.entity.api.SignUpApi;
import com.example.attack.entity.api.UserInfoApi;
import com.example.attack.fateadm.FateadmAPI;
import com.example.attack.fateadm.Util;
import com.example.attack.utils.DateUtil;
import com.example.attack.utils.DbRegisterUtil;
import com.example.attack.utils.FileUtil;
import com.example.attack.utils.StringUtil;
import com.google.gson.Gson;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.bean.RegisterInfoBean;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.http.HttpManager;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.listener.HttpOnNextListener;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by zjb on 2019/5/9.
 */
public class AttackActivity extends RxAppCompatActivity {
    private final static String TAG = "AttackActivity";
    private static final int SET_BALANCE = 0;
    private static final int SET_RESULT = 1;
    private Button btn_attack;
    private ProgressBar progressBar;
    ImageView imageView;
    EditText et_time;
    TextView textView, tv_result,tv_progress;
    private RecyclerView mRecyclerView;
    private FateadmAPI api = new FateadmAPI();
    boolean INIT = false;
    Bitmap tmp_b = null;
    String resultStr = "";
    String pred_resl = "";
    private int timeNum, totalNum;
    private List<String> list;
    private ResultAdapter resultAdapter;
    private String userName,passWord;
    private String phoneStr="";
    private String appName="爱彩网";



    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SET_BALANCE:
                    textView.setText(resultStr);
                    break;
                case SET_RESULT:
                    textView.setText(resultStr);
                    imageView.setImageBitmap(tmp_b);
                    break;
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attack);
        initApi();

        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);
        tv_result = findViewById(R.id.tv_result);
        btn_attack = findViewById(R.id.btn_attack);
        et_time = findViewById(R.id.et_time);
        progressBar = findViewById(R.id.progressBar);
        mRecyclerView = findViewById(R.id.mRecyclerView);
        tv_progress = findViewById(R.id.tv_progress);

        btn_attack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_progress.setText("开始执行，请稍后...");
                timeNum = Integer.parseInt(et_time.getText().toString());
                totalNum = timeNum;
                progressBar.setMax(totalNum);
                getVcode();

            }
        });
        list = new ArrayList<>();
        initList();
    }

    private void initList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        resultAdapter = new ResultAdapter(this, list);
        mRecyclerView.setAdapter(resultAdapter);
    }

    private void initApi() {
        String toast_msg = "";
        try {
            api.Init("311946",
                    "KAxN/m/c0bLOo52BEUh6Yh7AL1cRR3up",
                    "111946",
                    "y2mQb3VI+7NMtCg0bi9C6bNRAFqAEBgj");
            INIT = true;
            toast_msg = "初始化成功";
        } catch (Exception e) {
            toast_msg = "初始化失败\n" + e.getMessage();
        }
        Toast.makeText(getBaseContext(), toast_msg, Toast.LENGTH_LONG).show();
    }


    //获取验证码
    public void getVcode() {
        CaptchaApi captchaApi = new CaptchaApi(this);
        captchaApi.setMethod("api/General/captcha");
        captchaApi.setShowProgress(false);
        captchaApi.setListener(new HttpOnNextListener<CaptchaBean>() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onNext(CaptchaBean captchaBean) throws Exception {
                //                String picPath = FileUtil.downImage(AttackActivity.this, responseBody);
                String data = captchaBean.getData();
                String[] split = data.split("base64,");
                byte[] bytes = FileUtil.decode(split[1]);
                discernVcode(bytes);
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                Log.e("checkallowreg  onError", e.getMessage());
            }
        });
        HttpManager.getInstance().doHttpDeal(captchaApi);
    }

    //识别验证码
    private void discernVcode(final byte[] img_data) {
        if (INIT) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Log.e("开始识别验证码","                 -----------------------------------------");
                    Util.HttpResp resp = null;
                    tmp_b = BitmapFactory.decodeByteArray(img_data, 0, img_data.length);
                    try {
                        resp = api.PredictMForm("304000002", img_data);
                        if (!resp.rsp_data.equals("")) {
                            pred_resl = resp.pred_resl;
                            resultStr = "识别结果：" + resp.pred_resl;
                            Log.e("二维码识别结果","======================="+"RetCode:" + resp.ret_code
                                    + "\nErrMsg:" + resp.err_msg
                                    + "\n当前余额：" + resp.cust_val
                                    + "\n识别结果：" + resp.pred_resl);
                            handler.sendEmptyMessage(SET_RESULT);
                            if (resp.ret_code == 0) { // 识别成功
                                register(resp.pred_resl);
                            }
                        } else {
                            Log.e("二维码识别结果","           ======操作失败");
                            resultStr = "操作失败";
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Looper.prepare();
                    Looper.loop();
                }
            }).start();
        } else {
            Toast.makeText(getBaseContext(), "使用前必须初始化", Toast.LENGTH_LONG).show();
        }
    }

    //注册
    private void register(String pred_resl) {
         userName = StringUtil.getChar(15);
         passWord = StringUtil.getChar(12);
        SignUpApi signUpApi = new SignUpApi(this);
        signUpApi.setMobile("api/User/signUp");
        signUpApi.setShowProgress(false);
        signUpApi.setCaptcha(pred_resl);
        signUpApi.setUserName(userName);
        signUpApi.setPassword(passWord);
        signUpApi.setMobile("");//选填项
        signUpApi.setListener(new HttpOnNextListener<SignUp>() {
            @Override
            public void onNext(SignUp signUp) {
                timeNum--;
                progressBar.setProgress(totalNum - timeNum);
                tv_progress.setText((totalNum - timeNum)+"/"+totalNum);
                list.add(new Gson().toJson(signUp));
                resultAdapter.updata(list);
                if (timeNum > 0) {
                    getVcode();
                }
                if (signUp.getErrorcode()==200){
                    RegisterInfoBean registerInfoBean = new RegisterInfoBean();
                    registerInfoBean.setApkName(appName);
                    registerInfoBean.setUserName(userName);
                    registerInfoBean.setPassWord(passWord);
                    registerInfoBean.setPhone(phoneStr);
                    registerInfoBean.setCreateTime(DateUtil.toTime());
                    DbRegisterUtil.getInstance().save(registerInfoBean);
                    userInfoApi();
                }
            }


            @Override
            public void onError(Throwable e) {
                super.onError(e);
                Log.e("onError", e.getMessage());
                timeNum--;
                progressBar.setProgress(totalNum - timeNum);
                tv_progress.setText((totalNum - timeNum)+"/"+totalNum);
                list.add(e.getMessage());
                resultAdapter.updata(list);
                if (timeNum > 0) {
                    getVcode();
                }
            }
        });

        HttpManager.getInstance().doHttpDeal(signUpApi);
    }

    //获取用户信息
    private void userInfoApi() {
        UserInfoApi userInfoApi = new UserInfoApi(this);
        userInfoApi.setMethod("api/Account/getUserInfo");
        userInfoApi.setShowProgress(false);
        userInfoApi.setListener(new HttpOnNextListener<UserInfoBean>() {
            @Override
            public void onNext(UserInfoBean userInfoBean) throws Exception {

            }
        });
        HttpManager.getInstance().doHttpDeal(userInfoApi);
    }

}



