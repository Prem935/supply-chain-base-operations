package com.supply_chain_base_operation.services;

import com.supply_chain_base_operation.exceptions.InvalidCredentialsException;
import com.supply_chain_base_operation.models.Employee;
import com.supply_chain_base_operation.utilities.JwtUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AuthService {

    private EmployeeService employeeService;
    private JwtUtility jwtUtility;

    @Autowired
    public AuthService(EmployeeService employeeService, JwtUtility jwtUtility){
        this.employeeService = employeeService;
        this.jwtUtility = jwtUtility;
    }

    public String  authenticateUser(String email, String password){
        Employee employee = employeeService.findUserByWorkEmail(email);
        if (employee == null || !employee.getPassword().equals(password)){
            throw new InvalidCredentialsException(String.format("Invalid email or password entered"));
        }

        return jwtUtility.generateJwtToken(employee);
    }
}
