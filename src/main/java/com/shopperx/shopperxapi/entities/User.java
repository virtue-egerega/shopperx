package com.shopperx.shopperxapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private UUID id;

    @Column(length = 20)
    private String firstName;

    @Column(length = 20)
    private String lastName;
    @Column(unique=true, nullable=false, updatable = false, length = 30)
    private String email;

    @Column(unique=true, nullable=false, updatable = true, length = 20)
    private String phone;

    @Column(length = 20)
    private String username;

    @Column(length = 100)
    private String password;

    @OneToMany(mappedBy="user", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Address> addresses;
}
