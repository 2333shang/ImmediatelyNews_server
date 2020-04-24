package com.shang.news.config;

import java.nio.charset.Charset;
import java.util.List;

import org.springframework.boot.system.ApplicationHome;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.shang.news.component.LoginHandlerInterceptor;
import com.shang.news.constant.FileUploadConstant;

@Configuration
public class NewsMvcConfigurer implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("hello");
//		registry.addViewController("/hello").setViewName("hello");
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
								.excludePathPatterns("/","/user/login", "/user/logininvalid", "/file/**", "/error");
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		String path = new ApplicationHome(getClass()).getSource().getParentFile().toString().replace("\\", "/");
		registry.addResourceHandler("/file/**").addResourceLocations("file:" + path + "/" + FileUploadConstant.FILE_PATH + "/");
	}
	@Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        StringHttpMessageConverter converter = new StringHttpMessageConverter(
                Charset.forName("UTF-8"));
        return converter;
    }

    @Override
    public void configureMessageConverters(
            List<HttpMessageConverter<?>> converters) {
//        super.configureMessageConverters(converters);
        converters.add(responseBodyConverter());	
    }

    @Override
    public void configureContentNegotiation(
            ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false);
    }
}
