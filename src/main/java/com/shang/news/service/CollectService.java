package com.shang.news.service;

import com.shang.news.entities.Collect;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author shang
 * @since 2020-03-28
 */
public interface CollectService extends IService<Collect> {

	public List<Collect> getCollects(String userId);

	public Integer collect(String userId, String newsId);

	public Integer cancelcollect(String userId, String newsId);

	public List<Collect> morecollects(String userId, String collectId);

	public Collect checkedCollect(String userId, String newsId);

}
