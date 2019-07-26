package com.example.day_02_lxc.sql;

import com.example.day_02_lxc.ResultsBean;
import com.example.xts.greendaodemo.db.DaoMaster;
import com.example.xts.greendaodemo.db.DaoSession;
import com.example.xts.greendaodemo.db.ResultsBeanDao;

import java.util.List;

/**
 * Created by DELL on 2019/7/25.
 */

public class Dbutil {

    private static Dbutil db_util;
    private ResultsBeanDao mResultsBeanDao;

    public static Dbutil getDb_util() {
        if (db_util == null) {
            synchronized (Dbutil.class) {
                if (db_util == null) {
                    db_util = new Dbutil();
                }
            }
        }

        return db_util;
    }

    public Dbutil() {
        super();
        getSQl();
    }

    private void getSQl() {
        DaoSession daoSession = MyAppcliont.getDaoSession();
        mResultsBeanDao = daoSession.getResultsBeanDao();
    }

    public void insert(ResultsBean resultsBean) {
        if (has(resultsBean)) {
            return;
        }
        mResultsBeanDao.insertOrReplaceInTx(resultsBean);
    }

    public boolean has(ResultsBean student) {
        List<ResultsBean> list = mResultsBeanDao.queryBuilder().where(ResultsBeanDao.Properties._id.eq(student.get_id())).list();
        if (list.size() > 0) {
            return true;
        }
        return false;
    }

    public List<ResultsBean> select() {
        List<ResultsBean> list = mResultsBeanDao.queryBuilder().list();
        return list;
    }
}
