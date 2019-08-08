package com.phz.greendaodemo.database.greenDao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author haizhuo
 * ID卡
 */
@Entity
public class IdCard {
    /**
     * 用户名
     */
    @Id
    String  userName;
    /**
     * 身份证号
     */
    @Unique
    String  idNum;
    @Generated(hash = 122715893)
    public IdCard(String userName, String idNum) {
        this.userName = userName;
        this.idNum = idNum;
    }
    @Generated(hash = 1500073048)
    public IdCard() {
    }
    public String getUserName() {
        return this.userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getIdNum() {
        return this.idNum;
    }
    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }
}
