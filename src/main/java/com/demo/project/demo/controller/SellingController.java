package com.demo.project.demo.controller;

import com.demo.project.demo.entity.Book;
import com.demo.project.demo.service.SellingService;
import org.dataloader.DataLoader;

import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.graphql.execution.BatchLoaderRegistry;
import org.springframework.stereotype.Controller;

@Controller
public class SellingController {

	private final SellingService service;

	public SellingController(SellingService service) {
		this.service = service;
	}

	@SchemaMapping(typeName = "Book", field = "qtySold")
	public Integer qtySold(Book book, DataLoader<Book, Integer> dataLoader) {
		return service.getSelling(book).qtySold();
	}
}