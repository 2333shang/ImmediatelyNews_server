package com.shang.news.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shang.news.entities.Attachment;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author shang
 * @since 2020-03-14
 */
public interface AttachmentMapper extends BaseMapper<Attachment> {

	public List<Attachment> getAttachmentPics(String businesskey, String companyId);
}
