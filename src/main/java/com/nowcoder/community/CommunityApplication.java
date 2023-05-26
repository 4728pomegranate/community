package com.nowcoder.community;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//该注解表示 这是一个配置文件，且在程序的入口使用
@SpringBootApplication
public class CommunityApplication {

	public static void main(String[] args) {
		//1. 启动了tomcat
		//2. 创建了spring container
		//		自动扫描business（配置文件所在的包及其子包，并且注解了Controller,Service,Component,Repository），装配到容器里
		//			Controller: 请求主见
		//			Service:业务组件,Component
		//			Repository:数据库请求
		SpringApplication.run(CommunityApplication.class, args);
	}

}
