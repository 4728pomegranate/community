package com.nowcoder.community.service;

import com.nowcoder.community.dao.AlphaDao;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class AlphaService {
    @Autowired
    private AlphaDao alphaDao;


    public AlphaService(){
        System.out.println("实例化AlphaService");
    }
    //这是注释：构造器之后初始化
    @PostConstruct
    public void init(){
        System.out.println("初始化AlphaService");
    }
    //销毁之前调用，释放资源，之前：是因为销毁了就没法调用了
    @PreDestroy

    public void destroy(){
        System.out.println("销毁AlphaService");
    }

    //处理业务的方法
    public String find() {
        return alphaDao.select();
    }
}
