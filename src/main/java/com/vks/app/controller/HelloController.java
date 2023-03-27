package com.vks.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping(path = "/")
	public String welcome() {
		return "Wecome to Restful world SSL!!";
	}
}
