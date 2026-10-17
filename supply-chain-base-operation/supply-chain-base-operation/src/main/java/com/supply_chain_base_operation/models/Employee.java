package com.supply_chain_base_operation.models;

import com.supply_chain_base_operation.enums.EmploymentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends User{
    private String employeeId;
    private String workEmail;
    private String personalEmail;
    private String phoneNumber;

    private String jobTitle;
    private String designation;
    private String employmentType;

    @Enumerated(EnumType.STRING)
    private EmploymentStatus employmentStatus;

    private LocalDate joiningDate;
    private LocalDate exitDate;

    @ManyToOne
    private Employee manager;

    private String officeLocation;
    private String country;
    private String state;
    private String city;

    private BigDecimal approvalLimit;
    private String approvalCurrency;

    private Boolean active;
}
