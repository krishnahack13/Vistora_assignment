package com.example.dbcrawler.generated;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "countrylanguage")
public class Countrylanguage {

    @Column(name = "CountryCode")
    private String CountryCode;

    @Column(name = "Language")
    private String Language;

    @Column(name = "IsOfficial")
    private String IsOfficial;

    @Column(name = "Percentage")
    private double Percentage;

    @ManyToOne
    @JoinColumn(name = "CountryCode", referencedColumnName = "Code")
    private Country country;

}
