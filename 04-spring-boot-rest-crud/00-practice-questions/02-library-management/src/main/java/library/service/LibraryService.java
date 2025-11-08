package library.service;

import library.entity.Library;

import java.util.List;

public interface LibraryService {
    List<Library> findAll();
    Library findById(int id);
    Library save(Library library);
    Library update(Library library);
    void deleteById(int id);
    Library findByAuthor(String name);
    Library findByIsbn(String isbn);
    Library updateCopies(Library library, int quantity);
    String borrowBook(int id);
    String returnBook(int id);

}
