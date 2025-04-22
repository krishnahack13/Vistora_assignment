package com.example.dbcrawler.generated;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "country")
public class Country {

    @Column(name = "country_id")
    private int country_id;

    @Column(name = "country")
    private String country;

    @Column(name = "last_update")
    private Date last_update;

    @Column(name = "Code")
    private String Code;

    @Column(name = "Name")
    private String Name;

    @Column(name = "Continent")
    private String Continent;

    @Column(name = "Region")
    private String Region;

    @Column(name = "SurfaceArea")
    private double SurfaceArea;

    @Column(name = "IndepYear")
    private int IndepYear;

    @Column(name = "Population")
    private int Population;

    @Column(name = "LifeExpectancy")
    private double LifeExpectancy;

    @Column(name = "GNP")
    private double GNP;

    @Column(name = "GNPOld")
    private double GNPOld;

    @Column(name = "LocalName")
    private String LocalName;

    @Column(name = "GovernmentForm")
    private String GovernmentForm;

    @Column(name = "HeadOfState")
    private String HeadOfState;

    @Column(name = "Capital")
    private int Capital;

    @Column(name = "Code2")
    private String Code2;

}
