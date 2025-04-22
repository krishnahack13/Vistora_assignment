package com.example.dbcrawler.generated;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "rental")
public class Rental {

    @Column(name = "rental_id")
    private int rental_id;

    @Column(name = "rental_date")
    private Date rental_date;

    @Column(name = "inventory_id")
    private int inventory_id;

    @Column(name = "customer_id")
    private int customer_id;

    @Column(name = "return_date")
    private Date return_date;

    @Column(name = "staff_id")
    private int staff_id;

    @Column(name = "last_update")
    private Date last_update;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "inventory_id", referencedColumnName = "inventory_id")
    private Inventory inventory;

    @ManyToOne
    @JoinColumn(name = "staff_id", referencedColumnName = "staff_id")
    private Staff staff;

}
