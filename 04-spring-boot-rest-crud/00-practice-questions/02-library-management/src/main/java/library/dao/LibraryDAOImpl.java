package library.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import library.entity.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LibraryDAOImpl implements LibraryDAO{

    private final EntityManager entityManager;

    @Autowired
    public LibraryDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Library> findAll() {
        TypedQuery<Library> theQuery = entityManager.createQuery("FROM Library",Library.class);
        List<Library> list = theQuery.getResultList();
        return list;
    }

    @Override
    public Library findById(int id) {
        Library library = entityManager.find(Library.class,id);
        return library;
    }

    @Override
    public Library save(Library library) {
        return entityManager.merge(library);
    }

    @Override
    public Library update(Library library) {
        return entityManager.merge(library);
    }

    @Override
    public void deleteById(int id) {
        Library library = entityManager.find(Library.class,id);
        entityManager.remove(library);
    }

    @Override
    public Library findByAuthor(String name) {
        TypedQuery<Library> theQuery = entityManager.createQuery("FROM Library WHERE name = :name",Library.class);
        theQuery.setParameter("name",name);
        Library library = theQuery.getSingleResult();
        return  library;
    }

    @Override
    public Library findByIsbn(String isbn) {
        TypedQuery<Library> theQuery = entityManager.createQuery("FROM Library WHERE isbn = :Data",Library.class);
        theQuery.setParameter("Data",Library.class);
        Library library = theQuery.getSingleResult();
        return library;
    }

}
