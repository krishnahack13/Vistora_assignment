package com.example.dbcrawler.model;

public class ForeignKeyInfo {
    private String columnName;
    private String referencedTableName;
    private String referencedColumnName;

    public ForeignKeyInfo(String columnName, String referencedTableName, String referencedColumnName) {
        this.columnName = columnName;
        this.referencedTableName = referencedTableName;
        this.referencedColumnName = referencedColumnName;
    }

    public String getColumnName() {
        return columnName;
    }

    public String getReferencedTableName() {
        return referencedTableName;
    }

    public String getReferencedColumnName() {
        return referencedColumnName;
    }
}
