package com.example.attack;

import com.example.attack.entity.CaptchaBean;
import com.example.attack.entity.RegisterBean;
import com.example.attack.entity.SignUp;
import com.example.attack.entity.ToBean;
import com.example.attack.entity.UserInfoBean;
import com.example.attack.entity.resulte.RetrofitEntity;
import com.example.attack.entity.resulte.SubjectResulte;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.Api.BaseResultEntity;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 测试接口service-post相关
 * Created by WZG on 2016/12/19.
 */

public interface HttpPostService {
    @POST("AppFiftyToneGraph/videoLink")
    Call<RetrofitEntity> getAllVedio(@Body boolean once_no);

    @POST("AppFiftyToneGraph/videoLink")
    Observable<RetrofitEntity> getAllVedioBy(@Body boolean once_no);

    @FormUrlEncoded
    @POST("AppFiftyToneGraph/videoLink")
    Observable<BaseResultEntity<List<SubjectResulte>>> getAllVedioBys(@Field("once") boolean once_no);


    //获取验证码接口
    @GET("mobile/user/vcode")
    Observable<ResponseBody>vcode();

    //================================爱彩网=======================================
    //获取验证码
    @POST("api/General/captcha")
    Observable<CaptchaBean> captcha();

    //注册
    @FormUrlEncoded
    @POST("api/User/signUp")
    Observable<SignUp> signUp(@Field("captcha") String captcha,
                              @Field("password") String password,
                              @Field("userName") String userName,
                              @Field("mobile") String mobile);

    //获取用户信息
    @POST("api/Account/getUserInfo")
    Observable<UserInfoBean> getUserInfo();

}
