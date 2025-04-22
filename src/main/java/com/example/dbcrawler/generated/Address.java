package com.example.dbcrawler.generated;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "address")
public class Address {

    @Column(name = "address_id")
    private int address_id;

    @Column(name = "address")
    private String address;

    @Column(name = "address2")
    private String address2;

    @Column(name = "district")
    private String district;

    @Column(name = "city_id")
    private int city_id;

    @Column(name = "postal_code")
    private String postal_code;

    @Column(name = "phone")
    private String phone;

    @Column(name = "location")
    private String location;

    @Column(name = "last_update")
    private Date last_update;

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "city_id")
    private City city;

}
