package com.ajulay.adcompany.dao;

import com.ajulay.adcompany.domain.Category;

import java.util.List;

public interface CategoryDao {

    Category loadById(Long id);

    void save(Category category);

    void update(Category category);

    List<Category> loadByCriteria(Category category);

    void remove(Category category);

    List<Category> loadAll();
}
