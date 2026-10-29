package com.supply_chain_easy.sourcing_and_procurement_operations.controllers;

import com.supply_chain_base_operation.dtos.LoginRequestDto;
import com.supply_chain_base_operation.models.Employee;
import com.supply_chain_base_operation.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spo/api/v1/emp")
public class EmployeeController {

    private AuthService authService;

    @Autowired
    public EmployeeController(AuthService authService){
        this.authService = authService;
    }

    public ResponseEntity login(@RequestBody LoginRequestDto loginRequestDto){
        Employee employee = authService.authenticateUser(loginRequestDto.getEmail(), loginRequestDto.getPassword());
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
}
