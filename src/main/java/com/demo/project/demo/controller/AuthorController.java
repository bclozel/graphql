package com.demo.project.demo.controller;

import java.util.List;
import java.util.Map;

import com.demo.project.demo.entity.Author;
import com.demo.project.demo.entity.Book;
import com.demo.project.demo.service.AuthorService;
import reactor.core.publisher.Mono;

import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.stereotype.Controller;

@Controller
public class AuthorController {

	private final AuthorService service;

	public AuthorController(AuthorService service) {
		this.service = service;
	}

	@BatchMapping
	public Mono<Map<Book, Author>> author(List<Book> books) {
		return service.getAuthors(books);
	}
}