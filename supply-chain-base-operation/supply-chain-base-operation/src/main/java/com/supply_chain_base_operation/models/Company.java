package com.supply_chain_base_operation.models;

import com.supply_chain_base_operation.enums.CompanyStatus;
import com.supply_chain_base_operation.enums.CompanyType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "companies")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Company extends GlobalRecord{
    private String companyId;
    private String legalName;
    private String displayName;
    private String companyCode;
    private String registrationNumber;

    @Enumerated(EnumType.STRING)
    private CompanyType companyType;

    @Enumerated(EnumType.STRING)
    private CompanyStatus status;

    private String industry;
    private String businessDescription;
    private String website;

    private String email;
    private String phoneNumber;
    private String registeredAddress;

    private String taxIdentificationNumber;
    private String vatNumber;
    private String gstNumber;

    private Boolean active;
}
