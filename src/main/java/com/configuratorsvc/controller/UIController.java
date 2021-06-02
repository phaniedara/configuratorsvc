package com.configuratorsvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.configuratorsvc.service.FileuploadService;

@Controller
@RequestMapping("/ui")
public class UIController {

	@Autowired
	private FileuploadService service;

	@GetMapping(value = "/fileupload")
    public String upload() {
		return "ui-upload";
    }

    @PostMapping(value = "/fileupload")
	public String postUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) throws Exception {
    	redirectAttributes.addFlashAttribute("message", "selected file:"+file.getOriginalFilename());
    	service.upoad(file);
        return "redirect:/ui";
	}

    @GetMapping
    public String index() {
        return "ui-upload";
    }

    @GetMapping("/login")
    public String login() {
        return "ui-login";
    }

    @GetMapping("/error")
    public String error() {
        return "ui-error";
    }
    
    @ExceptionHandler(Exception.class)
    public String handleException(Exception exception, RedirectAttributes redirectAttributes) {
    	redirectAttributes.addFlashAttribute("error", exception.getMessage());
    	return "redirect:/ui";
    }
}
