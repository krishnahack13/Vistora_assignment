package com.example.dbcrawler.generated;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "store")
public class Store {

    @Column(name = "store_id")
    private int store_id;

    @Column(name = "manager_staff_id")
    private int manager_staff_id;

    @Column(name = "address_id")
    private int address_id;

    @Column(name = "last_update")
    private Date last_update;

    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "manager_staff_id", referencedColumnName = "staff_id")
    private Staff staff;

}
