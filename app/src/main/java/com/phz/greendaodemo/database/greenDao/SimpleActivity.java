package com.phz.greendaodemo.database.greenDao;

import android.text.TextUtils;
import android.widget.Toast;

import com.phz.greendaodemo.MyApplication;
import com.phz.greendaodemo.database.base.DataBaseActivity;
import com.phz.greendaodemo.database.greenDao.bean.Sample;
import com.phz.greendaodemo.database.greenDao.db.DaoSession;
import com.phz.greendaodemo.database.greenDao.db.SampleDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

import static com.phz.greendaodemo.MyApplication.DB_NAME;

public class SimpleActivity extends DataBaseActivity {
    private DaoSession daoSession;

    @Override
    public void insertData(Sample s) {
        if(s == null ) {
            List<Sample> sampleArrayList = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                String content = "第" + i + "个数据";
                String name = "第" + i + "个名字";
                Sample sample=new Sample(content,System.currentTimeMillis() - 60 * 1000 * i);
                //daoSession.insertOrReplace(sample);
                sampleArrayList.add(sample);
            }
            /**
             * 批量插入
             */
            daoSession.getSampleDao().insertInTx(sampleArrayList);
        }else {
            daoSession.insertOrReplace(s);
        }
        mDataBaseAdapter.refreshData();
    }

    @Override
    public void deleteAll() {
       /* deleteDatabase(DB_NAME);//调用此方法会删除与此上下文的应用程序包关联的现有私有SQLiteDatabase，daoSession会失效，需重新打开数据库建立连接
        daoSession=MyApplication.getInstance().getDaoSessionNew();
        SampleDao sampleDao=daoSession.getSampleDao();
        samples=sampleDao.loadAll();*/
        daoSession.deleteAll(Sample.class);//调用此方法，表id还是在的(再调插入，id继续自增)，删除库方法就不一样(需要重新建立连接，id又从1开始)
        mDataBaseAdapter.refreshData();
    }

    @Override
    public void deleteData(Sample s) {
        daoSession.delete(s);
        mDataBaseAdapter.refreshData();
    }

    @Override
    public void updataData(Sample s) {
        daoSession.update(s);
        mDataBaseAdapter.refreshData();
    }

    @Override
    public void queryData(String s) {
        if (TextUtils.isEmpty(s)){
            Toast.makeText(this, "请输入查询的id", Toast.LENGTH_SHORT).show();
        }else {
            List<Sample> sampleArrayList=daoSession.queryRaw(Sample.class,"where _id = ?",s);
            mDataBaseAdapter.addNewSampleData(sampleArrayList);
        }
    }

    @Override
    public void initDataBase() {
        daoSession=MyApplication.getInstance().getDaoSession();
        SampleDao sampleDao=daoSession.getSampleDao();
        samples=sampleDao.loadAll();
    }

//    /**
//     * 批量更新
//     */
//    public void updateListInTx(){
//        List<Sample> samples = daoSession.getSampleDao().loadAll();
//        for (Sample sample : samples) {
//            sample.setMessage(sample.getMessage() + " GoodBye 你了");
//        }
//        daoSession.getSampleDao().updateInTx(samples);
//    }
//
//    /**
//     * 批量删除
//     */
//    public void deleteListInTx(List<Sample> sampleList){
//        daoSession.getSampleDao().deleteInTx(sampleList);
//    }

    /**
     * 使用QueryBuilder进行查询
     */
//    public List quetyList(String message){
//        QueryBuilder<Sample> qb = daoSession.queryBuilder(Sample.class);
//        // 查出所有的数据
//        List<Sample> list = qb.list();
//
//        //查出当前对应message的数据
//        QueryBuilder<Sample> thingQueryBuilder = qb.where(SampleDao.Properties.Message.like(message)).orderAsc(SampleDao.Properties.Message);
//        List<Sample> sampleList = thingQueryBuilder.list();
//
//        //查询Message值为message时，按Name值排序的结果
//        qb = daoSession.queryBuilder(Sample.class);
//        List<Sample> list1 = qb.where(SampleDao.Properties.Message.eq(message)).orderAsc(SampleDao.Properties.Name).list();
//
//        //嵌套查询： 查询Id大于5小于50，且Message值为message的数据
//        qb = daoSession.queryBuilder(Sample.class);
//        List<Sample> list2 = qb.where(SampleDao.Properties.Message.eq(message), qb.and(SampleDao.Properties.Id.gt(5), SampleDao.Properties.Id.le(50))).list();
//
//        return list;
//    }

}
