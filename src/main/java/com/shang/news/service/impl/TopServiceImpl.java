package com.shang.news.service.impl;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shang.news.constant.TopConstant;
import com.shang.news.entities.Top;
import com.shang.news.mapper.TopMapper;
import com.shang.news.service.TopService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shang
 * @since 2020-03-28
 */
@Service
public class TopServiceImpl extends ServiceImpl<TopMapper, Top> implements TopService {

	@Override
	public Map<String, List<Top>> getTopNews() {
		Map<String, List<Top>> topnews = new HashMap<String, List<Top>>();
		topnews.put("1", baseMapper.getTopNews(TopConstant.NEWS_RESOUSEL));
		topnews.put("0", baseMapper.getTopNews(TopConstant.NEWS_COMMON));
		return topnews;
	}

	@Override
	public List<Top> getMoreTops(String topId) {
		return baseMapper.addMoreTopNews(topId);
	}

	@Override
	public Integer applyTop(String newsId, String resousel) {
		Top entity = new Top();
		entity.setNewsId(newsId);
		entity.setResousel(resousel);
		entity.setTopTime(LocalDateTime.now());
		entity.setApplyStatus("1");
		return baseMapper.insert(entity);
	}

	@Override
	public List<Top> todoTop() {
		return baseMapper.getTodoTop();
	}
	
	@Override
	public List<Top> moretodoTop(String topId) {
		return baseMapper.getMoreTodoTop(topId);
	}

	@Override
	public List<Top> histop(String applyStatus) {
		return baseMapper.getHistoryTop(applyStatus);
	}

	@Override
	public List<Top> morehistop(String applyStatus, String topId) {
		return baseMapper.getMoreHistoryTop(applyStatus, topId);
	}

	@Override
	public Integer applytophandle(String topId, String applyAgree) {
		UpdateWrapper<Top> updateWrapper = new UpdateWrapper<Top>();
		updateWrapper.eq("id", topId);
		updateWrapper.set("apply_status", applyAgree);
		updateWrapper.set("top_time", LocalDateTime.now());
		return baseMapper.update(null, updateWrapper);
	}

}
