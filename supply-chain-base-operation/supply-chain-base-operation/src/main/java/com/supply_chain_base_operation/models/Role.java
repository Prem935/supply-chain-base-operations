package com.supply_chain_base_operation.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role extends GlobalRecord{
    private String roleId;
    private String roleName;
    @ManyToMany
    private List<Operation> operations;
}
