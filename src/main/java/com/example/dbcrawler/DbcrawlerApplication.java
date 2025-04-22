package com.example.dbcrawler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.List;

import com.example.dbcrawler.model.TableInfo;

@SpringBootApplication
public class DbcrawlerApplication {
    public static void main(String[] args) {
        SpringApplication.run(DbcrawlerApplication.class, args);

        try {
            DbConfig config = ConfigLoader.loadConfig("src/main/resources/dbconfig.json");
            DatabaseCrawlerService service = new DatabaseCrawlerService(config);
            List<TableInfo> tables = service.fetchTableMetadata();

            String outputDir = "src/main/java/com/example/dbcrawler/generated";
            new File(outputDir).mkdirs();

            for (TableInfo table : tables) {
                service.saveModelClassToFile(table, outputDir);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}