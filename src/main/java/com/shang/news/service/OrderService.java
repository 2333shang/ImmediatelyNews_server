package com.shang.news.service;

import com.shang.news.entities.Order;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author shang
 * @since 2020-03-14
 */
public interface OrderService extends IService<Order> {

	//获取登录用户关注的公司
	public List<Order> getOrders(String userId);

	public Integer order(String userId, String companyId);

	public Integer cancelorder(String userId, String companyId);

	public List<Order> moreorder(String login_user_id, String orderId);

}
