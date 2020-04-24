package com.shang.news.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shang.news.constant.FileUploadConstant;
import com.shang.news.entities.Attachment;
import com.shang.news.entities.AttachmentSetting;
import com.shang.news.mapper.AttachmentMapper;
import com.shang.news.mapper.AttachmentSettingMapper;
import com.shang.news.service.AttachmentService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shang
 * @since 2020-03-14
 */
@Service
public class AttachmentServiceImpl extends ServiceImpl<AttachmentMapper, Attachment> implements AttachmentService {

	@Autowired
	public AttachmentSettingMapper attachmentSettingMapper;
	
	@Override
	public Attachment saveFile(byte[] data, Attachment attachment, String companyId) {
		String filepath = DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDate.now());
		attachment.setFilePath("/" + filepath);
		baseMapper.insert(attachment);
		QueryWrapper<AttachmentSetting> queryWrapper = new QueryWrapper<AttachmentSetting>();
		queryWrapper.eq("companyid", companyId);
		AttachmentSetting selectOne = attachmentSettingMapper.selectOne(queryWrapper);
		String fullPath = selectOne.getBasepath() + "/" + filepath + "/";
		try {
			uploadFile(data, fullPath, attachment.getFileName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		attachment.setUrl(FileUploadConstant.FILE_NET + FileUploadConstant.FILE_CONTEXT_PATH + FileUploadConstant.FILE_REAL_PATH + fullPath + attachment.getFileName());
		return attachment;
	}

	public void uploadFile(byte[] file, String filePath, String fileName) throws Exception { 
		String path = new ApplicationHome(getClass()).getSource().getParentFile().toString() + "/" + FileUploadConstant.FILE_PATH + filePath;
		System.out.println(path);
        File targetFile = new File(path);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }       
        FileOutputStream out = new FileOutputStream(path+fileName);
        out.write(file);
        out.flush();
        out.close();
    }

//	@Override
//	public String getFilePath(String companyId) {
//		QueryWrapper<AttachmentSetting> queryWrapper = new QueryWrapper<AttachmentSetting>();
//		queryWrapper.eq("companyid", companyId);
//		AttachmentSetting selectOne = attachmentSettingMapper.selectOne(queryWrapper);
////		baseMapper.
//		return null;
//	}
}
