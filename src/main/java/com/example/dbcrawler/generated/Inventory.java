package com.example.dbcrawler.generated;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "inventory")
public class Inventory {

    @Column(name = "inventory_id")
    private int inventory_id;

    @Column(name = "film_id")
    private int film_id;

    @Column(name = "store_id")
    private int store_id;

    @Column(name = "last_update")
    private Date last_update;

    @ManyToOne
    @JoinColumn(name = "film_id", referencedColumnName = "film_id")
    private Film film;

    @ManyToOne
    @JoinColumn(name = "store_id", referencedColumnName = "store_id")
    private Store store;

}
