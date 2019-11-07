package com.tyss.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.dto.Book;
import com.tyss.dto.LibraryResponse;
import com.tyss.services.AllocateBookService;
import com.tyss.services.BookService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RequestMapping("/book")
public class BookController {
	@Autowired
	private BookService service;
	@Autowired
	private AllocateBookService bookService;

	@PostMapping(path = "/book", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public LibraryResponse addBook(@RequestBody Book book) {
		LibraryResponse response = new LibraryResponse();
		if (service.addBook(book)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("data  successfully stored..");
			bookService.removeBook(book.getbId());
		} else {
			response.setStatusCode(400);
			response.setMessage("failure");
			response.setDescription("data not successfully stored..");
		}
		return response;
	}

	@PutMapping(path = "/book", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public LibraryResponse updateBook(@RequestBody Book book) {
		LibraryResponse response = new LibraryResponse();
		if (service.updateBook(book)) {
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

	@DeleteMapping(path = "/book/{bId}", produces = MediaType.APPLICATION_JSON_VALUE)
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

	@GetMapping(path = "/book", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Book> getAllBook() {

		return service.getAllBook();
	}

	@GetMapping(path = "/book/{bName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public LibraryResponse searchBook1(@PathVariable("bName") String bName) {
		LibraryResponse response = new LibraryResponse();
		List<Book> list = service.searchBook(bName);
		if (list == null) {
			response.setStatusCode(400);
			response.setMessage("failure");
			response.setDescription("data not successfully access..");
		} else {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("data  successfully accessed..");
			response.setBook(list);
		}
		return response;
	}
}
