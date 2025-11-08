package book.management.BookManagment.controller;

import book.management.BookManagment.entity.Book;
import book.management.BookManagment.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookController {
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService){
        this.bookService = bookService;
    }
    @GetMapping("/")
    public String sayHello(){
        return "hello-world";
    }
    @GetMapping("/list")
    public String getList(Model model){
        List<Book> list = bookService.findAll();
        model.addAttribute("books",list);
        return "show-books";
    }

    @GetMapping("/addBooksForm")
    public String bookForm(Model model){
        Book book = new Book();
        model.addAttribute("book",book);
        return "bookForm";
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute("book") Book book){
        bookService.save(book);
        return "redirect:/list";
    }

    @GetMapping("/showFormForUpdate")
    public String updateForm(@RequestParam("bookId") int id, Model model){
        //get book and send over the model to repopulate the form
        Book book = bookService.findById(id);
        model.addAttribute("book",book);
        return "bookForm";
    }

    @GetMapping("deleteBook")
    public String deleteBook(@RequestParam("bookId") int id){
        bookService.delete(id);
        return "redirect:/list";
    }
}
