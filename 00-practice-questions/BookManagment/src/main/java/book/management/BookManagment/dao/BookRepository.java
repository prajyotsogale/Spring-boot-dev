package book.management.BookManagment.dao;

import book.management.BookManagment.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
