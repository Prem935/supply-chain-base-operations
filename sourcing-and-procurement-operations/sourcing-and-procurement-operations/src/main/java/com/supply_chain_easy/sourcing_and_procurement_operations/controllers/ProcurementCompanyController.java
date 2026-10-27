package com.supply_chain_easy.sourcing_and_procurement_operations.controllers;

import com.supply_chain_base_operation.models.ProcurementCompany;
import com.supply_chain_easy.sourcing_and_procurement_operations.dtos.ProcurementCompanyRegistrationDto;
import com.supply_chain_easy.sourcing_and_procurement_operations.services.ProcurementCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/procurement-company")
public class ProcurementCompanyController {

    private ProcurementCompanyService procurementCompanyService;

    @Autowired
    public ProcurementCompanyController(ProcurementCompanyService procurementCompanyService){
        this.procurementCompanyService = procurementCompanyService;
    }

    @PostMapping("/on-board")
    public ResponseEntity onBoardProcurementCompany(
            @RequestBody ProcurementCompanyRegistrationDto procurementCompanyRegistrationDto
            ){
        //Service Layer
        ProcurementCompany procurementCompany = procurementCompanyService.onBoardProcurementCompany(procurementCompanyRegistrationDto);
        return new ResponseEntity<>(procurementCompany, HttpStatus.CREATED);
    }
}
