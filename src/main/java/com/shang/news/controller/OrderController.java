package com.shang.news.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shang.news.entities.Company;
import com.shang.news.entities.Order;
import com.shang.news.service.CompanyService;
import com.shang.news.service.OrderService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author shang
 * @since 2020-03-14
 */
@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	@Autowired
	private CompanyService companyService;
	
	@RequestMapping("/orders")
	public List<Order> getOrders(HttpSession session){
		String login_user_id = (String) session.getAttribute("login_user_id");
		return orderService.getOrders(login_user_id);
	}
	
	@RequestMapping("/moreorder")
	public List<Order> moreorder(HttpSession session, String orderId){
		String login_user_id = (String) session.getAttribute("login_user_id");
		return orderService.moreorder(login_user_id, orderId);
	}
	
	@RequestMapping("/order")
	public Integer order(HttpSession session, String companyId){
		String login_user_id = (String) session.getAttribute("login_user_id");
		return orderService.order(login_user_id, companyId);
	}
	
	@RequestMapping("/cancelorder")
	public Integer cancelorder(HttpSession session, String companyId){
		String login_user_id = (String) session.getAttribute("login_user_id");
		return orderService.cancelorder(login_user_id, companyId);
	}
}

