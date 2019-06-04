package com.cloud.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
public class DistributeController {
	
	private static final Logger log = LoggerFactory.getLogger(DistributeController.class);
	
	private ObjectMapper om = new ObjectMapper();
	
	@Autowired
	@Qualifier("loadBalancedRestTemplate")
	private RestTemplate loadBalancedRestTemplate;
	
	@RequestMapping(path="/addUser",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String distrubute(@RequestBody String request){
		log.info("接收报文：{}", request);
		String url = "http://USER-SERVICE/services/user/add";
		JsonNode requestNode = null;
		try {
			requestNode = om.readValue(request, JsonNode.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ObjectNode data = loadBalancedRestTemplate.postForEntity(url, requestNode, ObjectNode.class).getBody();
		log.info("返回报文：{}", data.toString());
		return data.toString();
	}
}