package com.tyss.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.dto.Librarian;
import com.tyss.services.LibService;

@RestController
@CrossOrigin(origins="*",allowedHeaders="*",allowCredentials="true")
@RequestMapping("/lib")
public class LibController {
	@Autowired
	private LibService service;

	@PostMapping(path = "/lib", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean register(@RequestBody Librarian librarian) {
		return service.register(librarian);
	}

	@PostMapping(path = "/lib/{email}/{password}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean login(@PathVariable("email") String lEmail, @PathVariable("password") String lPassword) {
		return service.login(lEmail, lPassword);
	}
}
