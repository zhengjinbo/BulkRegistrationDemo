package com.example.attack.entity.api;

import com.example.attack.HttpPostService;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.Api.BaseApi;

import retrofit2.Retrofit;
import rx.Observable;

/**
 * Created by zjb on 2019/5/14.
 */
public class UserInfoApi extends BaseApi {
    public UserInfoApi(RxAppCompatActivity rxAppCompatActivity) {
        super(rxAppCompatActivity);
    }

    @Override
    public Observable getObservable(Retrofit retrofit) {
        return retrofit.create(HttpPostService.class).getUserInfo();
    }
}
