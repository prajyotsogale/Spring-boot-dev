package book.management.BookManagment.service;

import book.management.BookManagment.dao.BookRepository;
import book.management.BookManagment.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book findById(int id) {
        Optional<Book> result = bookRepository.findById(id);
        Book book = null;
        if(result.isPresent()){
            book = result.get();
        }else{
            throw new RuntimeException("Cant find book with id: "+id);
        }
        return book;
    }

    @Override
    public void delete(int id) {
        bookRepository.deleteById(id);
        System.out.println("Deleted Book by id: "+id);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
