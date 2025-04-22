package com.example.dbcrawler.generated;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "actor")
public class Actor {

    @Column(name = "actor_id")
    private int actor_id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "last_update")
    private Date last_update;

}
