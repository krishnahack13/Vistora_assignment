package com.example.dbcrawler;

import com.example.dbcrawler.model.*;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.*;

public class DatabaseCrawlerService {
    private final DbConfig config;

    public DatabaseCrawlerService(DbConfig config) {
        this.config = config;
    }

    public List<TableInfo> fetchTableMetadata() throws Exception {
        List<TableInfo> tableInfos = new ArrayList<>();
        Connection conn = DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword());
        DatabaseMetaData metaData = conn.getMetaData();

        ResultSet tables = metaData.getTables(null, null, "%", new String[]{"TABLE"});
        while (tables.next()) {
            String tableName = tables.getString("TABLE_NAME");
            TableInfo tableInfo = new TableInfo();
            tableInfo.setTableName(tableName);

            List<ColumnInfo> columns = new ArrayList<>();
            ResultSet cols = metaData.getColumns(null, null, tableName, null);
            while (cols.next()) {
                String name = cols.getString("COLUMN_NAME");
                String type = cols.getString("TYPE_NAME");
                boolean nullable = cols.getInt("NULLABLE") == DatabaseMetaData.columnNullable;
                columns.add(new ColumnInfo(name, type, nullable));
            }
            tableInfo.setColumns(columns);

            List<String> pk = new ArrayList<>();
            ResultSet pks = metaData.getPrimaryKeys(null, null, tableName);
            while (pks.next()) {
                pk.add(pks.getString("COLUMN_NAME"));
            }
            tableInfo.setPrimaryKeys(pk);

            List<ForeignKeyInfo> fks = new ArrayList<>();
            ResultSet fkeys = metaData.getImportedKeys(null, null, tableName);
            while (fkeys.next()) {
                fks.add(new ForeignKeyInfo(
                        fkeys.getString("FKCOLUMN_NAME"),
                        fkeys.getString("PKTABLE_NAME"),
                        fkeys.getString("PKCOLUMN_NAME")
                ));
            }
            tableInfo.setForeignKeys(fks);

            List<IndexInfo> indexes = new ArrayList<>();
            ResultSet inds = metaData.getIndexInfo(null, null, tableName, false, false);
            while (inds.next()) {
                indexes.add(new IndexInfo(
                        inds.getString("INDEX_NAME"),
                        inds.getString("COLUMN_NAME"),
                        !inds.getBoolean("NON_UNIQUE")
                ));
            }
            tableInfo.setIndexes(indexes);

            tableInfos.add(tableInfo);
        }

        conn.close();
        return tableInfos;
    }

    public void saveModelClassToFile(TableInfo table, String outputDir) throws IOException {
        String className = toClassName(table.getTableName());
        StringBuilder sb = new StringBuilder();
        sb.append("package com.example.dbcrawler.generated;\n\n")
          .append("import jakarta.persistence.*;\n")
          .append("import java.util.*;\n\n")
          .append("@Entity\n")
          .append("@Table(name = \"").append(table.getTableName()).append("\")\n")
          .append("public class ").append(className).append(" {\n\n");

        Set<String> existingFields = new HashSet<>();
        for (ColumnInfo col : table.getColumns()) {
            String fieldName = col.getName();
            existingFields.add(fieldName);
            sb.append("    @Column(name = \"").append(fieldName).append("\")\n");
            sb.append("    private ").append(mapToJavaType(col.getType())).append(" ").append(fieldName).append(";\n\n");
        }

        for (ForeignKeyInfo fk : table.getForeignKeys()) {
            String referencedClass = toClassName(fk.getReferencedTableName());
            String fieldName = fk.getReferencedTableName().toLowerCase();
            if (existingFields.contains(fieldName)) {
                fieldName = fieldName + "Ref";
            }
            sb.append("    @ManyToOne\n");
            sb.append("    @JoinColumn(name = \"").append(fk.getColumnName())
              .append("\", referencedColumnName = \"").append(fk.getReferencedColumnName()).append("\")\n");
            sb.append("    private ").append(referencedClass).append(" ").append(fieldName).append(";\n\n");
        }

        sb.append("}\n");
        try (FileWriter fw = new FileWriter(outputDir + "/" + className + ".java")) {
            fw.write(sb.toString());
        }
    }

    private String toClassName(String tableName) {
        return Arrays.stream(tableName.split("_"))
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .reduce("", String::concat);
    }

    private String mapToJavaType(String dbType) {
        dbType = dbType.toLowerCase();
        if (dbType.contains("int")) return "int";
        if (dbType.contains("char") || dbType.contains("text")) return "String";
        if (dbType.contains("date") || dbType.contains("time")) return "Date";
        if (dbType.contains("bool")) return "boolean";
        if (dbType.contains("float") || dbType.contains("double") || dbType.contains("decimal")) return "double";
        return "String";
    }
}
