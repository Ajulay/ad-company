package com.ajulay.adcompany.service;

import com.ajulay.adcompany.dao.CompanyDao;
import com.ajulay.adcompany.domain.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyDao dao;

    @Override
    @Transactional(readOnly = true)
    public Company findById(Long id) {
        return dao.loadById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Company> findByParam(Company company) {
        return dao.loadByCriteria(company);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Company> findAll() {
        return dao.loadByCriteria(null);
    }

    @Override
    @Transactional
    public void updateCompany(Company company) {
        dao.update(company);
    }

    @Override
    @Transactional
    public void saveCompany(Company company) {
        dao.save(company);
    }

    @Override
    @Transactional
    public void removeCompany(Company company) {
        dao.remove(company);
    }

}
