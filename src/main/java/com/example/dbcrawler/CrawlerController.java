package com.example.dbcrawler;

import com.example.dbcrawler.model.TableInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CrawlerController {

    private final DatabaseCrawlerService crawlerService;

    @Autowired
    public CrawlerController() throws Exception {
        this.crawlerService = new DatabaseCrawlerService(ConfigLoader.loadConfig("src/main/resources/dbconfig.json"));
    }

    @GetMapping("/metadata")
    public List<TableInfo> getMetadata() throws Exception {
        return crawlerService.fetchTableMetadata();
    }

    @GetMapping("/generate")
    public String generateModels() throws Exception {
        List<TableInfo> tables = crawlerService.fetchTableMetadata();
        String outputDir = "src/main/java/com/example/dbcrawler/generated";
        for (TableInfo table : tables) {
            crawlerService.saveModelClassToFile(table, outputDir);
        }
        return "Model classes generated successfully.";
    }
}
