package com.example.casestudydanang.service;


import com.example.casestudydanang.model.Book;
import com.example.casestudydanang.repository.BookDAO;

import java.sql.SQLException;
import java.util.List;

public class BookService implements IBookService {
        private BookDAO bookDAO = new BookDAO();

        public List<Book> getAllBooks() {
            return bookDAO.getAllBooks();
        }

        public void addBook(Book book){
            bookDAO.addBook(book);
        }
    }

