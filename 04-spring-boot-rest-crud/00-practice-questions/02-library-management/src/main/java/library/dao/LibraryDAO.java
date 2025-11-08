package library.dao;

import library.entity.Library;

import java.util.List;

public interface LibraryDAO {
    List<Library> findAll();
    Library findById(int id);
    Library save(Library library);
    Library update(Library library);
    void deleteById(int id);
    Library findByAuthor(String name);
    Library findByIsbn(String isbn);
}
