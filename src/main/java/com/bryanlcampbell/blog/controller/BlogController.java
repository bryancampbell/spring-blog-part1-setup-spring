package com.bryanlcampbell.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BlogController {
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	@ResponseBody
	public String homePage() {
		return "<html><body>Hello <b>World</b></body></html>";
	}

}
