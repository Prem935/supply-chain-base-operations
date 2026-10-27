package com.supply_chain_easy.sourcing_and_procurement_operations.services;

import com.supply_chain_base_operation.models.Employee;
import com.supply_chain_base_operation.models.ProcurementCompany;
import com.supply_chain_base_operation.repositories.ProcurementCompanyRepository;
import com.supply_chain_base_operation.services.CompanyService;
import com.supply_chain_easy.sourcing_and_procurement_operations.dtos.ProcurementCompanyRegistrationDto;
import com.supply_chain_easy.sourcing_and_procurement_operations.transformer.CompanyTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;

@Service
public class ProcurementCompanyService {

    private CompanyTransformer companyTransformer;
    private ProcurementCompanyRepository procurementCompanyRepository;
    private CompanyService companyService;
    private EmailService emailService;
    private ExecutorService executorService;

    @Autowired
    public ProcurementCompanyService(CompanyTransformer companyTransformer,
                                     ProcurementCompanyRepository procurementCompanyRepository,
                                     CompanyService companyService,
                                     EmailService emailService,
                                     ExecutorService executorService
    ){
        this.companyTransformer = companyTransformer;
        this.procurementCompanyRepository = procurementCompanyRepository;
        this.companyService = companyService;
        this.emailService = emailService;
        this.executorService = executorService;
    }

    public ProcurementCompany onBoardProcurementCompany(ProcurementCompanyRegistrationDto procurementCompanyRegistrationDto){
        ProcurementCompany procurementCompany = companyTransformer.transformProcurementCompanyDtoToModel(procurementCompanyRegistrationDto);
        procurementCompany = procurementCompanyRepository.save(procurementCompany);
        Employee adminEmployee = companyService.createAdminUserForCompany(procurementCompany);
        ProcurementCompany finalProcurementCompany = procurementCompany;
        executorService.execute( () -> {
            emailService.sendRegistrationEmailToProcurementCompany(
                    finalProcurementCompany,
                    adminEmployee
            );
        });
        return procurementCompany;
    }
}
