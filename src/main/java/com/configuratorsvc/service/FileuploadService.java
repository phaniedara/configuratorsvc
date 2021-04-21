package com.configuratorsvc.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileuploadService {

	static Logger log = Logger.getLogger(FileuploadService.class);
	
	public String upoad(MultipartFile file) throws Exception {
		try {
			if(null == file || !StringUtils.hasLength(file.getOriginalFilename())) {
				throw new Exception("empty file provided");
			}
			if(!file.getContentType().equals("text/csv")) {
				throw new Exception("invalid file format");
			}
			log.info("file accepted: "+file.getOriginalFilename());
			String content = new String(file.getBytes());
			log.info(content);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e; 
		}
		return "fileupload success";
	}
}
