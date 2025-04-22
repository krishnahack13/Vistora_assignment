package com.example.dbcrawler.generated;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "category")
public class Category {

    @Column(name = "category_id")
    private int category_id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_update")
    private Date last_update;

}
