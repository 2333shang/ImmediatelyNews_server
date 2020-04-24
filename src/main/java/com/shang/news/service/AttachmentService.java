package com.shang.news.service;

import com.shang.news.entities.Attachment;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author shang
 * @since 2020-03-14
 */
public interface AttachmentService extends IService<Attachment> {

//	public void update

	public Attachment saveFile(byte[] data, Attachment attachment, String companyId);
	
//	public String getFilePath(String companyId);
}
