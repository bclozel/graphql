package com.demo.project.demo.service;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import com.demo.project.demo.ThreadHelper;
import com.demo.project.demo.entity.Author;
import com.demo.project.demo.entity.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import org.springframework.stereotype.Service;

@Service
public class AuthorService {

	private static final Logger log = LoggerFactory.getLogger(AuthorService.class);

	private final List<Author> authors = List.of(
			new Author(1, "First 1", "Last 1"),
			new Author(2, "First 2", "Last 2"),
			new Author(3, "First 3", "Last 3"),
			new Author(4, "First 4", "Last 4"),
			new Author(5, "First 5", "Last 5"),
			new Author(6, "First 6", "Last 6")
	);

	public AuthorService() {
	}

	public Mono<Map<Book, Author>> getAuthors(List<Book> books) {
		return Mono.fromSupplier(() -> books.stream().collect(Collectors.toMap(book -> book, this::getAuthorInternal)))
				.delayElement(Duration.ofSeconds(1))
				.doOnNext(map -> ThreadHelper.log(log, Thread.currentThread(), AuthorService.class, "getAuthors"));
	}

	public CompletableFuture<Author> getAuthor(Book book) {
		return CompletableFuture.supplyAsync(() -> {
			ThreadHelper.log(log, Thread.currentThread(), AuthorService.class, "getAuthor");
			ThreadHelper.sleep(1000);
			return getAuthorInternal(book);
		});
	}


	private Author getAuthorInternal(Book book) {
		return authors.stream().filter(author -> author.authorId() == book.authorId()).findFirst().orElse(null);
	}

}
