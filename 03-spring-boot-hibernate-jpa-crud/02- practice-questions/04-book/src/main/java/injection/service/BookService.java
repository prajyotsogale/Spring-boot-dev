package injection.service;


import injection.entity.Book;

import java.util.List;

public interface BookService {
    Book saveBook(Book book);
    List<Book> getAllBooks();
    void deleteById(Integer id);
    double calculatePriceWithTax(int bookId);

}
