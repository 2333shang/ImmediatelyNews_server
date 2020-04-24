package com.shang.news.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shang.news.entities.Collect;
import com.shang.news.service.CollectService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author shang
 * @since 2020-03-28
 */
@RestController
@RequestMapping("/collect")
public class CollectController {
	
	@Autowired
	public CollectService collectService;

	@RequestMapping("/collects")
	public List<Collect> collects(HttpSession session) {
		String login_user_id = (String) session.getAttribute("login_user_id");
		return collectService.getCollects(login_user_id);
	}
	
	@RequestMapping("/morecollects")
	public List<Collect> morecollects(HttpSession session, String collectId) {
		String login_user_id = (String) session.getAttribute("login_user_id");
		return collectService.morecollects(login_user_id, collectId);
	}
	
	@RequestMapping("/collect")
	public Integer collect(HttpSession session, String newsId) {
		String login_user_id = (String) session.getAttribute("login_user_id");
		return collectService.collect(login_user_id, newsId);
	}
	
	@RequestMapping("/cancelcollect")
	public Integer cancelcollect(HttpSession session, String newsId){
		String login_user_id = (String) session.getAttribute("login_user_id");
		return collectService.cancelcollect(login_user_id, newsId);
	}
	
	@RequestMapping("/collected")
	public Collect collected(HttpSession session, String newsId){
		String login_user_id = (String) session.getAttribute("login_user_id");
		return collectService.checkedCollect(login_user_id, newsId);
	}
}

