package com.example.dbcrawler.generated;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "language")
public class Language {

    @Column(name = "language_id")
    private int language_id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_update")
    private Date last_update;

}
