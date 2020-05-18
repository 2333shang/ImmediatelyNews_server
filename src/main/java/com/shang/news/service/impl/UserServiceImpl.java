package com.shang.news.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shang.news.constant.FileUploadConstant;
import com.shang.news.entities.Attachment;
import com.shang.news.entities.AttachmentSetting;
import com.shang.news.entities.Company;
import com.shang.news.entities.User;
import com.shang.news.mapper.AttachmentMapper;
import com.shang.news.mapper.AttachmentSettingMapper;
import com.shang.news.mapper.CompanyMapper;
import com.shang.news.mapper.UserMapper;
import com.shang.news.service.UserService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shang
 * @since 2020-03-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

	@Autowired
	private AttachmentMapper attachmentMapper;
	@Autowired
	private AttachmentSettingMapper attachmentSettingMapper;
	@Autowired
	private CompanyMapper companyMapper;
	
	@Override
	public User checkLogin(String username, String password) {
		QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
		queryWrapper.eq("username", username);
		queryWrapper.eq("password", password);
		User selectOne = baseMapper.selectOne(queryWrapper);
		Company selectById = companyMapper.selectById(selectOne.getCompanyId());
		selectOne.setCompanyName(selectById.getCompanyName());
		QueryWrapper<AttachmentSetting> queryWrapper2 = new QueryWrapper<AttachmentSetting>();
		queryWrapper2.eq("companyid", selectById.getId());
		AttachmentSetting selectOne2 = attachmentSettingMapper.selectOne(queryWrapper2);
		QueryWrapper<Attachment> queryWrapper3 = new QueryWrapper<Attachment>();
		queryWrapper3.eq("businesskey", selectOne.getId());
		Attachment selectOne3 = attachmentMapper.selectOne(queryWrapper3);
		if(selectOne3 != null) {
			Attachment headIcon = new Attachment();
			if(selectOne3.getFilePath() == null) {
				headIcon.setUrl(FileUploadConstant.FILE_NET + FileUploadConstant.FILE_CONTEXT_PATH + FileUploadConstant.FILE_REAL_PATH + "/" + selectOne3.getFileName());
			}else {
				headIcon.setUrl(FileUploadConstant.FILE_NET + FileUploadConstant.FILE_CONTEXT_PATH + FileUploadConstant.FILE_REAL_PATH + selectOne2.getBasepath() + selectOne3.getFilePath() + "/" + selectOne3.getFileName());
			}
			selectOne.setHeadIcon(headIcon);
		}
		return selectOne;
	}

	@Override
	public User getUserInfo(String userId) {
		return baseMapper.selectUserById(userId);
	}

	@Override
	public User updateUserInfo(User user, String businesskey) {
		System.out.println(user);
		System.out.println(businesskey);
		baseMapper.updateById(user);
		if(businesskey != null) {
			QueryWrapper<Attachment> wrapper = new QueryWrapper<Attachment>();
			wrapper.eq("businesskey", user.getId());
			attachmentMapper.delete(wrapper);
			UpdateWrapper<Attachment> updateWrapper = new UpdateWrapper<Attachment>();
			updateWrapper.set("businesskey", user.getId());
			updateWrapper.set("uploaded", "1");
			updateWrapper.eq("businesskey", businesskey);
			attachmentMapper.update(null, updateWrapper);
		}
		return user;
	}
	
}
