package com.phz.greendaodemo.database.greenDao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author haizhuo
 * 信用卡
 */
@Entity
public class CreditCard {
    @Id
    Long id;
    /**
     * *Teacher和Student都和CreditCard是一对多关系,所以2个ID是需要的
     */
    Long studentId;
    Long teacherId;
    /**
     * 持卡人姓名
     */
    String userName;
    /**
     * 卡号
     */
    String carNum;
    /**
     * 银行
     */
    String whichBank;
    /**
     * 卡片类型(等级)0-5
     */
    int cardType;
    @Generated(hash = 1450924505)
    public CreditCard(Long id, Long studentId, Long teacherId, String userName,
            String carNum, String whichBank, int cardType) {
        this.id = id;
        this.studentId = studentId;
        this.teacherId = teacherId;
        this.userName = userName;
        this.carNum = carNum;
        this.whichBank = whichBank;
        this.cardType = cardType;
    }
    @Generated(hash = 1860989810)
    public CreditCard() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getStudentId() {
        return this.studentId;
    }
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
    public Long getTeacherId() {
        return this.teacherId;
    }
    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }
    public String getUserName() {
        return this.userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getCarNum() {
        return this.carNum;
    }
    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }
    public String getWhichBank() {
        return this.whichBank;
    }
    public void setWhichBank(String whichBank) {
        this.whichBank = whichBank;
    }
    public int getCardType() {
        return this.cardType;
    }
    public void setCardType(int cardType) {
        this.cardType = cardType;
    }

}
