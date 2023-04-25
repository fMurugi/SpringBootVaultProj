package com.fiona.serTrial.Service;

import com.fiona.serTrial.Model.Employee;
import com.fiona.serTrial.Repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
    public Employee addEMployee(Employee employee){
        return employeeRepository.save(employee);

    }
    public Optional<Optional<Employee>> getEmployeeByNationalId(Integer nationalId){
        return Optional.of(employeeRepository.findById(nationalId));
    }
   
   
    public void deleteEmployeeById(Employee value) {
        employeeRepository.deleteById(null);
    }
}
