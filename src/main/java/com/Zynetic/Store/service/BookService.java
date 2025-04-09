package com.Zynetic.Store.service;

import com.Zynetic.Store.model.Book;
import com.Zynetic.Store.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepo;

    public BookService(BookRepository bookRepo){
        this.bookRepo = bookRepo;
    }

    public Book createBook(Book book){
        return bookRepo.save(book);
    }

    public List<Book> getAllBooks(){
        return bookRepo.findAll();
    }

    public Optional<Book> getBookById(Long id){
        return bookRepo.findById(id);
    }

    public Book updateBook(Long id, Book newBook) {
        Book book = bookRepo.findById(id).orElseThrow();
        book.setTitle(newBook.getTitle());
        book.setAuthor(newBook.getAuthor());
        book.setCategory(newBook.getCategory());
        book.setPrice(newBook.getPrice());
        book.setRating(newBook.getRating());
        book.setPublishedDate(newBook.getPublishedDate());
        return bookRepo.save(book);
    }

    public void deleteBook(Long id) {
        bookRepo.deleteById(id);
    }

    public List<Book> filter(String author, String category, Double rating) {
        if (author != null) return bookRepo.findByAuthor(author);
        if (category != null) return bookRepo.findByCategory(category);
        if (rating != null) return bookRepo.findByRating(rating);
        return bookRepo.findAll();
    }

    public List<Book> searchByTitle(String title) {
        return bookRepo.findByTitleContainingIgnoreCase(title);
    }
}