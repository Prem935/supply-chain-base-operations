package com.supply_chain_base_operation.models;

import com.supply_chain_base_operation.enums.AuthenticationProvider;
import com.supply_chain_base_operation.enums.UserStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends GlobalRecord{
    private String userId;
    private String firstName;
    private String lastName;

    private String email;
    private String password;
    private String profileImageUrl;

    @Enumerated(EnumType.STRING)
    private UserStatus status;
    private String currency;

    private String address;
    private String country;
    private String state;
    private String city;
    private String postalCode;

    private String locationId;
    private String warehouseId;

    @Enumerated(EnumType.STRING)
    private AuthenticationProvider authenticationProvider;

    private Boolean emailVerified;
    private Boolean phoneVerified;
    private Boolean twoFactorEnabled;

    private Instant lastLoginAt;
    private Instant passwordChangdeAt;

    private Integer failedLoginAttempts;
    private Boolean accountLocked;

    private String preferredLanguage;
    private String preferredCurrency;
    private String timeZone;

    private Boolean active;
    private Instant lastActivityAt;

    @ManyToMany
    private List<Role> roles;
}
