package com.shang.news.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.shang.news.component.CommonsFieldMetaObjectHandler;

@EnableTransactionManagement
@Configuration
public class MybatisPlusConfig {

	//分页插件
	@Bean
	public PaginationInterceptor pagination() {
		return new PaginationInterceptor();
	}
	
	//SQL分析插件：防止进行全表的更新或删除操作
//	@Bean
//	public SqlExplainInterceptor sqlExplain() {
//		SqlExplainInterceptor sqlExplainInterceptor = new SqlExplainInterceptor();
//		sqlExplainInterceptor.setSqlParserList(Arrays.asList(new BlockAttackSqlParser()));
//		return sqlExplainInterceptor;
//	}
	
	//公共字段填充器
	@Bean
	public MetaObjectHandler commonField() {
		return new CommonsFieldMetaObjectHandler();
	}
}
