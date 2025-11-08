package LibraryManagement.service;

import LibraryManagement.entity.Library;

import java.util.List;

public interface LibraryService {
    Library findById(int id);
    List<Library> findAll();
    Library save(Library library);
    void delete(int id);
}
