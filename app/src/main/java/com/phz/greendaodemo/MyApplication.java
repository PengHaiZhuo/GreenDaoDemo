package com.phz.greendaodemo;

import android.app.Application;
import android.content.Context;

import com.phz.greendaodemo.database.greenDao.db.DaoMaster;
import com.phz.greendaodemo.database.greenDao.db.DaoSession;

import org.greenrobot.greendao.database.Database;

public class MyApplication extends Application {
    public static final String DB_NAME="haizhuo-db";
    private DaoSession daoSession;
    private static volatile MyApplication myApplication;
    @Override
    public void onCreate() {
        super.onCreate();
        myApplication=this;
        initGreenDao();
    }

    public static MyApplication getInstance(){
        if (myApplication == null) {
            synchronized (MyApplication.class) {
                if (myApplication == null) {
                    myApplication = new MyApplication();
                }
            }
        }
        return myApplication;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    private void initGreenDao(){
        // regular SQLite database
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, DB_NAME);
        Database db = helper.getWritableDb();//在调用{@link #getWritableDatabase}或{@link #getReadableDatabase}中的一个之前，实际上不会创建或打开数据库。

        // encrypted SQLCipher database
        // note: you need to add SQLCipher to your dependencies, check the build.gradle file
        // DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "notes-db-encrypted");
        // Database db = helper.getEncryptedWritableDb("encryption-key");

        daoSession = new DaoMaster(db).newSession();// 注意：该数据库连接属于DaoMaster，所以新建多个Session也是相同的数据库连接。
    }

//    public DaoSession getDaoSessionNew() {
//        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, DB_NAME);
//        Database db = helper.getWritableDb();
//        return new DaoMaster(db).newSession();
//    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
