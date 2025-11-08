package demo.cruddemo.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import demo.cruddemo.dao.EmployeeDAO;
import demo.cruddemo.entity.Employee;
import demo.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    private ObjectMapper objectMapper;

    public EmployeeRestController(EmployeeService employeeService, ObjectMapper objectMapper){
        this.employeeService = employeeService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getById(@PathVariable int id){
        Employee employee =  employeeService.findById(id);

        if(employee == null){
            throw new RuntimeException("Employee not found: "+id);
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(0);
        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        Employee employee = employeeService.findById(id);

        if(employee==null){
            throw new RuntimeException("Employee not found:"+ id);
        }
        employeeService.deleteById(id);
        return "Deleted employee by id: "+id;
    }

    //add patch mapping
    @PatchMapping("/employees/{id}")
    public Employee patchEmployee(@PathVariable int id, @RequestBody Map<String, Object> patchPayload){

        Employee employee = employeeService.findById(id);
        //throw exception
        if(employee == null){
            throw new RuntimeException("Employee id not found: "+id);
        }
        //throw exception if there is id
        if(patchPayload.containsKey("id")){
            throw new RuntimeException("Employee id is not allowed in request body: "+id);
        }

        //apply the patch payload to the employee

        Employee patchEmployee = apply(patchPayload, employee);
        Employee dbEmployee = employeeService.save(patchEmployee);
        return dbEmployee;

    }

    public Employee apply(Map<String, Object> patchPayload,Employee employee){
        //convert employee object to a json object node
        ObjectNode employeeNode = objectMapper.convertValue(employee, ObjectNode.class);
        //convert patch payload map to a json object node
        ObjectNode patchNode = objectMapper.convertValue(patchPayload, ObjectNode.class);
        //merge the patch updates into employee node
        employeeNode.setAll(patchNode);
        //convert it back and return
        return objectMapper.convertValue(employeeNode,Employee.class);
    }
}
