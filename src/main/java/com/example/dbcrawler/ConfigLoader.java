package com.example.dbcrawler;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ConfigLoader {
    public static DbConfig loadConfig(String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(path), DbConfig.class);
    }
}