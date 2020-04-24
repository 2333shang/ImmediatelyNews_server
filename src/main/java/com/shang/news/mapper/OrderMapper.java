package com.shang.news.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shang.news.entities.Order;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author shang
 * @since 2020-03-14
 */
public interface OrderMapper extends BaseMapper<Order> {

	public List<Order> getOrderCompany(String userId);

	public Order checkIfOrdered(String userId, String companyId);

	public List<Order> moreorder(String userId, String orderId);
	
}
