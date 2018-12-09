package com.ajulay.adcompany.dao;

import com.ajulay.adcompany.domain.Ad;
import com.ajulay.adcompany.domain.Company;
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
public class AdDaoImpl implements AdDao {

    @PersistenceContext
    EntityManager em;

    @Override
    public Ad loadById(Long id) {
        return em.find(Ad.class, id);
    }

    @Override
    public void save(Ad ad) {
        em.persist(ad);
    }

    @Override
    public void update(Ad ad) {
        TypedQuery<Ad> query  = buildTypedQuery(ad);
        query.executeUpdate();
    }

    @Override
    public List<Ad> loadByCriteria(Ad ad) {
        TypedQuery<Ad> query = buildTypedQuery(ad);
        return query.getResultList();
    }

    @Override
    public void remove(Ad ad) {
            em.remove(ad);
    }

    @Override
    public Company loadCompanyByAd(Ad ad) {
        return buildTypedQuery(ad).getSingleResult().getCompany();
    }


    private TypedQuery<Ad> buildTypedQuery(Ad ad) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Ad> criteria = builder.createQuery(Ad.class);
        Root<Ad> root = criteria.from(Ad.class);
        List<Predicate> predicates = new ArrayList<Predicate>();

        if(ad != null) {
            if (ad.getId() != null) {
                predicates.add(builder.equal(root.get("id"), ad.getId()));
            }
            if (ad.getName() != null) {
                predicates.add(builder.equal(root.get("name"), ad.getName()));
            }
            if (ad.getContent() != null) {
                predicates.add(builder.equal(root.get("content"), ad.getContent()));
            }

            if (ad.getPhone() != null) {
                predicates.add(builder.equal(root.get("phone"), ad.getPhone()));
            }

            if (ad.getCompany() != null) {
                predicates.add(builder.equal(root.get("company").get("id"), ad.getCompany().getId()));
            }

            if (ad.getCategory() != null) {
                predicates.add(builder.equal(root.get("category").get("id"), ad.getCategory().getId()));
            }
        }
        criteria.where(predicates.toArray(new Predicate[]{}));
        return em.createQuery(criteria);
    }
}
