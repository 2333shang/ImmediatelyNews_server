package com.shang.news.config;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class NewsDateConverter implements Converter<String, LocalDate> {

	@Override
	public LocalDate convert(String source) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return LocalDate.parse(source, formatter);
	}

}
