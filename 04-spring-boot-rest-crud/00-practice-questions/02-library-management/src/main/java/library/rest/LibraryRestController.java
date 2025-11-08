package library.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import library.entity.Library;
import library.service.LibraryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
public class LibraryRestController {
    private final LibraryServiceImpl libraryService;
    private final ObjectMapper objectMapper;

    @Autowired
    public LibraryRestController(LibraryServiceImpl libraryService, ObjectMapper objectMapper){
        this.libraryService = libraryService;
        this.objectMapper = objectMapper;
    }
    @GetMapping
    public List<Library> getList(){
        return libraryService.findAll();
    }
    @GetMapping("/{id}")
    public Library getSingleEntity(@PathVariable int id){
        return libraryService.findById(id);
    }
    @PutMapping("/{id}")
    public Library update(@RequestBody Library library){
        return libraryService.update(library);
    }

    @PostMapping
    public Library postLibrary(@RequestBody Library library){
        library.setId(0);
        return libraryService.save(library);
    }
    @PatchMapping("/{id}")
    public Library partialUpdate(@PathVariable int id, @RequestBody Map<String, Object> patchPayload){
        Library library = libraryService.findById(id);
        if(library == null){
            throw new RuntimeException("Invalid Information");
        }
        if(patchPayload.containsKey("id")){
            throw new RuntimeException("'id' is not allowed");
        }
        Library modified = apply(library,patchPayload);
        Library dbLib = libraryService.save(modified);
        return dbLib;
    }
    @PatchMapping("/{id}/borrow")
    public Library borrow(@PathVariable int id, @RequestBody Map<String, Object> patchPayload){
        Library library = libraryService.findById(id);
        if(library == null){
            throw new RuntimeException("Invalid Information");
        }
        if(patchPayload.containsKey("id")){
            throw new RuntimeException("'id' is not allowed");
        }
        Library modified = apply(library,patchPayload);
        Library dbLib = libraryService.save(modified);
        return dbLib;
    }
    public Library apply(Library library, Map<String, Object> patchPayload){
        ObjectNode libraryNode = objectMapper.convertValue(library, ObjectNode.class);
        ObjectNode patchNode = objectMapper.convertValue(patchPayload, ObjectNode.class);

        libraryNode.setAll(patchNode);
        return objectMapper.convertValue(libraryNode,Library.class);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable int id){
        libraryService.deleteById(id);
        return "Deleted by id: "+id;
    }
}

