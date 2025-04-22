package com.example.dbcrawler.generated;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "staff")
public class Staff {

    @Column(name = "staff_id")
    private int staff_id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "address_id")
    private int address_id;

    @Column(name = "picture")
    private String picture;

    @Column(name = "email")
    private String email;

    @Column(name = "store_id")
    private int store_id;

    @Column(name = "active")
    private String active;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "last_update")
    private Date last_update;

    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "store_id", referencedColumnName = "store_id")
    private Store store;

}
