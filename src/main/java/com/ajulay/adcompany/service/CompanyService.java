package com.ajulay.adcompany.service;

import com.ajulay.adcompany.domain.Ad;
import com.ajulay.adcompany.domain.Company;
import java.util.List;

public interface CompanyService {

    Company findById(Long id);
    List<Company> findByParam(Company company);
    List<Company> findAll();
    void updateCompany(Company company);
    void saveCompany(Company company);
    void removeCompany(Company company);
}
