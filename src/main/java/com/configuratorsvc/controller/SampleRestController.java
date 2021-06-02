package com.configuratorsvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleRestController {

	@GetMapping(path = "/rest/content")
	public void getEndpoint() {
		System.out.println("test get message");
	}
	
	@RequestMapping(path = "/rest/content", method = RequestMethod.POST)
	public void postEndpoint() {
		System.out.println("test post message");
	}
}
