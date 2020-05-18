package com.shang.news.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.shang.news.entities.Attachment;
import com.shang.news.service.AttachmentService;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author shang
 * @since 2020-03-14
 */
@RestController
@RequestMapping("/attachment")
public class AttachmentController {
	
	@Autowired
	private AttachmentService attachmentService;

	@RequestMapping("/uploadattachment")
	public Attachment uploadattachment(@RequestParam("file") MultipartFile file, HttpSession session, String id, String preId, String attachmentType) {
		Attachment attachment = new Attachment();
		String businesskey = null;
		if(StringUtils.isEmpty(id)) {
			businesskey = preId;
			attachment.setUploaded("0");
		}else {
			businesskey = id;
			attachment.setUploaded("1");
		}
		String companyId = (String) session.getAttribute("company_id");
		String fileName = file.getOriginalFilename();
		attachment.setAttachmentType(attachmentType);
		attachment.setFileName(System.currentTimeMillis() + fileName);
		attachment.setBusinesskey(businesskey);
		try {
			attachment = attachmentService.saveFile(file.getBytes(), attachment, companyId);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return attachment;
	}
	
//	@RequestMapping("/adda")
//	public String adda(Attachment a) {
//		attachmentService.save(a);
//		return "add";
//	}
}
