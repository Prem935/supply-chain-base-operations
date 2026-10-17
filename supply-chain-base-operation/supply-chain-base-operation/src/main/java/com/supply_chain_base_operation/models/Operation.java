package com.supply_chain_base_operation.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "operations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Operation extends GlobalRecord{
    private String operationId;
    private String operationName;
    private String operationCategory;
}
