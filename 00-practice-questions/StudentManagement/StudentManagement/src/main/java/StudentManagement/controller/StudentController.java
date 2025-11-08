package StudentManagement.controller;

import StudentManagement.entity.Student;
import StudentManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String showList(Model model){
        List<Student> list = studentService.findAll();
        model.addAttribute("students",list);
        return "studentList";
    }

    @GetMapping("/addStudent")
    public String addStudent(Model model){
        Student student = new Student();
        model.addAttribute("student",student);
        return "addStudent";
    }

    @GetMapping("/updateStudent")
    public String updateStudent(@RequestParam("studentId") int id, Model model){
        Student student = studentService.findById(id);
        model.addAttribute("student",student);
        return "addStudent";
    }
    @GetMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("studentId") int id, Model model){
        Student student = studentService.findById(id);
        studentService.deleteById(id);
        return "redirect:/";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student student, Model model){
        studentService.add(student);
        return "redirect:/";
    }
}
