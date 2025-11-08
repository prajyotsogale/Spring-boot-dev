package library.service;

import library.dao.LibraryDAO;
import library.entity.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService{

    private LibraryDAO libraryDAO;

    @Autowired
    public LibraryServiceImpl(LibraryDAO libraryDAO){
        this.libraryDAO = libraryDAO;
    }


    @Override
    public List<Library> findAll() {
        return libraryDAO.findAll();
    }

    @Override
    public Library findById(int id) {
        return libraryDAO.findById(id);
    }

    @Transactional
    @Override
    public Library save(Library library) {
        return libraryDAO.save(library);
    }

    @Transactional
    @Override
    public Library update(Library library) {
        return libraryDAO.update(library);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        libraryDAO.deleteById(id);
    }

    @Override
    public Library findByAuthor(String name) {
        return libraryDAO.findByAuthor(name);
    }

    @Override
    public Library findByIsbn(String isbn) {
        return libraryDAO.findByIsbn(isbn);
    }

    @Transactional
    @Override
    public Library updateCopies(Library library, int quantity) {
        int q = library.getAvailableCopies()-quantity;
        if(q <0){
            throw new RuntimeException("Not available this much copies, available copies: "+library.getAvailableCopies());
        }
        library.setAvailableCopies(quantity);
        return libraryDAO.update(library);
    }

    @Override
    public String borrowBook(int id) {
        Library library = libraryDAO.findById(id);
        int rem = library.getAvailableCopies()-1;
        updateCopies(library,rem);
        return "Borrowed 1 book";
    }

    @Override
    public String returnBook(int id) {
        Library library = libraryDAO.findById(id);
        int rem = library.getAvailableCopies()+1;
        updateCopies(library,rem);
        return "Returned 1 book";
    }
}
