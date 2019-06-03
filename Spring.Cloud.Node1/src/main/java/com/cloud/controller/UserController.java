package com.cloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	private ObjectMapper om = new ObjectMapper();
	
	@RequestMapping(path="/add",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String add(@RequestBody String request){
		log.info("接收报文：{}", request);
		ObjectNode data = om.createObjectNode();
		data.put("success", "true");
		data.put("message", "操作成功");
		data.put("data", request);
		return data.toString();
	}
}