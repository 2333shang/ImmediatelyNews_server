package com.shang.news.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shang.news.entities.Company;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author shang
 * @since 2020-03-14
 */
public interface CompanyMapper extends BaseMapper<Company> {

	public List<Company> getRandCompany();

	public List<Company> selectAllCompany(String userId);

	public List<Company> selectMoreCompany(String userId, String companyId);
}
