package com.tyss.controller;

import java.util.Arrays;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.dto.LibraryResponse;
import com.tyss.dto.User;
import com.tyss.services.UserService;

@RestController
@CrossOrigin(origins="*",allowedHeaders="*",allowCredentials="true")
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService service;

	@PostMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public LibraryResponse userRegister(@RequestBody User user) {
		LibraryResponse response = new LibraryResponse();
		if (service.userRegister(user)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("data  successfully stored..");
		} else {
			response.setStatusCode(400);
			response.setMessage("failure");
			response.setDescription("data not successfully stored..");
		}
		return response;
	}

	@PostMapping(path = "/user/{email}/{password}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public User Login(@PathVariable("email") String uEmail, @PathVariable("password") String uPassword) {
		return service.userLogin(uEmail, uPassword);
	}

	@PutMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public LibraryResponse updateRegister(@RequestBody User user) {
		LibraryResponse response = new LibraryResponse();
		if (service.userUpdate(user)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("data  successfully updated..");
		} else {
			response.setStatusCode(400);
			response.setMessage("failure");
			response.setDescription("data not successfully updated..");
		}
		return response;
	}

	@DeleteMapping(path = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public LibraryResponse deleteUser(@PathVariable("id") int uId) {
		LibraryResponse response = new LibraryResponse();
		if (service.userDelete(uId)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("data  successfully deleted..");
		} else {
			response.setStatusCode(400);
			response.setMessage("failure");
			response.setDescription("data not successfully deleted..");
		}
		return response;
	}

	@GetMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
	public LibraryResponse getAll() {
		LibraryResponse response = new LibraryResponse();
		List<User> list = service.userGet();
		if (list == null) {
			response.setStatusCode(400);
			response.setMessage("failure");
			response.setDescription("data not successfully stored..");
		} else {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("data  successfully stored..");
			response.setUser(list);
		}
		return response;
	}
	@PutMapping(path="/user/{email}/{password}",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public boolean changePassword(@PathVariable("email")String uEmail, @PathVariable("password")String uPassword) {
		
		return service.changePassword(uEmail, uPassword);
	}
}
