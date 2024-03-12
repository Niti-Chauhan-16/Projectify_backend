package com.Projectify.first.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class user1 {
      
	@RequestMapping("/user")
	public String hello() {
		return "hello niti and congrats";
	}
}
