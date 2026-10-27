package com.supply_chain_base_operation.services;

import com.supply_chain_base_operation.models.Company;
import com.supply_chain_base_operation.models.Employee;
import com.supply_chain_base_operation.models.Role;
import com.supply_chain_base_operation.models.User;
import com.supply_chain_base_operation.transformers.SystemTransformer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CompanyService {

    private RoleService roleService;
    private EmployeeService employeeService;

    public CompanyService(RoleService roleService, EmployeeService employeeService){
        this.roleService = roleService;
        this.employeeService = employeeService;
    }

    public Employee createAdminUserForCompany(Company company){
        Role adminRole = roleService.createAdminRole(company.getDisplayName());
        Employee adminEmployee = SystemTransformer.mapCompanyToAdminEmployee(company, adminRole);
        return employeeService.save(adminEmployee);
    }
}
