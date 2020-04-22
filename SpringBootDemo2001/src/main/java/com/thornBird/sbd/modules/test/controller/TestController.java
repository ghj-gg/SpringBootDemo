package com.thornBird.sbd.modules.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	@RequestMapping("/api/test/appDesc")
	@ResponseBody
	public String getAppDsc(){
		return "Hello world,this is spring boot demo.";
	}
}
