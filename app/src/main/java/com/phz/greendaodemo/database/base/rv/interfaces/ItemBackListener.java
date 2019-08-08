
package com.phz.greendaodemo.database.base.rv.interfaces;


import com.phz.greendaodemo.database.greenDao.bean.Sample;

public interface ItemBackListener {
        void onItemClick(Sample s);
        void onItemLongClick(Sample s);
    }