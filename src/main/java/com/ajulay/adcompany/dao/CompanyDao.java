package com.ajulay.adcompany.dao;

import com.ajulay.adcompany.domain.Ad;
import com.ajulay.adcompany.domain.Company;

import java.util.List;

public interface CompanyDao {

    Company loadById(Long id);

    void save(Company company);

    void update(Company company);

    List<Company> loadByCriteria(Company company);

    void remove(Company company);

    Company loadByAd(Ad ad);
}
