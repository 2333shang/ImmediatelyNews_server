package com.shang.news.mapper;

import com.shang.news.entities.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author shang
 * @since 2020-03-14
 */
public interface UserMapper extends BaseMapper<User> {

	public User selectUserById(String userId);

}
