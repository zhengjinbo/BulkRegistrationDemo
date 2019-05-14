package com.wzgiceman.rxretrofitlibrary.retrofit_rx.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 注册新
 * Created by WZG on 2016/10/20.
 */

@Entity
public class RegisterInfoBean {
    @Id(autoincrement = true)
    private Long id;
    private String userName;
    private String passWord;
    private String phone;
    private String apkName;
    private String createTime;
    @Generated(hash = 987664098)
    public RegisterInfoBean(Long id, String userName, String passWord, String phone,
            String apkName, String createTime) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.phone = phone;
        this.apkName = apkName;
        this.createTime = createTime;
    }
    @Generated(hash = 345540093)
    public RegisterInfoBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUserName() {
        return this.userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassWord() {
        return this.passWord;
    }
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getApkName() {
        return this.apkName;
    }
    public void setApkName(String apkName) {
        this.apkName = apkName;
    }
    public String getCreateTime() {
        return this.createTime;
    }
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

}
