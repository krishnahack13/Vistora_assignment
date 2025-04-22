package com.example.dbcrawler.model;

public class IndexInfo {
    private String indexName;
    private String columnName;
    private boolean isUnique;

    public IndexInfo(String indexName, String columnName, boolean isUnique) {
        this.indexName = indexName;
        this.columnName = columnName;
        this.isUnique = isUnique;
    }

    public String getIndexName() {
        return indexName;
    }

    public String getColumnName() {
        return columnName;
    }

    public boolean isUnique() {
        return isUnique;
    }
}
