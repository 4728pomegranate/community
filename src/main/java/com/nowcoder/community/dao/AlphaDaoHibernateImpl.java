package com.nowcoder.community.dao;

import org.springframework.stereotype.Repository;
//重新自定义名字
@Repository("alphahibernate")
public class AlphaDaoHibernateImpl implements AlphaDao{
    @Override
    public String select(){
        return "Hibernate";
    }
}
