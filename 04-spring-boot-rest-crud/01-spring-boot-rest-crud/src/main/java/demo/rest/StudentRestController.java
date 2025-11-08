package demo.rest;

import demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> list;
    @PostConstruct
    public void loadData(){
        list = new ArrayList<>();
        list.add(new Student("Itachi","Uchiha"));
        list.add(new Student("Satoro","Gojo"));
        list.add(new Student("Naruto","Uzamaki"));
    }

    //define @PostConstruct to define the student data .... only once


    @GetMapping("/students")
    public List<Student> getStudents(){

        return list;
    }

    //define an endpoint to get student by id
    @GetMapping("/students/{studentId}")
    public Student getStudents(@PathVariable int studentId){

        //check student id against the list size
        if(studentId >= list.size() || studentId <0){
            throw new StudentNotFoundException("Student id not found - "+studentId);
        }

        return list.get(studentId);
    }


}
