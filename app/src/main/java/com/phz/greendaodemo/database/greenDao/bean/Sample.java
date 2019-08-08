package com.phz.greendaodemo.database.greenDao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Sample {
    @Id(autoincrement = true)
    Long id;
    @Property(nameInDb = "message")
    String message;
    @Index(unique = true)
    String name;
    long time;

    public Sample() {
    }

    public Sample(String message, long time) {
        this.message = message;
        this.time = time;
    }

    public Sample(Long id, String message, String name) {
        this.id = id;
        this.message = message;
        this.name = name;
    }

    @Generated(hash = 1379011628)
    public Sample(Long id, String message, String name, long time) {
        this.id = id;
        this.message = message;
        this.name = name;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
