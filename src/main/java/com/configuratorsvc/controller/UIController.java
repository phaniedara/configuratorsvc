package com.configuratorsvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.configuratorsvc.service.FileuploadService;

@Controller
public class UIController {

	@Autowired
	private FileuploadService service;

	@GetMapping(value = "/fileupload")
    public String upload() {
		return "upload";
    }

    @PostMapping(value = "/fileupload")
	public String postUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) throws Exception {
    	redirectAttributes.addFlashAttribute("message", "selected file:"+file.getOriginalFilename());
    	service.upoad(file);
        return "redirect:/";
	}

    @GetMapping("/")
    public String index() {
        return "upload";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }
    
    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception exception, RedirectAttributes redirectAttributes) {

        ModelAndView mav = new ModelAndView();
        mav.addObject("message", exception.getMessage());
        mav.setViewName("error");
        return mav;
    }
}
