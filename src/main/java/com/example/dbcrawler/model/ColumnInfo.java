package com.example.dbcrawler.model;

public class ColumnInfo {
    private String name;
    private String type;
    private boolean nullable;

    public ColumnInfo(String name, String type, boolean nullable) {
        this.name = name;
        this.type = type;
        this.nullable = nullable;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public boolean isNullable() {
        return nullable;
    }
}
