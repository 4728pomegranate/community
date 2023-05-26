package com.nowcoder.community.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

@Configuration
public class AlphaConfig {
    @Bean
    public SimpleDateFormat simpleDateFormat(){//方法名就是Bean的名字
        return new SimpleDateFormat("yyyy-MM-dd:mm:ss");
    }
}
