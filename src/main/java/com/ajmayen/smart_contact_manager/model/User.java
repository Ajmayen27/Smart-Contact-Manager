package com.ajmayen.smart_contact_manager.model;

import jakarta.persistence.*;
import lombok.*;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "user")
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class User {
    @Id
    private String userId;

    @Column(name = "user_name", nullable = false)
    private String name;

    private String password;
    @Column(unique = true, nullable = false)
    private String email;
    private String phone;
    @Column(length = 10000)
    private String about;
    @Column(length = 10000)
    private String profilePic;

    private boolean enabled = false;
    private boolean emailVerified = false;
    private boolean phoneVerified = false;

    private Providers providers = Providers.SELF;
    private String providerUserId;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    private List<Contact> contacts = new ArrayList<>();



}
