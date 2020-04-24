package com.shang.news.mapper;

import com.shang.news.entities.Collect;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author shang
 * @since 2020-03-28
 */
public interface CollectMapper extends BaseMapper<Collect> {

	public List<Collect> getCollectNews(String userId);

	public Collect checkIfCollected(String userId, String newsId);

	public List<Collect> morecollects(String userId, String collectId);

}
