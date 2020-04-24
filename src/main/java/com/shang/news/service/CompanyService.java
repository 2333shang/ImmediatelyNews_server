package com.shang.news.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shang.news.entities.Company;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author shang
 * @since 2020-03-14
 */
public interface CompanyService extends IService<Company> {

	//随机获取公司
	public List<Company> selectRandCompanies();
	
	//获取指定编号的公司以及下面的新闻
	public Company getCompanyById(String companyId, String newsType);

	public List<Company> getAllCompany(String userId);

	public List<Company> getMoreCompany(String userId, String companyId);

}
