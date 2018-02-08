package com.springrest.controller;

import com.springrest.api.BookClient;
import com.springrest.model.Book;
import com.springrest.model.BookResource;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getBooks() {
//        return "Hello World!";

        BookClient bookClient = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(BookClient.class))
                .logLevel(Logger.Level.FULL)
                .target(BookClient.class, "http://localhost:8181/api/books");

        List<BookResource> books = bookClient.findAll();
        return java.util.Arrays.asList(books).toString();
    }

    @RequestMapping(value = "/{isbn}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String getBook(@PathVariable("isbn") String isbn) {
        BookClient bookClient = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(BookClient.class))
                .logLevel(Logger.Level.FULL)
                .target(BookClient.class, "http://localhost:8181/api/books");

        BookResource bookResource = bookClient.findByIsbn(isbn);
        return bookResource.getBook().toString();
    }
}
