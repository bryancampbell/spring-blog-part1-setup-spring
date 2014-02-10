package com.bryanlcampbell.blog.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ErrorHandlingController {
    
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	@RequestMapping("/not-found")
	public String pageNotFound() {
		return "<html><body>Sorry, page not found.</body></html>";
	}
    
}
