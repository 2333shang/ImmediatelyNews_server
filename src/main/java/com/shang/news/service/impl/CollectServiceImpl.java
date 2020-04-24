	package com.shang.news.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shang.news.entities.Collect;
import com.shang.news.mapper.CollectMapper;
import com.shang.news.service.CollectService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shang
 * @since 2020-03-28
 */
@Service
public class CollectServiceImpl extends ServiceImpl<CollectMapper, Collect> implements CollectService {

	@Override
	public List<Collect> getCollects(String userId) {
		return baseMapper.getCollectNews(userId);
	}

	@Override
	public Integer collect(String userId, String newsId) {
		Collect checkIfCollected = baseMapper.checkIfCollected(userId, newsId);
		if(checkIfCollected != null) {
			checkIfCollected.setCollectFlag("1");
			baseMapper.updateById(checkIfCollected);
			return 1;
		}
		Collect entity = new Collect();
		entity.setRelatedId(newsId);
		entity.setRelationUser(userId);
		entity.setCollectFlag("1");
		entity.setCollectTime(LocalDateTime.now());
		return baseMapper.insert(entity);
	}

	@Override
	public Integer cancelcollect(String userId, String newsId) {
		UpdateWrapper<Collect> updateWrapper = new UpdateWrapper<Collect>();
		updateWrapper.eq("related_id", newsId);
		updateWrapper.eq("relation_user", userId);
		updateWrapper.set("collect_flag", "0");
		updateWrapper.set("collect_time", LocalDateTime.now());
		return baseMapper.update(null, updateWrapper);
	}

	@Override
	public List<Collect> morecollects(String userId, String collectId) {
		return baseMapper.morecollects(userId, collectId);
	}

	@Override
	public Collect checkedCollect(String userId, String newsId) {
		return baseMapper.checkIfCollected(userId, newsId);
	}

}
