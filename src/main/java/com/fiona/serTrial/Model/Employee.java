package com.fiona.serTrial.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;
@Data
@Entity
public class Employee {
    @Id
    private int nationalId;
    private String firstName;
    private String lastName;




}
