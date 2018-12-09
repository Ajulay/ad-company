package com.ajulay.adcompany.dao;

import com.ajulay.adcompany.domain.Ad;
import com.ajulay.adcompany.domain.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CompanyDaoImpl implements CompanyDao {

    @PersistenceContext
    EntityManager em;

    @Autowired
    AdDao adDao;

    @Override
    public Company loadById(Long id) {
        return em.find(Company.class, id);
    }

    @Override
    public void save(Company company) {
        em.persist(company);
    }

    @Override
    public void update(Company company) {
        TypedQuery<Company> query = buildCriteria(company);
        query.executeUpdate();
    }

    @Override
    public List<Company> loadByCriteria(Company company) {
        TypedQuery<Company> query = buildCriteria(company);
        return query.getResultList();
    }

    @Override
    public void remove(Company company) {
        em.remove(company);
    }

    @Override
    public Company loadByAd(Ad ad) {
        return adDao.loadCompanyByAd(ad);
    }

    private TypedQuery<Company> buildCriteria(Company company) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Company> criteria = builder.createQuery(Company.class);
        Root<Company> root = criteria.from(Company.class);
        List<Predicate> predicates = new ArrayList<Predicate>();

        if(company != null) {
            if (company.getId() != null) {
                predicates.add(builder.equal(root.get("id"), company.getId()));
            }
            if (company.getName() != null) {
                predicates.add(builder.equal(root.get("name"), company.getName()));
            }
            if (company.getAddres() != null) {
                predicates.add(builder.equal(root.get("addres"), company.getAddres()));
            }

            if (company.getDescription() != null) {
                predicates.add(builder.equal(root.get("description"), company.getDescription()));
            }
        }
        criteria.where(predicates.toArray(new Predicate[]{}));

        return em.createQuery(criteria);
    }
}
