package com.ajmayen.smart_contact_manager.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Contact {

    @Id
    private String id;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    @Column(length = 10000)
    private String description;
    private String picture;
    private boolean favourite = false;
    private String websiteLink;
    private String linkedInLink;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "contact",cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true)
    private List<SocialLink> socialLinks = new ArrayList<>();
}
