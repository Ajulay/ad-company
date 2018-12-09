package com.ajulay.adcompany.service;

import com.ajulay.adcompany.dao.AdDao;
import com.ajulay.adcompany.domain.Ad;
import com.ajulay.adcompany.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdServiceImpl implements AdService {

    @Autowired
    AdDao dao;

    @Override
    @Transactional(readOnly = true)
    public Ad findById(Long id) {
        return dao.loadById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Ad> findByCategory(Category category) {
        Ad ad = new Ad();
        ad.setCategory(category);
        return dao.loadByCriteria(ad);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Ad> findAll() {
        return dao.loadByCriteria(null);
    }

    @Override
    @Transactional
    public void updateAd(Ad ad) {
        dao.update(ad);
    }

    @Override
    @Transactional
    public void saveAd(Ad ad) {
        dao.save(ad);
    }

    @Override
    @Transactional
    public void remove(Ad ad) {
        dao.remove(ad);
    }




}
