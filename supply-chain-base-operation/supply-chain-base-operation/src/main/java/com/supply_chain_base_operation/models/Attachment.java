package com.supply_chain_base_operation.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "attachments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID sysID;
    private String attachmentLink;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;
    private String updatedBy;
}
