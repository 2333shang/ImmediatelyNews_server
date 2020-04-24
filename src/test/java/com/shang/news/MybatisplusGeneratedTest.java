package com.shang.news;

import org.junit.jupiter.api.Test;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class MybatisplusGeneratedTest {

	@Test
	public void test() {

		//设置全局配置
		 GlobalConfig config = new GlobalConfig();
		 String projectPath = System.getProperty("user.dir");
		 config.setActiveRecord(true)//是否支持AR模式
		 		.setAuthor("shang")//设置作者
		 		.setOutputDir(projectPath + "/src/main/java")//设置生成路径
		 		.setFileOverride(true)//设置文件是否覆盖
		 		.setIdType(IdType.AUTO)//设置主键策略
		 		.setServiceName("%sService")//设置生成的Service接口的名字的首字母是否为I
		 		.setBaseResultMap(true)//是否生成基本的ResultMap
		 		.setBaseColumnList(true)//生成基本的sql片段
		 		.setFileOverride(false);//是否覆盖同名文件，默认是false
		 
		 //设置数据源配置
		 DataSourceConfig dsConfig = new DataSourceConfig();
		 dsConfig.setDbType(DbType.MYSQL)//设置数据库类型
		 		 .setUsername("root")//设置用户名
		 		 .setPassword("")//设置密码
		 		 .setUrl("jdbc:mysql://localhost:3306/immediatelynews?serverTimezone=UTC")
		 		 .setDriverName("com.mysql.cj.jdbc.Driver");
		 
		 //设置策略配置
		 StrategyConfig strategyConfig = new StrategyConfig();
		 strategyConfig.setCapitalMode(true)//全局大写命名
		 				.setNaming(NamingStrategy.underline_to_camel)//下划线转驼峰命名
		 				.setTablePrefix("news_");//设置表前缀
//		 				.setInclude("news_user");//设置需要包含的表名，允许正则表达式（与exclude二选一配置）
		 
		 //报名策略配置
		 PackageConfig pConfig = new PackageConfig();
		 pConfig.setParent("com.shang.news")
		 		.setMapper("mapper")
		 		.setService("service")
		 		.setController("controller")
		 		.setEntity("entities")
		 		.setXml("mapper");
		 
		 //整合配置
		 AutoGenerator ag = new AutoGenerator();
		 ag.setGlobalConfig(config)
		   .setDataSource(dsConfig)
		   .setStrategy(strategyConfig)
		   .setPackageInfo(pConfig);
		 ag.execute();
		 
	}
	
}
