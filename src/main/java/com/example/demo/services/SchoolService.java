package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.School;
import com.example.demo.repository.SchoolRepository;

@Service
public class SchoolService {
    @Autowired
    private SchoolRepository repository;

    public School getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void save(School school) {
        repository.save(school);
    }
}
