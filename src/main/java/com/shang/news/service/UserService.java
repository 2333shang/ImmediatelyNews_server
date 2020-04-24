package com.shang.news.service;

import com.shang.news.entities.Attachment;
import com.shang.news.entities.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author shang
 * @since 2020-03-14
 */
public interface UserService extends IService<User> {

	//检查登陆
	public User checkLogin(String username, String password);

	public User getUserInfo(String userId);

	public User updateUserInfo(User user, String businesskey);

}
