package injection.dao;

import injection.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDAO extends JpaRepository<Book,Integer> {
    // AUTO implements save(), findAll(), deleteById()
}
