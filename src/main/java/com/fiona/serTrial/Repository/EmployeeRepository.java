package com.fiona.serTrial.Repository;

import com.fiona.serTrial.Model.Employee;

import java.util.Optional;



import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    Optional<Employee> findById(Integer nationalId);        
    


   
}
