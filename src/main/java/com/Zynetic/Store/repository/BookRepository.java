package com.Zynetic.Store.repository;

import com.Zynetic.Store.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAuthor(String author);
    List<Book> findByCategory(String category);

    List<Book> findByRating(Double rating);

    List<Book> findByTitleContainingIgnoreCase(String title);

}