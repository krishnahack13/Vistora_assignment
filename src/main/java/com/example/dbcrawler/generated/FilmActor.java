package com.example.dbcrawler.generated;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "film_actor")
public class FilmActor {

    @Column(name = "actor_id")
    private int actor_id;

    @Column(name = "film_id")
    private int film_id;

    @Column(name = "last_update")
    private Date last_update;

    @ManyToOne
    @JoinColumn(name = "actor_id", referencedColumnName = "actor_id")
    private Actor actor;

    @ManyToOne
    @JoinColumn(name = "film_id", referencedColumnName = "film_id")
    private Film film;

}
