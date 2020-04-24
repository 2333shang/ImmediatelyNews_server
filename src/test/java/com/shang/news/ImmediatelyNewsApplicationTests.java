package com.shang.news;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shang.news.constant.TopConstant;
import com.shang.news.entities.Top;
import com.shang.news.mapper.TopMapper;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ImmediatelyNewsApplicationTests {

	@Autowired
	private DataSource dataSource;
	
	@Test
	void testDataSource() throws SQLException {
		System.out.println(dataSource);
		System.out.println(dataSource.getConnection());
	}
	
	@Autowired
	private TopMapper topMapper;
	
	@Test
	void testGetTopNews() throws SQLException {
		List<Top> topResouselNews = topMapper.getTopNews(TopConstant.NEWS_RESOUSEL);
		for(Top top:topResouselNews) {
			System.out.println(top);
//			System.out.println(top.getContent());
		}
	}
	
	@Test
	void testAddMoreNews() throws SQLException {
		List<Top> topResouselNews = topMapper.addMoreTopNews("12");
		for(Top top:topResouselNews) {
			System.out.print(top + ":");
			System.out.println(top.getContent());
		}
	}

}
