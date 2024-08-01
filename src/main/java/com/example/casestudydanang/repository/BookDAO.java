package com.example.casestudydanang.repository;

// BookDAO.java
import com.example.casestudydanang.model.Book;
import com.example.casestudydanang.util.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        String sql  = "SELECT b.*, c.category_name, p.publisher_name " +
                "FROM Book b " +
                "JOIN Category c ON b.category_id = c.category_id " +
                "JOIN Publisher p ON b.publisher_id = p.publisher_id " +
                "ORDER BY b.book_id"; // Sắp xếp theo book_id



        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("book_id"));
                book.setName(rs.getString("name"));
                book.setDescription(rs.getString("description"));
                book.setImageUrl(rs.getString("image_url"));
                book.setStatus(rs.getBoolean("status"));
                book.setCategoryId(rs.getInt("category_id"));
                book.setPublisherId(rs.getInt("publisher_id"));
                book.setCategoryName(rs.getString("category_name")); // New
                book.setPublisherName(rs.getString("publisher_name")); // New
                book.setCreatedAt(rs.getTimestamp("created_at"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }



    public void addBook(Book book) {
        String sql = "INSERT INTO Book (name, description, image_url, status, category_id, publisher_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, book.getName());
            stmt.setString(2, book.getDescription());
            stmt.setString(3, book.getImageUrl());
            stmt.setBoolean(4, book.isStatus());
            stmt.setInt(5, book.getCategoryId());
            stmt.setInt(6, book.getPublisherId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

