package com.tyss.controller;


import java.util.Calendar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.dto.AllocateBook;
import com.tyss.dto.BookAction;
import com.tyss.dto.LibraryResponse;
import com.tyss.services.AllocateBookService;
import com.tyss.services.BookActionService;
import com.tyss.services.BookService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RequestMapping("/allocate")
public class AllocateBookController {
	@Autowired
	private AllocateBookService service;
	@Autowired
	private BookActionService service1;

	@Autowired
	private BookService service2;

	@PostMapping(path = "/allocate", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public LibraryResponse addBook(@RequestBody AllocateBook book) {
		java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
		System.out.println(date);
		book.setDate(date);
		
		LibraryResponse response = new LibraryResponse();
		if (service.allocateBook(book)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("data  successfully stored..");
		} else {
			response.setStatusCode(400);
			response.setMessage("failure");
			response.setDescription("data not successfully stored..");
		}
		boolean b = service1.removeBook(book.getbId());
		boolean b2 = service2.removeBook(book.getbId());
		System.out.println(b);
		System.out.println(b2);
		return response;
	}

	@GetMapping(path = "/allocate/{uId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AllocateBook> getAllBook(@PathVariable("uId")int uId) {

		return service.getAllBook(uId);
	}
}
