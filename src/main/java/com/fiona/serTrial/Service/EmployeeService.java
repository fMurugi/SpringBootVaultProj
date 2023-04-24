//package com.fiona.serTrial.Service;
//
//import com.fiona.serTrial.Controller.EmployeeController;
//import com.fiona.serTrial.Model.Employee;
//import com.fiona.serTrial.Repository.EmployeeRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//import java.util.Optional;
//
//public class EmployeeService {
//    @Autowired
//    private EmployeeRepository employeeRepository;
//    public List<Employee> getAllEmployees(){
//        return employeeRepository.findAll();
//    }
//    public Employee addEMployee(Employee employee){
//        return employeeRepository.save(employee);
//
//    }
//    public Optional<Employee> getEmployeeByNationalId(Integer nationalId){
//        return Optional.of(employeeRepository.getById(nationalId));
//    }
//
//    public void delete(Integer nationalId){
//        employeeRepository.deleteById(nationalId);
//    }
//}
