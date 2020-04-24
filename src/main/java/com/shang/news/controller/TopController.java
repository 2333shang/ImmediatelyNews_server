package com.shang.news.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shang.news.constant.TopConstant;
import com.shang.news.entities.Top;
import com.shang.news.service.TopService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author shang
 * @since 2020-03-28
 */
@RestController
@RequestMapping("/top")
public class TopController {
	
	@Autowired
	private TopService topService;
	
	@RequestMapping("/seltop")
	public Map<String, List<Top>> seltop() {
		return topService.getTopNews();
	}
	
	@RequestMapping("/addmore")
	public List<Top> addmore(String topId) {
		return topService.getMoreTops(topId);
	}
	
	@RequestMapping("/applytop")
	public Integer applytop(String newsId, String resousel) {
		return topService.applyTop(newsId, resousel);
	}
	
	@RequestMapping("/applytopagree")
	public Integer applytopagree(String topId) {
		return topService.applytophandle(topId, TopConstant.APPLY_AGREE);
	}
	
	@RequestMapping("/applytopreject")
	public Integer applytopreject(String topId) {
		return topService.applytophandle(topId, TopConstant.APPLY_REJECT);
	}

	@RequestMapping("/todotop")
	public List<Top> todotop() {
		return topService.todoTop();
	}
	
	@RequestMapping("/moretodoTop")
	public List<Top> moretodoTop(String topId) {
		return topService.moretodoTop(topId);
	}
	
	@RequestMapping("/histop")
	public List<Top> histop(String applyStatus) {
		return topService.histop(applyStatus);
	}
	
	@RequestMapping("/morehistop")
	public List<Top> morehistop(String applyStatus, String topId) {
		return topService.morehistop(applyStatus, topId);
	}
}

