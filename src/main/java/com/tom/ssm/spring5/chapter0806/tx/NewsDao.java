package com.tom.ssm.spring5.chapter0806.tx;

/**
 * NewDao
 *
 * @author Tom on 2021/2/10
 */
public interface NewsDao {
    public void insert(String title, String content);
    public void insertAnno(String title, String content);
}
