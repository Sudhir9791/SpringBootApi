package com.example.day5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.day5.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}

