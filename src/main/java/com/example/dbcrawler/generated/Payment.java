package com.example.dbcrawler.generated;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "payment")
public class Payment {

    @Column(name = "payment_id")
    private int payment_id;

    @Column(name = "customer_id")
    private int customer_id;

    @Column(name = "staff_id")
    private int staff_id;

    @Column(name = "rental_id")
    private int rental_id;

    @Column(name = "amount")
    private double amount;

    @Column(name = "payment_date")
    private Date payment_date;

    @Column(name = "last_update")
    private Date last_update;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "rental_id", referencedColumnName = "rental_id")
    private Rental rental;

    @ManyToOne
    @JoinColumn(name = "staff_id", referencedColumnName = "staff_id")
    private Staff staff;

}
