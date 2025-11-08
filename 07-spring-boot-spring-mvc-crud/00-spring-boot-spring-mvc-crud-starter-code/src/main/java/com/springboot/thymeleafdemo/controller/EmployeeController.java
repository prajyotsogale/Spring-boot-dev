package com.springboot.thymeleafdemo.controller;

import com.springboot.thymeleafdemo.entity.Employee;
import com.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    //add mapping for "/list"
    @GetMapping("/list")
    public String getList(Model model){
        //get the employees from the database
        List<Employee> list = employeeService.findAll();
        //add to the spring model
        model.addAttribute("employees",list);

        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "/employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        //save the employee
        employeeService.save(employee);
        //redirect
        return "redirect:/employees/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int id,
                                    Model model){
        //get employee by id
        Employee employee = employeeService.findById(id);
        //set employee in model to repopulate the form
        model.addAttribute("employee", employee);
        //send over to our form

        return "/employees/employee-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int id){

        employeeService.deleteById(id);
        return "redirect:/employees/list";
    }
}
