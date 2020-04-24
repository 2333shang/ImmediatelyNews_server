package com.shang.news.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shang.news.entities.Content;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author shang
 * @since 2020-03-14
 */
public interface ContentMapper extends BaseMapper<Content> {

	public List<Content> addMore(String companyId, String newsType, String newsId, String history);

	public List<Content> selectContentByCompanyId(String companyId, String newsType, String history);

	public List<Content> getContent(String newsType);

	public List<Content> selectMoreContent(String newsType, String newsId);
}
