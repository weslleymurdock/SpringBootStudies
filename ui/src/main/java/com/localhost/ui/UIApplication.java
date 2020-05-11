package com.localhost.ui;

import java.security.Principal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class UIApplication {

	@GetMapping("/user")
	@ResponseBody
	public Principal user(Principal user) {
		return user;
	}

	@RequestMapping("/resource")
	@ResponseBody
	public Map<String, Object> resource() {
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("id", UUID.randomUUID().toString());
	model.put("content", "Hello World from resource");
	return model;
	}

	@RequestMapping(value = "/{path:[^\\.]*}")
	public String redirect() {
		return "forward:/";
	}

	public static void main(String[] args) {
		SpringApplication.run(UIApplication.class, args);
	}

	@RequestMapping("/token")
  	public Map<String,String> token(HttpSession session) {
    	return Collections.singletonMap("token", session.getId());
  	}
}