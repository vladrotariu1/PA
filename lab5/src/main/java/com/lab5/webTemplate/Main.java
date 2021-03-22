package com.lab5.webTemplate;

import com.lab5.compulsory.Catalog;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import static com.lab5.compulsory.CatalogUtil.load;

public class Main {
    public static void main(String[] args) throws Exception {

        // 1. Configure FreeMarker
        Configuration cfg = new Configuration();
        cfg.setDirectoryForTemplateLoading(new File("src/main/java/com/lab5/webTemplate"));

        // 2. Prepare input
        Map<String, Object> input = new HashMap<>();
        Catalog catalog = load("D:/PA/lab5/savings/catalog.ser");
        input.put("catalog", catalog);

        // 3. Get the template
        Template template = cfg.getTemplate("index.ftl");

        // 4. Write output into a file:
        Writer fileWriter = new FileWriter(new File("src/main/java/com/lab5/webTemplate/output.html"));
        try {
            template.process(input, fileWriter);
        } finally {
            fileWriter.close();
        }

    }
}
