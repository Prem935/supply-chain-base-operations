package com.supply_chain_base_operation.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "operations")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Operation extends GlobalRecord{
    private String operationId;
    private String operationName;
    private String operationCategory;
}
