package com.supply_chain_base_operation.services;

import com.supply_chain_base_operation.constants.SystemConstant;
import com.supply_chain_base_operation.models.Operation;
import com.supply_chain_base_operation.models.Role;
import com.supply_chain_base_operation.repositories.RoleRepository;
import com.supply_chain_base_operation.utilities.SystemUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RoleService {

    private OperationService operationService;
    private RoleRepository roleRepository;

    @Autowired
    public RoleService(OperationService operationService, RoleRepository roleRepository){
        this.operationService = operationService;
        this.roleRepository = roleRepository;
    }

    public Role createAdminRole(String companyName){
        List<Operation> operations = operationService.fetchAllOperations();
        Role adminRole = Role.builder()
                .roleId(SystemUtility.generateId(SystemConstant.ROLE_ENTITY_NAME))
                .roleName(companyName + "-" + "MAINT")
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .createdBy(SystemConstant.SYSTEM_ENTITY_NAME)
                .updatedBy(SystemConstant.SYSTEM_ENTITY_NAME)
                .operations(operations)
                .build();
        return roleRepository.save(adminRole);
    }
}
