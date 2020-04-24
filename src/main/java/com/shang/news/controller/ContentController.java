package com.shang.news.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shang.news.entities.Content;
import com.shang.news.service.ContentService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author shang
 * @since 2020-03-14
 */
@RestController
@RequestMapping("/content")
public class ContentController {
	
	@Autowired
	private ContentService contentService;

	@RequestMapping("/addnews")
	public Content add(HttpSession session, Content content, String businesskey) {
		content.setAuthorId((String) session.getAttribute("login_user_id"));
		content.setCompanyId((String) session.getAttribute("company_id"));
		contentService.saveContentWithFile(content, businesskey);
		return content;
	}
	
	@RequestMapping("/owner")
	public List<Content> owner(HttpSession session, String newsType, String history) {
		String companyId = (String) session.getAttribute("company_id");
		List<Content> content_list = contentService.selectContent(companyId, newsType, history);
		return content_list;
	}
	
	@RequestMapping("/addmore")
	public List<Content> addmore(HttpSession session, String companyId, String newsType, String newsId, String history) {
		//查看其它企业
		if(StringUtils.isNotEmpty(companyId)) {
			return contentService.addMoreContent(companyId, newsType, newsId, history);
		}
		//查看本司
		companyId = (String) session.getAttribute("company_id");
		return contentService.addMoreContent(companyId, newsType, newsId, history);
	}
	
	@RequestMapping("/video")
	public List<Content> video() {
		return contentService.selectContent("1");
	}
	
	@RequestMapping("/morevideo")
	public List<Content> morevideo(String newsId) {
		return contentService.getMoreContent("1", newsId);
	}
	
	@RequestMapping("/content")
	public List<Content> content() {
		return contentService.selectContent("0");
	}
	
	@RequestMapping("/morecontent")
	public List<Content> morecontent(String newsId) {
		return contentService.getMoreContent("0", newsId);
	}
	
	@RequestMapping("/delcontent")
	public Boolean delcontent(String newsId) {
		return contentService.removeById(newsId);
	}
	
	@RequestMapping("/updatecontent")
	public Content updatecontent(Content content) {
		return contentService.updateContent(content);
	}
}

