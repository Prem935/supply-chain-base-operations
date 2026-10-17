package com.supply_chain_base_operation.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "procurement_company")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProcurementCompany extends Company{
    private String procurementCompanyCode;
    private String procurementModel;
    private String procurementStrategy;
    private BigDecimal annualProcurementBudget;
    private BigDecimal annualProcurementSpend;

    private String defaultCurrency;
    private Boolean budgetControlEnabled;
    private Boolean purchaseRequisitionRequired;
    private String purchaseOrderRequired;

    private Boolean sourcingRequired;
    private Boolean contractRequired;
    private Boolean supplierApprovalRequired;
    private Boolean multiLevelApprovalRequired;
    private Boolean threeWayMatchingEnabled;
}
