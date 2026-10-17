package com.supply_chain_base_operation.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "global_records")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class GlobalRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID sysID;
    @OneToMany
    private List<Attachment> attachments;
    @OneToMany
    private List<Activity> activities;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;
    private String updatedBy;
}
