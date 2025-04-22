package com.example.dbcrawler.generated;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "city")
public class City {

    @Column(name = "city_id")
    private int city_id;

    @Column(name = "city")
    private String city;

    @Column(name = "country_id")
    private int country_id;

    @Column(name = "last_update")
    private Date last_update;

    @Column(name = "ID")
    private int ID;

    @Column(name = "Name")
    private String Name;

    @Column(name = "CountryCode")
    private String CountryCode;

    @Column(name = "District")
    private String District;

    @Column(name = "Population")
    private int Population;

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "country_id")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "CountryCode", referencedColumnName = "Code")
    private Country country;

}
