package com.wzgiceman.rxretrofitlibrary.retrofit_rx.http.cookie;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.RxRetrofitApp;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.utils.AppUtil;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.utils.SPUtil;

import java.io.IOException;
import java.util.HashSet;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by zjb on 2019/5/10.
 */
public class ReceivedCookiesInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());


        //配置request
        Request request = chain.request();
        Request.Builder requestBuilder = request.newBuilder();
        Log.e("请求头拦截",new Gson().toJson(request));
//        requestBuilder.addHeader("IPAddress", ipAddress);
//        String deviceID = AppUtil.getAndroidID(context);
//        //        String deviceID = "871c3duidcc6dgd";
//        requestBuilder.addHeader("DeviceID", deviceID);
//        requestBuilder.addHeader("AccessToken", SPUtil.getString(context, Constants.ACCESS_TOKEN, ""));


        Response.Builder responseBuilder = chain.proceed(requestBuilder.build()).newBuilder();
        Response response = responseBuilder.build();

        if (!originalResponse.headers("Set-Cookie").isEmpty()) {
            HashSet<String> cookies = new HashSet<>();
            for (String header : originalResponse.headers("Set-Cookie")) {
                cookies.add(header);
            }

            SharedPreferences.Editor config =RxRetrofitApp.getApplication().getSharedPreferences("config", RxRetrofitApp.getApplication().MODE_PRIVATE)
                    .edit();
            config.putStringSet("cookie", cookies);
            config.commit();

        }

        return originalResponse;
    }
}
