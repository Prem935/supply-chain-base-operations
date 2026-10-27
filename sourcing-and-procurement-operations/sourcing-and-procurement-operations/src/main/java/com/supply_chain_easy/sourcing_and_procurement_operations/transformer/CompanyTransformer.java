package com.supply_chain_easy.sourcing_and_procurement_operations.transformer;

import com.supply_chain_base_operation.enums.CompanyStatus;
import com.supply_chain_base_operation.models.ProcurementCompany;
import com.supply_chain_easy.sourcing_and_procurement_operations.dtos.ProcurementCompanyRegistrationDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CompanyTransformer {
    public ProcurementCompany transformProcurementCompanyDtoToModel(ProcurementCompanyRegistrationDto dto){
        return ProcurementCompany.builder()
                // =========================
                // Company Information
                // =========================
                .legalName(dto.getLegalName())
                .displayName(dto.getDisplayName())
                .companyCode(dto.getCompanyCode())
                .registrationNumber(dto.getRegistrationNumber())
                .companyType(dto.getCompanyType())
                // =========================
                // Business Information
                // =========================
                .industry(dto.getIndustry())
                .businessDescription(dto.getBusinessDescription())
                .website(dto.getWebsite())
                // =========================
                // Contact Information
                // =========================
                .email(dto.getEmail())
                .phoneNumber(dto.getPhoneNumber())
                .registeredAddress(dto.getRegisteredAddress())
                // =========================
                // Tax & Legal Information
                // =========================
                .taxIdentificationNumber(dto.getTaxIdentificationNumber())
                .vatNumber(dto.getVatNumber())
                .gstNumber(dto.getGstNumber())
                // =========================
                // Procurement Information
                // =========================
                .procurementCompanyCode(dto.getProcurementCompanyCode())
                .procurementModel(dto.getProcurementModel())
                .procurementStrategy(dto.getProcurementStrategy())
                .annualProcurementBudget(dto.getAnnualProcurementBudget())
                .annualProcurementSpend(dto.getAnnualProcurementSpend())
                .defaultCurrency(dto.getDefaultCurrency())
                .budgetControlEnabled(dto.getBudgetControlEnabled())
                .purchaseRequisitionRequired(dto.getPurchaseRequisitionRequired())
                .purchaseOrderRequired(dto.getPurchaseOrderRequired())
                .sourcingRequired(dto.getSourcingRequired())
                .contractRequired(dto.getContractRequired())
                .supplierApprovalRequired(dto.getSupplierApprovalRequired())
                .threeWayMatchingEnabled(dto.getThreeWayMatchingEnabled())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .createdBy("system")
                .updatedBy("system")
                .companyId("COMP-001")
                // Default values
                .status(CompanyStatus.PENDING_VERIFICATION)
                .active(false)
                .build();
    }
}
