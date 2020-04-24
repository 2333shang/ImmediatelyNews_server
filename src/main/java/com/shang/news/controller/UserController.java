package com.shang.news.controller;


import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.shang.news.entities.Attachment;
import com.shang.news.entities.User;
import com.shang.news.service.AttachmentService;
import com.shang.news.service.UserService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author shang
 * @since 2020-03-14
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private AttachmentService attachmentService;

	@RequestMapping("/login")
	public User login(HttpSession session, String username, String password) {
		User user = userService.checkLogin(username, password);
		if(user == null) {
			user = new User();
			user.setLoginMessage("0");
			return user;
		}
		user.setLoginMessage("1");
		session.setAttribute("login_user", user.getUsername());
		session.setAttribute("login_user_id", user.getId());
		session.setAttribute("company_id", user.getCompanyId());
		return user;
	}
	
	@RequestMapping("/logininvalid")
	public String logininvalid() {
		return "login_invalid";
	}
	
	@RequestMapping("/userinfo")
	public User userinfo(HttpSession session) {
		String userId = (String) session.getAttribute("login_user_id");
		return userService.getUserInfo(userId);
	}
	
	@RequestMapping("/userupdate")
	public User userupdate(HttpSession session, User user, String businesskey) {
		String userId = (String) session.getAttribute("login_user_id");
		user.setId(userId);
		return userService.updateUserInfo(user, businesskey);
	}
}

