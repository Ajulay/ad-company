package com.ajulay.adcompany.service;

import com.ajulay.adcompany.dao.CategoryDao;
import com.ajulay.adcompany.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryDao dao;

    @Override
    @Transactional(readOnly = true)
    public Category findById(Long id) {
        return dao.loadById(id);
    }


    @Override
    @Transactional(readOnly = true)
    public List<Category> findAll() {
        return dao.loadAll();
    }

    @Override
    @Transactional
    public void updateCategory(Category category) {
        dao.update(category);
    }

    @Override
    @Transactional
    public void saveCategory(Category category) {
        dao.save(category);
    }

    @Override
    @Transactional
    public void remove(Category category) {

    }


}
