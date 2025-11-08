package injection.service;

import injection.dao.BookDAO;
import injection.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class BookServiceImpl implements BookService{

    @Autowired
    private BookDAO bookDAO;

    @Override
    public Book saveBook(Book book) {
        return bookDAO.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDAO.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        bookDAO.deleteById(id);
    }

    @Override
    public double calculatePriceWithTax(int bookId) {
        Book book = bookDAO.getReferenceById(bookId);
        double price = (double)(book.getPrice()+(book.getPrice()*0.1));
        return price;
    }
}
