package com.evaluation.evalJavaFx.services;

import com.evaluation.evalJavaFx.dtos.CategorieDTO;
import com.evaluation.evalJavaFx.models.Category;
import com.evaluation.evalJavaFx.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategorieService {
private CategoryRepository categoryRepository;

    public CategorieService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public static List<Category> getCategories() {
        return CategoryRepository.getCategories();
    }
}
