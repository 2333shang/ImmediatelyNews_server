package com.shang.news.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shang.news.entities.Content;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author shang
 * @since 2020-03-14
 */
public interface ContentService extends IService<Content> {

	//获取本公司的新闻
	public List<Content> selectContent(String companyId, String newsType, String history);

	//获取本公司更多的新闻
	public List<Content> addMoreContent(String companyId, String newsType, String newsId, String history);

	//获取所有的视频
	public List<Content> selectContent(String newsType);
	
	//获取更多的视频
	public List<Content> getMoreContent(String newsType, String newsId);

	public void saveContentWithFile(Content content, String businesskey);

	public Content updateContent(Content content);

}
