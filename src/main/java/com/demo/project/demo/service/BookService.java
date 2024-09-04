package com.demo.project.demo.service;

import com.demo.project.demo.ThreadHelper;
import com.demo.project.demo.entity.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private static final Logger log = LoggerFactory.getLogger(BookService.class);

    private final List<Book> books = List.of(
            new Book(1, "Book 1", 101, 1),
            new Book(2, "Book 2", 102, 1),
            new Book(3, "Book 3", 103, 2),
            new Book(4, "Book 4", 104, 2),
            new Book(5, "Book 5", 105, 3),
            new Book(6, "Book 6", 106, 3),
            new Book(7, "Book 7", 107, 4),
            new Book(8, "Book 8", 108, 4),
            new Book(9, "Book 9", 109, 5),
            new Book(10, "Book 10", 110, 6)
    );

    public BookService() {}

    public List<Book> getBooksByIds(List<Integer> bookIds) {
        ThreadHelper.log(log, Thread.currentThread(), AuthorService.class, "getAuthors");
        ThreadHelper.sleep(1000);
        return books.stream().filter(book -> bookIds.contains(book.bookId())).collect(Collectors.toList());
    }
}
