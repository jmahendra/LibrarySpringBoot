package com.tyss.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.dto.Book;
import com.tyss.dto.BookAction;
import com.tyss.dto.LibraryResponse;
import com.tyss.services.BookActionService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RequestMapping("/bookaction")
public class BookActionController {
	@Autowired
	private BookActionService service;

	@PostMapping(path = "/bookaction/{uId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public LibraryResponse addBook(@RequestBody BookAction bookAction,@PathVariable("uId") int uId) {
		LibraryResponse response = new LibraryResponse();
		bookAction.setuId(uId);
		if (service.addBook(bookAction)) {
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

	@GetMapping(path = "/bookaction", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<BookAction> getAllBook() {

		return service.getAllBook();
	}

	@DeleteMapping(path = "/bookaction/{bId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public LibraryResponse searchBook1(@PathVariable("bId") int bId) {
		LibraryResponse response = new LibraryResponse();
		if (service.removeBook(bId)) {
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
}
