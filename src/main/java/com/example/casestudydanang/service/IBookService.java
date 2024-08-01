package com.example.casestudydanang.service;

import com.example.casestudydanang.model.Book;

import java.util.List;

public interface IBookService {
    public List<Book> getAllBooks();
    public void addBook(Book book);
}
