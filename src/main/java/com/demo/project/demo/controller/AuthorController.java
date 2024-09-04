package com.demo.project.demo.controller;

import java.util.concurrent.CompletableFuture;

import com.demo.project.demo.entity.Author;
import com.demo.project.demo.entity.Book;
import com.demo.project.demo.service.AuthorService;

import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class AuthorController {

	private final AuthorService service;

	public AuthorController(AuthorService service) {
		this.service = service;
	}

	@SchemaMapping(typeName = "Book", field = "author")
	public CompletableFuture<Author> books(Book book) {
		return service.getAuthor(book);
	}
}