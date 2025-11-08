package LibraryManagement.service;

import LibraryManagement.dao.LibraryRepository;
import LibraryManagement.entity.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class LibraryServiceImpl implements LibraryService{

    private LibraryRepository libraryRepository;

    @Autowired
    public LibraryServiceImpl(LibraryRepository libraryRepository){
        this.libraryRepository = libraryRepository;
    }


    @Override
    public Library findById(int id) {
        Optional<Library> library= libraryRepository.findById(id);
        Library result = null;

        if(library.isPresent()){
            result = library.get();
        }else{
            throw new RuntimeException("Invalid id");
        }
        return result;
    }

    @Override
    public List<Library> findAll() {
        return libraryRepository.findAll();
    }

    @Override
    public Library save(Library library) {
        return libraryRepository.save(library);
    }


    @Override
    public void delete(int id) {
        libraryRepository.deleteById(id);
        System.out.println("Entry deleted by id: "+id);
    }
}
