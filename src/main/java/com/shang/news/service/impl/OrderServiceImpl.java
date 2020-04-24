package com.shang.news.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shang.news.entities.Order;
import com.shang.news.mapper.OrderMapper;
import com.shang.news.service.OrderService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shang
 * @since 2020-03-14
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

	@Override
	public List<Order> getOrders(String userId) {
		return baseMapper.getOrderCompany(userId);
	}

	@Override
	public Integer order(String userId, String companyId) {
		Order checkIfOrdered = baseMapper.checkIfOrdered(userId, companyId);
		if(checkIfOrdered != null) {
			checkIfOrdered.setOrderFlag("1");
			baseMapper.updateById(checkIfOrdered);
			return 1;
		}
		Order entity = new Order();
		entity.setOrderCompany(companyId);
		entity.setOrderFlag("1");
		entity.setOrderTime(LocalDateTime.now());
		entity.setOrderUser(userId);
		return baseMapper.insert(entity);
	}

	@Override
	public Integer cancelorder(String userId, String companyId) {
		UpdateWrapper<Order> updateWrapper = new UpdateWrapper<Order>();
		updateWrapper.eq("order_company", companyId);
		updateWrapper.eq("order_user", userId);
		updateWrapper.set("order_flag", "0");
		updateWrapper.set("order_time", LocalDateTime.now());
		return baseMapper.update(null, updateWrapper);
	}

	@Override
	public List<Order> moreorder(String userId, String orderId) {
		return baseMapper.moreorder(userId, orderId);
	}

}
