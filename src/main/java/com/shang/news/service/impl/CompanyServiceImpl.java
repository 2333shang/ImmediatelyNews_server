package com.shang.news.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shang.news.entities.Company;
import com.shang.news.entities.Content;
import com.shang.news.mapper.CompanyMapper;
import com.shang.news.mapper.ContentMapper;
import com.shang.news.service.CompanyService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shang
 * @since 2020-03-14
 */
@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements CompanyService {

	@Autowired
	public ContentMapper contentMapper;
	
	@Override
	public List<Company> selectRandCompanies() {
		return baseMapper.getRandCompany();
	}

	@Override
	public Company getCompanyById(String companyId, String newsType) {
		Company company = baseMapper.selectById(companyId);
		System.out.println(companyId);
		List<Content> contents = contentMapper.selectContentByCompanyId(companyId, newsType, null);
		if("0".equals(newsType)) {
			company.setContent(contents);
		}else if("1".equals(newsType)) {
			company.setVideoContent(contents);
		}
		return company;
	}

	@Override
	public List<Company> getAllCompany(String userId) {
		return baseMapper.selectAllCompany(userId);
	}

	@Override
	public List<Company> getMoreCompany(String userId, String companyId) {
		return baseMapper.selectMoreCompany(userId, companyId);
	}
}
