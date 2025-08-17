package com.shopperx.shopperxapi.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name="addresses")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String street;
    private String apartment;
    private String city;

    private String state;
    private String zip;
    private String country;
    private String phone;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;

}
