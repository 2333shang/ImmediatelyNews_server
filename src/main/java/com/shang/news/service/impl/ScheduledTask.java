package com.shang.news.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.shang.news.entities.Top;
import com.shang.news.service.TopService;

@EnableScheduling
public class ScheduledTask {
	
	@Autowired
	public TopService topService;
	
	@Scheduled(cron = "0 0 0 * * ?")
	public void aaa() {
		UpdateWrapper<Top> updateWrapper = new UpdateWrapper<Top>();
		updateWrapper.eq("apply_status", "1");
		updateWrapper.set("apply_status", "0");
		topService.update(updateWrapper);
	}
}
