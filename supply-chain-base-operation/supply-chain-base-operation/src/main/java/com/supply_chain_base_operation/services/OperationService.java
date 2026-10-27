package com.supply_chain_base_operation.services;

import com.supply_chain_base_operation.models.Operation;
import com.supply_chain_base_operation.repositories.OperationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationService {

    private OperationRepository operationRepository;

    public OperationService(OperationRepository operationRepository){
        this.operationRepository = operationRepository;
    }

    public List<Operation> fetchAllOperations(){
        return operationRepository.findAll();
    }
}
