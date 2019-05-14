package com.example.attack.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.example.attack.MyApplication;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.bean.DaoMaster;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.bean.DaoSession;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.bean.RegisterInfoBean;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.bean.RegisterInfoBeanDao;
import org.greenrobot.greendao.query.QueryBuilder;
import java.util.List;





public class DbRegisterUtil {
    private static DbRegisterUtil db;
    private final static String dbName = "db_register";
    private DaoMaster.DevOpenHelper openHelper;
    private Context context;


    public DbRegisterUtil() {
        context= MyApplication.app;
        openHelper = new DaoMaster.DevOpenHelper(context, dbName, null);
    }


    /**
     * 获取单例
     * @return
     */
    public static DbRegisterUtil getInstance() {
        if (db == null) {
            synchronized (DbRegisterUtil.class) {
                if (db == null) {
                    db = new DbRegisterUtil();
                }
            }
        }
        return db;
    }


    /**
     * 获取可读数据库
     */
    private SQLiteDatabase getReadableDatabase() {
        if (openHelper == null) {
            openHelper = new DaoMaster.DevOpenHelper(context, dbName, null);
        }
        SQLiteDatabase db = openHelper.getReadableDatabase();
        return db;
    }

    /**
     * 获取可写数据库
     */
    private SQLiteDatabase getWritableDatabase() {
        if (openHelper == null) {
            openHelper = new DaoMaster.DevOpenHelper(context, dbName, null);
        }
        SQLiteDatabase db = openHelper.getWritableDatabase();
        return db;
    }


    public void save(RegisterInfoBean info){
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        RegisterInfoBeanDao registerInfoBeanDao = daoSession.getRegisterInfoBeanDao();
        registerInfoBeanDao.insertOrReplace(info);
    }

    public void update(RegisterInfoBean info){
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        RegisterInfoBeanDao registerInfoBeanDao = daoSession.getRegisterInfoBeanDao();
        registerInfoBeanDao.update(info);
    }

    public void deleteDowninfo(RegisterInfoBean info){
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        RegisterInfoBeanDao registerInfoBeanDao = daoSession.getRegisterInfoBeanDao();
        registerInfoBeanDao.delete(info);
    }


    public RegisterInfoBean queryBy(long Id) {
        DaoMaster daoMaster = new DaoMaster(getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        RegisterInfoBeanDao registerInfoBeanDao = daoSession.getRegisterInfoBeanDao();
        QueryBuilder<RegisterInfoBean> qb = registerInfoBeanDao.queryBuilder();
        qb.where(RegisterInfoBeanDao.Properties.Id.eq(Id));
        List<RegisterInfoBean> list = qb.list();
        if(list.isEmpty()){
            return null;
        }else{
            return list.get(0);
        }
    }

    public List<RegisterInfoBean> queryAll() {
        DaoMaster daoMaster = new DaoMaster(getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        RegisterInfoBeanDao registerInfoBeanDao = daoSession.getRegisterInfoBeanDao();
        QueryBuilder<RegisterInfoBean> qb = registerInfoBeanDao.queryBuilder();
        return qb.list();
    }
}
