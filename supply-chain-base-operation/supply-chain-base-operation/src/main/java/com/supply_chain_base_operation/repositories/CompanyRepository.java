package com.supply_chain_base_operation.repositories;

import com.supply_chain_base_operation.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CompanyRepository extends JpaRepository<Company, UUID> {
}
