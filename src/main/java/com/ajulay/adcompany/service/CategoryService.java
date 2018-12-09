package com.ajulay.adcompany.service;

import com.ajulay.adcompany.domain.Ad;
import com.ajulay.adcompany.domain.Category;

import java.util.List;

public interface CategoryService {

    Category findById(Long id);
    List<Category> findAll();
    void updateCategory(Category category);
    void saveCategory(Category category);
    void remove(Category category);
}
