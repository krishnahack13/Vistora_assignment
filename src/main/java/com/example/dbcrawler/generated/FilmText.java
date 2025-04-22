package com.example.dbcrawler.generated;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "film_text")
public class FilmText {

    @Column(name = "film_id")
    private int film_id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

}
