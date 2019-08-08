package com.phz.greendaodemo.database.greenDao.db;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.phz.greendaodemo.database.greenDao.bean.Sample;
import com.phz.greendaodemo.database.greenDao.bean.Student;
import com.phz.greendaodemo.database.greenDao.bean.CreditCard;
import com.phz.greendaodemo.database.greenDao.bean.IdCard;
import com.phz.greendaodemo.database.greenDao.bean.StudentAndTeacherBean;
import com.phz.greendaodemo.database.greenDao.bean.Teacher;

import com.phz.greendaodemo.database.greenDao.db.SampleDao;
import com.phz.greendaodemo.database.greenDao.db.StudentDao;
import com.phz.greendaodemo.database.greenDao.db.CreditCardDao;
import com.phz.greendaodemo.database.greenDao.db.IdCardDao;
import com.phz.greendaodemo.database.greenDao.db.StudentAndTeacherBeanDao;
import com.phz.greendaodemo.database.greenDao.db.TeacherDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig sampleDaoConfig;
    private final DaoConfig studentDaoConfig;
    private final DaoConfig creditCardDaoConfig;
    private final DaoConfig idCardDaoConfig;
    private final DaoConfig studentAndTeacherBeanDaoConfig;
    private final DaoConfig teacherDaoConfig;

    private final SampleDao sampleDao;
    private final StudentDao studentDao;
    private final CreditCardDao creditCardDao;
    private final IdCardDao idCardDao;
    private final StudentAndTeacherBeanDao studentAndTeacherBeanDao;
    private final TeacherDao teacherDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        sampleDaoConfig = daoConfigMap.get(SampleDao.class).clone();
        sampleDaoConfig.initIdentityScope(type);

        studentDaoConfig = daoConfigMap.get(StudentDao.class).clone();
        studentDaoConfig.initIdentityScope(type);

        creditCardDaoConfig = daoConfigMap.get(CreditCardDao.class).clone();
        creditCardDaoConfig.initIdentityScope(type);

        idCardDaoConfig = daoConfigMap.get(IdCardDao.class).clone();
        idCardDaoConfig.initIdentityScope(type);

        studentAndTeacherBeanDaoConfig = daoConfigMap.get(StudentAndTeacherBeanDao.class).clone();
        studentAndTeacherBeanDaoConfig.initIdentityScope(type);

        teacherDaoConfig = daoConfigMap.get(TeacherDao.class).clone();
        teacherDaoConfig.initIdentityScope(type);

        sampleDao = new SampleDao(sampleDaoConfig, this);
        studentDao = new StudentDao(studentDaoConfig, this);
        creditCardDao = new CreditCardDao(creditCardDaoConfig, this);
        idCardDao = new IdCardDao(idCardDaoConfig, this);
        studentAndTeacherBeanDao = new StudentAndTeacherBeanDao(studentAndTeacherBeanDaoConfig, this);
        teacherDao = new TeacherDao(teacherDaoConfig, this);

        registerDao(Sample.class, sampleDao);
        registerDao(Student.class, studentDao);
        registerDao(CreditCard.class, creditCardDao);
        registerDao(IdCard.class, idCardDao);
        registerDao(StudentAndTeacherBean.class, studentAndTeacherBeanDao);
        registerDao(Teacher.class, teacherDao);
    }
    
    public void clear() {
        sampleDaoConfig.clearIdentityScope();
        studentDaoConfig.clearIdentityScope();
        creditCardDaoConfig.clearIdentityScope();
        idCardDaoConfig.clearIdentityScope();
        studentAndTeacherBeanDaoConfig.clearIdentityScope();
        teacherDaoConfig.clearIdentityScope();
    }

    public SampleDao getSampleDao() {
        return sampleDao;
    }

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public CreditCardDao getCreditCardDao() {
        return creditCardDao;
    }

    public IdCardDao getIdCardDao() {
        return idCardDao;
    }

    public StudentAndTeacherBeanDao getStudentAndTeacherBeanDao() {
        return studentAndTeacherBeanDao;
    }

    public TeacherDao getTeacherDao() {
        return teacherDao;
    }

}
