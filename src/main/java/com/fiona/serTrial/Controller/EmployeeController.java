package com.fiona.serTrial.Controller;

import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.fiona.serTrial.Model.Employee;
import com.fiona.serTrial.Repository.EmployeeRepository;
import com.fiona.serTrial.Service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
// import com.fiona.serTrial.Repository.EmployeeRepository;
// import com.fiona.serTrial.Service.EmployeeService;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;
    
    @Autowired
    EmployeeService employeeService;

   ;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() throws IOException, SQLException {

        return employeeService.getAllEmployees();
    }
    @GetMapping("/")
    public String greetings(){
        return "Hey there good progress!!!!";
    }
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEMployee(employee);
    }
    @GetMapping("/employees/{nationalId}")
    public Optional<Optional<Employee>> getEmployeeByNationalId(@PathVariable Integer nationalId){
        return employeeService.getEmployeeByNationalId(nationalId);
    }

    @DeleteMapping("/employees/{nationalId}")
    public Void deleteEmployeeById(@PathVariable Integer nationalId){
        Optional<Employee> employee = employeeRepository.findById(nationalId);
        employee.ifPresent(Value->{
            employeeService.deleteEmployeeById(Value);
        });
        return null;
    }

    
}
