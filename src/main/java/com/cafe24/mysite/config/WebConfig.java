package com.cafe24.mysite.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.cafe24.mysite.config.web.FileuploadConfig;
import com.cafe24.mysite.config.web.MVCConfig;
import com.cafe24.mysite.config.web.MessageConfig;
import com.cafe24.mysite.config.web.SecurityConfig;
import com.cafe24.mysite.config.web.SwaggerConfig;

@Configuration
@EnableAspectJAutoProxy
@EnableWebMvc
@ComponentScan({"com.cafe24.mysite.controller"})
@Import({MVCConfig.class,SecurityConfig.class,MessageConfig.class, FileuploadConfig.class, SwaggerConfig.class})

public class WebConfig {

}
