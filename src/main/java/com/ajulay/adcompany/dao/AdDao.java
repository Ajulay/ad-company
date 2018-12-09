package com.ajulay.adcompany.dao;

import com.ajulay.adcompany.domain.Ad;
import com.ajulay.adcompany.domain.Company;

import java.util.List;

public interface AdDao {

    Ad loadById(Long id);

    void save(Ad ad);

    void update(Ad ad);

    List<Ad> loadByCriteria(Ad ad);

    void remove(Ad ad);

    Company loadCompanyByAd(Ad ad);
}
