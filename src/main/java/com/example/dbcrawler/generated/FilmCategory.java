package com.example.dbcrawler.generated;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "film_category")
public class FilmCategory {

    @Column(name = "film_id")
    private int film_id;

    @Column(name = "category_id")
    private int category_id;

    @Column(name = "last_update")
    private Date last_update;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "film_id", referencedColumnName = "film_id")
    private Film film;

}
