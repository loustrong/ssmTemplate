package com.tom.ssm.spring5.chapter0806.tx.impl;

import com.tom.ssm.spring5.chapter0806.tx.NewsDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;


/**
 * NewDaoImpl
 *
 * @author Tom on 2021/2/10
 */
public class NewsDaoImpl implements NewsDao {

    private DataSource ds;
    public void setDs(DataSource ds){
        this.ds = ds;
    }
    @Override
    public void insert(String title, String content) {
        JdbcTemplate jt = new JdbcTemplate(ds);
        jt.update("insert into news_inf" +
                " values(null, ?, ?)", title, content);

        jt.update("insert into news_inf" +
                " values(null, ?, ?)", title, content);
    }

    @Transactional(propagation= Propagation.REQUIRED, isolation= Isolation.DEFAULT, timeout=5)
    public void insertAnno(String title, String content)
    {
        JdbcTemplate jt = new JdbcTemplate(ds);
        jt.update("insert into news_inf"
                        + " values(null , ? , ?)"
                , title , content);
        // 两次插入的数据违反唯一键约束
        jt.update("insert into news_inf"
                        + " values(null , ? , ?)"
                , title , content);
        // 如果没有事务控制，则第一条记录可以被插入
        // 如果增加事务控制，将发现第一条记录也插不进去。
    }
}
