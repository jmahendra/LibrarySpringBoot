package com.tyss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.dto.Admin;
import com.tyss.services.AdminService;

@RestController
@CrossOrigin(origins="*",allowedHeaders="*",allowCredentials="true")
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService service;

	
	@PostMapping(path="/admin",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public boolean registeradmin(@RequestBody Admin admin) {
		
		return service.register(admin);
	}
	@PostMapping(path="/admin/{email}/{password}",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public boolean login(@PathVariable("email")String email, @PathVariable("password")String password) {
		
		return service.login(email, password);
	}
	@GetMapping(path="/admin",produces=MediaType.APPLICATION_JSON_VALUE)
	public Admin login() {
		
		return service.login();
	}
	@PutMapping(path="/admin/{email}/{password}",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public boolean changePassword(@PathVariable("email")String email, @PathVariable("password")String password) {
		
		return service.changePassword(email, password);
	}
}
