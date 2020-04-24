package com.shang.news.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shang.news.entities.Company;
import com.shang.news.service.CompanyService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author shang
 * @since 2020-03-14
 */
@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	public CompanyService companyService;
	
	@RequestMapping("/companybyid")
	public Company companybyid(String companyId, String newsType) {
		return companyService.getCompanyById(companyId, newsType);
	}
	
//	@RequestMapping("/rand")
//	public List<Company> rand(String companyId, String newsType) {
//		return companyService.selectRandCompanies();
//	}
	
	@RequestMapping("company")
	public List<Company> company(HttpSession session){
		String userId = (String) session.getAttribute("login_user_id");
		return companyService.getAllCompany(userId);
	}
	
	@RequestMapping("morecompany")
	public List<Company> morecompany(HttpSession session, String companyId){
		String userId = (String) session.getAttribute("login_user_id");
		return companyService.getMoreCompany(userId, companyId);
	}
	
}

