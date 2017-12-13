package com.rmbin.springboothello.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
	
	@RequestMapping("/helloStr")
	public String sayHello()
	{
		return "Hello, Louis He";
	}
	
	

}
