package com.ajulay.adcompany.service;

import com.ajulay.adcompany.domain.Ad;
import com.ajulay.adcompany.domain.Category;

import java.util.List;

public interface AdService {

    Ad findById(Long id);
    List<Ad> findByCategory(Category category);
    List<Ad> findAll();
    void updateAd(Ad ad);
    void saveAd(Ad ad);
    void remove(Ad ad);
}
