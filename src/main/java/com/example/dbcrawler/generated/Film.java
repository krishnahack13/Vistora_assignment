package com.example.dbcrawler.generated;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "film")
public class Film {

    @Column(name = "film_id")
    private int film_id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "release_year")
    private String release_year;

    @Column(name = "language_id")
    private int language_id;

    @Column(name = "original_language_id")
    private int original_language_id;

    @Column(name = "rental_duration")
    private int rental_duration;

    @Column(name = "rental_rate")
    private double rental_rate;

    @Column(name = "length")
    private int length;

    @Column(name = "replacement_cost")
    private double replacement_cost;

    @Column(name = "rating")
    private String rating;

    @Column(name = "special_features")
    private String special_features;

    @Column(name = "last_update")
    private Date last_update;

    @ManyToOne
    @JoinColumn(name = "language_id", referencedColumnName = "language_id")
    private Language language;

    @ManyToOne
    @JoinColumn(name = "original_language_id", referencedColumnName = "language_id")
    private Language language;

}
