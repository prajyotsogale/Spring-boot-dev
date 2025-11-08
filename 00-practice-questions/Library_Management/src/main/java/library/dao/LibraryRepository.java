package library.dao;


import library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Book, Integer> {
}
