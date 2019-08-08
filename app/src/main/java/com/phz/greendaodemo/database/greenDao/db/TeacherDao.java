package com.phz.greendaodemo.database.greenDao.db;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.SqlUtils;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import com.phz.greendaodemo.database.greenDao.bean.IdCard;
import com.phz.greendaodemo.database.greenDao.bean.StudentAndTeacherBean;

import com.phz.greendaodemo.database.greenDao.bean.Teacher;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "TEACHER".
*/
public class TeacherDao extends AbstractDao<Teacher, Long> {

    public static final String TABLENAME = "TEACHER";

    /**
     * Properties of entity Teacher.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property TeacherNo = new Property(1, int.class, "teacherNo", false, "TEACHER_NO");
        public final static Property Age = new Property(2, int.class, "age", false, "AGE");
        public final static Property Sex = new Property(3, String.class, "sex", false, "SEX");
        public final static Property TelPhone = new Property(4, String.class, "telPhone", false, "TEL_PHONE");
        public final static Property Name = new Property(5, String.class, "name", false, "NAME");
        public final static Property SchoolName = new Property(6, String.class, "schoolName", false, "SCHOOL_NAME");
        public final static Property Subject = new Property(7, String.class, "subject", false, "SUBJECT");
    }

    private DaoSession daoSession;

    private Query<Teacher> student_TeacherListQuery;

    public TeacherDao(DaoConfig config) {
        super(config);
    }
    
    public TeacherDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"TEACHER\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"TEACHER_NO\" INTEGER NOT NULL UNIQUE ," + // 1: teacherNo
                "\"AGE\" INTEGER NOT NULL ," + // 2: age
                "\"SEX\" TEXT," + // 3: sex
                "\"TEL_PHONE\" TEXT," + // 4: telPhone
                "\"NAME\" TEXT," + // 5: name
                "\"SCHOOL_NAME\" TEXT," + // 6: schoolName
                "\"SUBJECT\" TEXT);"); // 7: subject
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"TEACHER\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Teacher entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getTeacherNo());
        stmt.bindLong(3, entity.getAge());
 
        String sex = entity.getSex();
        if (sex != null) {
            stmt.bindString(4, sex);
        }
 
        String telPhone = entity.getTelPhone();
        if (telPhone != null) {
            stmt.bindString(5, telPhone);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(6, name);
        }
 
        String schoolName = entity.getSchoolName();
        if (schoolName != null) {
            stmt.bindString(7, schoolName);
        }
 
        String subject = entity.getSubject();
        if (subject != null) {
            stmt.bindString(8, subject);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Teacher entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getTeacherNo());
        stmt.bindLong(3, entity.getAge());
 
        String sex = entity.getSex();
        if (sex != null) {
            stmt.bindString(4, sex);
        }
 
        String telPhone = entity.getTelPhone();
        if (telPhone != null) {
            stmt.bindString(5, telPhone);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(6, name);
        }
 
        String schoolName = entity.getSchoolName();
        if (schoolName != null) {
            stmt.bindString(7, schoolName);
        }
 
        String subject = entity.getSubject();
        if (subject != null) {
            stmt.bindString(8, subject);
        }
    }

    @Override
    protected final void attachEntity(Teacher entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Teacher readEntity(Cursor cursor, int offset) {
        Teacher entity = new Teacher( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getInt(offset + 1), // teacherNo
            cursor.getInt(offset + 2), // age
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // sex
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // telPhone
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // name
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // schoolName
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7) // subject
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Teacher entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setTeacherNo(cursor.getInt(offset + 1));
        entity.setAge(cursor.getInt(offset + 2));
        entity.setSex(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setTelPhone(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setName(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setSchoolName(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setSubject(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Teacher entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Teacher entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Teacher entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "teacherList" to-many relationship of Student. */
    public List<Teacher> _queryStudent_TeacherList(Long studentId) {
        synchronized (this) {
            if (student_TeacherListQuery == null) {
                QueryBuilder<Teacher> queryBuilder = queryBuilder();
                queryBuilder.join(StudentAndTeacherBean.class, StudentAndTeacherBeanDao.Properties.TeacherId)
                    .where(StudentAndTeacherBeanDao.Properties.StudentId.eq(studentId));
                student_TeacherListQuery = queryBuilder.build();
            }
        }
        Query<Teacher> query = student_TeacherListQuery.forCurrentThread();
        query.setParameter(0, studentId);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getIdCardDao().getAllColumns());
            builder.append(" FROM TEACHER T");
            builder.append(" LEFT JOIN ID_CARD T0 ON T.\"NAME\"=T0.\"USER_NAME\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected Teacher loadCurrentDeep(Cursor cursor, boolean lock) {
        Teacher entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        IdCard student = loadCurrentOther(daoSession.getIdCardDao(), cursor, offset);
        entity.setStudent(student);

        return entity;    
    }

    public Teacher loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<Teacher> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<Teacher> list = new ArrayList<Teacher>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<Teacher> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<Teacher> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
