package com.example.casestudydanang.service;

import com.example.casestudydanang.model.Publisher;
import com.example.casestudydanang.repository.PublisherDAO;

import java.util.List;

public class PublisherService {
    private PublisherDAO publisherDAO = new PublisherDAO();

    public List<Publisher> getAllPublishers() {
        return publisherDAO.getAllPublishers();
    }
}
