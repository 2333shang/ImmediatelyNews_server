package com.shang.news.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shang.news.entities.Top;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author shang
 * @since 2020-03-28
 */
@Mapper
public interface TopMapper extends BaseMapper<Top> {

	/**
	 * 查看首页新闻
	 * @param type:新闻类型
	 * @return
	 */
	public List<Top> getTopNews(String type);
	
	/**
	 * 得到更多的头条
	 * @return
	 */
	public List<Top> addMoreTopNews(String topId);

	public List<Top> getTodoTop();

	public List<Top> getMoreTodoTop(String topId);
	
	public List<Top> getHistoryTop(String applyStatus);
	
	public List<Top> getMoreHistoryTop(String applyStatus, String topId);

}
