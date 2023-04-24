//package com.fiona.serTrial.Controller;
//
//import com.fiona.serTrial.AppConfiguration;
//import com.fiona.serTrial.Model.Employee;
//import com.fiona.serTrial.Repository.EmployeeRepository;
//import com.fiona.serTrial.Service.EmployeeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.List;
//
//@RestController
//public class EmployeeController {
//    EmployeeRepository employeeRepository;
//    EmployeeService employeeService;
//
//   ;
//
//    @GetMapping("/employees")
//    public List<Employee> getAllEmployees() throws IOException, SQLException {
//
//        return employeeService.getAllEmployees();
//    }
//    @PostMapping("/employees")
//    public Employee addEmployee(@RequestBody Employee employee){
//        return employeeService.addEMployee(employee);
//    }
//
//}
