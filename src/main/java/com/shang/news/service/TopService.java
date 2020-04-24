package com.shang.news.service;

import com.shang.news.entities.Top;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author shang
 * @since 2020-03-28
 */
public interface TopService extends IService<Top> {

	//获取首页新闻
	public Map<String, List<Top>> getTopNews();
	
	//获取更多首页新闻
	public List<Top> getMoreTops(String newsId);

	public Integer applyTop(String newsId, String resousel);

	public List<Top> todoTop();

	public List<Top> moretodoTop(String topId);

	public List<Top> histop(String applyStatus);

	public List<Top> morehistop(String applyStatus, String topId);

	public Integer applytophandle(String topId, String applyAgree);

}
