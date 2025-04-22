package com.example.dbcrawler.generated;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "sys_config")
public class SysConfig {

    @Column(name = "variable")
    private String variable;

    @Column(name = "value")
    private String value;

    @Column(name = "set_time")
    private Date set_time;

    @Column(name = "set_by")
    private String set_by;

}
