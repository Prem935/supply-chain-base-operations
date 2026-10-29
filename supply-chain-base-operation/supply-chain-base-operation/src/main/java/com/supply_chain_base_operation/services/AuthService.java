package com.supply_chain_base_operation.services;

import com.supply_chain_base_operation.exceptions.InvalidCredentialsException;
import com.supply_chain_base_operation.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private EmployeeService employeeService;

    @Autowired
    public AuthService(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    public Employee authenticateUser(String email, String password){
        Employee employee = employeeService.findUserByWorkEmail(email);
        if (employee == null || !employee.getPassword().equals(password)){
            throw new InvalidCredentialsException(String.format("Invalid email or password entered"));
        }
        return employee;
    }
}
