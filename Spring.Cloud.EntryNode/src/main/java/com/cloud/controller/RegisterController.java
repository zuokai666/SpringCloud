package com.cloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.DiscoveryManager;

@SuppressWarnings("deprecation")
@RestController
public class RegisterController {
    
	@RequestMapping(value = "/offline", method = RequestMethod.GET)
    public void offLine(){
        DiscoveryManager.getInstance().shutdownComponent();
    }
}