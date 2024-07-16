package com.mat.mvc.web;

import java.io.File;
import java.util.UUID;

import javax.annotation.*;

import org.slf4j.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

	@Controller
	@RequestMapping("/board/*")
	public class UploadController {	
		private static final Logger logger = LoggerFactory.getLogger(UploadController.class);	
		
		@Resource(name="uploadPath")
		private String uploadPath;
		
		@RequestMapping(value="/uploadForm", method=RequestMethod.GET)
		public void uploadForm() {
			
		}
		
		@RequestMapping(value="/uploadForm", method=RequestMethod.POST)
		public String uploadForm(MultipartFile file, Model model) throws Exception {
			logger.info("originalName: " + file.getOriginalFilename());
			logger.info("size: " + file.getSize());
			logger.info("contentType: " + file.getContentType());
			
			String savedName = uploadFile(file.getOriginalFilename(), file.getBytes());
			model.addAttribute("savedName", savedName);
			
			return "uploadResult";
			
		}
			
		private String uploadFile(String originalName, byte[] fileData) throws Exception {
			
			UUID uid = UUID.randomUUID();
			String savedName = uid.toString() + "_" + originalName;
			File target = new File(uploadPath, savedName);
			FileCopyUtils.copy(fileData, target);
			
			return savedName;
		}
		
		@RequestMapping(value="/board/uploadAjax", method=RequestMethod.GET)
		public String uploadAjax() {
			
			return "/board/uploadAjax";
		}
		
		
		
	}