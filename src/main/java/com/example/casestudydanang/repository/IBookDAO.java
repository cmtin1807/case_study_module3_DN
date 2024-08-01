package com.example.casestudydanang.repository;

import com.example.casestudydanang.model.Book;

import java.util.List;

public interface IBookDAO {
    public List<Book> getAllBooks();
    public Book getBookById(int id);
    public void addBook(Book book);
    public void updateBook(Book book);
    public void deleteBook(int id);
}
