package com.demo.project.demo.controller;

import java.util.List;

import com.demo.project.demo.entity.Book;
import com.demo.project.demo.service.BookService;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {
	private final BookService service;

	public BookController(BookService service) {
		this.service = service;
	}

	@QueryMapping
	public List<Book> books(@Argument List<Integer> bookIds) {
		return service.getBooksByIds(bookIds);
	}
}