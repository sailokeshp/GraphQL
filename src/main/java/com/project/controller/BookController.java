package com.project.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.project.model.Author;
import com.project.model.Book;

import java.util.List;
import java.util.Optional;

@Controller
public class BookController {
    @QueryMapping
    public List<Book> getAllbooks(){
        return Book.books;
    }

    @QueryMapping
    public Optional<Book> bookById(@Argument Integer id){
        return Book.getBookById(id);
    }

    @SchemaMapping
    public Optional<Author> author(Book book){
        return Author.getAuthorById(book.authorId());
    }
}
