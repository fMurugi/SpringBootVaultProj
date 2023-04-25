package com.fiona.serTrial.Model;

// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;
import lombok.Data;

@Data
@javax.persistence.Entity(name="employee")

public class Employee {
    @javax.persistence.Id
    private int nationalId;
    private String firstName;
    private String lastName;


    public int getNationalId() {
        return nationalId;
    }

    public void setNationalId(int nationalId) {
        this.nationalId = nationalId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
