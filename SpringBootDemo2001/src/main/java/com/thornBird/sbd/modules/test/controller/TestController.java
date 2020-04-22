package com.thornBird.sbd.modules.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thornBird.sbd.modules.test.controller.vo.ConfigBean;

@RestController
@RequestMapping("/api/test")
public class TestController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(TestController.class);

	@Value("${server.port}")
	private int port;
	@Value("${com.thornBird.name}")
	private String name;
	@Value("${com.thornBird.age}")
	private int age;
	@Value("${com.thornBird.desc}")
	private String desc;
	@Value("${com.thornBird.random}")
	private String random;
	
	@Autowired
	private ConfigBean configbean;
	
	/**
	 * http://127.0.0.1/api/test/log
	 */
	@RequestMapping("/log")
	public String logTest(){
		//TRACE<DEBUG<INFO<WARN<ERROR
		LOGGER.trace("this is TRACE log.");
		LOGGER.debug("Tis is DEBUG log.");
		LOGGER.info("Tis is INFO log.");
		LOGGER.warn("Tis is WARN log.");
		LOGGER.error("Tis is ERROR log.22222");
		return "this is log test.";
	}
	
	
	/**
	 * http://127.0.0.1/api/test/config
	 */
	@RequestMapping("/config")
	public String configTest(){
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append(port).append("-----")
			   .append(name).append("-----")
			   .append(age).append("-----")
			   .append(desc).append("-----")
			   .append(random).append("-----").append("</br>");
		sBuffer.append(configbean.getName()).append("-----")
			   .append(configbean.getAge()).append("-----")
			   .append(configbean.getDesc()).append("-----")
			   .append(configbean.getRandom()).append("-----");
		return sBuffer.toString();
	}
	
	/**
	 * http://127.0.0.1/api/test/appDesc
	 */
	@RequestMapping("/appDesc")
	public String getAppDsc(){
		return "Hello world,this is spring boot demo.";
	}
}
