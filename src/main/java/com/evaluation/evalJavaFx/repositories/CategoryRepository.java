package com.evaluation.evalJavaFx.repositories;

import com.evaluation.evalJavaFx.models.Category;
import com.evaluation.evalJavaFx.models.Message;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {

    public static List<Category> getCategories() {

        List<Category> categories = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

        try {
            File ressourceJson  = new ClassPathResource("categories.json").getFile();
            categories = mapper.readValue(
                    ressourceJson,
                    new TypeReference<List<Category>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return categories;
    }
}
