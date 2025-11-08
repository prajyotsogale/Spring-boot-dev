package injection;


import injection.dao.BookDAO;
import injection.entity.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;


@SpringBootApplication
public class InjectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(InjectionApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(BookDAO bookDAO){
        return runner ->{
            //saveBook(bookDAO);
            //createMultipleBooks(bookDAO);
            //findAll(bookDAO);
            //deleteById(bookDAO);
        };
    }

    private void deleteById(BookDAO bookDAO) {
        int id = 2;
        System.out.println("deleting the row of id:"+id);
        bookDAO.deleteById(id);
        System.out.println("deleted");
    }

    private void findAll(BookDAO bookDAO) {
        List<Book> list = bookDAO.findAll();
        for(Book book : list){
            System.out.println(book);
        }
    }

    private void createMultipleBooks(BookDAO bookDAO) {
        System.out.println("Creating books");
        Book book = new Book("Atomic Habit","James Clear",600);
        Book book1 = new Book("A Tale of Two Cities","Charles Dickens",400);
        Book book2 = new Book("The Alchemist","Paulo Coelho",250);
        Book book3 = new Book("The Seven Husbands of Evelyn Hugo","Taylor Jenkins Reid",500);
        System.out.println("saving books");
        bookDAO.save(book);
        bookDAO.save(book1);
        bookDAO.save(book2);
        bookDAO.save(book3);
    }

    private void saveBook(BookDAO bookDAO) {
        Book book = new Book("Atomic Habit","James Clear",600);
        bookDAO.save(book);
    }
}
