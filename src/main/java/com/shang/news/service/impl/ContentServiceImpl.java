package com.shang.news.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shang.news.entities.Attachment;
import com.shang.news.entities.Content;
import com.shang.news.mapper.AttachmentMapper;
import com.shang.news.mapper.ContentMapper;
import com.shang.news.service.ContentService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shang
 * @since 2020-03-14
 */
@Service
public class ContentServiceImpl extends ServiceImpl<ContentMapper, Content> implements ContentService {

	@Autowired
	private AttachmentMapper attachmentMapper;
	
	@Override
	public List<Content> selectContent(String companyId, String newsType, String history) {
		return baseMapper.selectContentByCompanyId(companyId, newsType, history);
	}

	@Override
	public List<Content> addMoreContent(String companyId, String newsType, String newsId, String history) {
		return baseMapper.addMore(companyId, newsType, newsId, history);
	}

	@Override
	public List<Content> selectContent(String newsType) {
		return baseMapper.getContent(newsType);
	}

	@Override
	public List<Content> getMoreContent(String newsType, String newsId) {
		return baseMapper.selectMoreContent(newsType, newsId);
	}

	@Override
	public void saveContentWithFile(Content content, String businesskey) {
		baseMapper.insert(content);
		UpdateWrapper<Attachment> updateWrapper = new UpdateWrapper<Attachment>();
		updateWrapper.set("uploaded", "1");
		updateWrapper.set("businesskey", content.getId());
		updateWrapper.eq("businesskey", businesskey);
		attachmentMapper.update(null, updateWrapper);
	}

	@Override
	public Content updateContent(Content content) {
		baseMapper.updateById(content);
		String id = content.getId();
		QueryWrapper<Attachment> queryWrapper = new QueryWrapper<Attachment>();
		queryWrapper.eq("businesskey", id);
		List<Attachment> list = attachmentMapper.selectList(queryWrapper);
		System.out.println(list.size());
		for(Attachment a:list) {
			System.out.println(a);
			String fileName = a.getFileName();
			if(content.getContent() != null && !content.getContent().contains(fileName)) {
				System.out.println("delete");
				attachmentMapper.deleteById(a.getId());
			}
		}
		return content;
	}

}
