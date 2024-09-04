package com.demo.project.demo.service;

import com.demo.project.demo.ThreadHelper;
import com.demo.project.demo.entity.Book;
import com.demo.project.demo.entity.Selling;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SellingService {

    private static final Logger log = LoggerFactory.getLogger(SellingService.class);

    private final List<Selling> sellings = List.of(
            new Selling(1, 101),
            new Selling(2, 102),
            new Selling(3, 103),
            new Selling(4, 104),
            new Selling(5, 105),
            new Selling(6, 106),
            new Selling(7, 107),
            new Selling(8, 108),
            new Selling(9, 109)
    );

    public SellingService() {}

    public Map<Book, Integer> getSellings(Set<Book> books) {
        ThreadHelper.log(log, Thread.currentThread(), AuthorService.class, "getSellings");
        ThreadHelper.sleep(1000);
        return books.stream().collect(Collectors.toMap(book -> book, book -> getSelling(book).qtySold()));
    }

    public Selling getSelling(Book book) {
        ThreadHelper.log(log, Thread.currentThread(), AuthorService.class, "getSelling");
        ThreadHelper.sleep(1000);
        return getSellingInternal(book);
    }

    private Selling getSellingInternal(Book book) {
        return sellings.stream().filter(selling -> selling.bookId() == book.bookId()).findFirst().orElse(new Selling(book.bookId(), 0));
    }

}
