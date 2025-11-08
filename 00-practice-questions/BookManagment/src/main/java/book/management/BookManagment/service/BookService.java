package book.management.BookManagment.service;

import book.management.BookManagment.entity.Book;

import java.util.List;

public interface BookService {
    Book save(Book book);
    Book findById(int id);
    void delete(int id);
    List<Book> findAll();
}
