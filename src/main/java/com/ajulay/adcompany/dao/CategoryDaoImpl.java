package com.ajulay.adcompany.dao;

import com.ajulay.adcompany.domain.Category;
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
public class CategoryDaoImpl implements CategoryDao {

    @PersistenceContext
    EntityManager em;

    @Override
    public Category loadById(Long id) {
        return em.find(Category.class, id);
    }

    @Override
    public void save(Category category) {
        em.persist(category);
    }

    @Override
    public void update(Category category) {
        TypedQuery<Category> query = buildTypedQueryByCriteria(category);
        query.executeUpdate();
    }

    @Override
    public List<Category> loadByCriteria(Category category) {
        TypedQuery<Category> query = buildTypedQueryByCriteria(category);
        return query.getResultList();
    }

    @Override
    public void remove(Category category) {
        em.remove(category);
    }

    @Override
    public List<Category> loadAll() {
        return em.createQuery("SELECT c FROM Category c", Category.class).getResultList();
    }

    private TypedQuery<Category> buildTypedQueryByCriteria(Category category) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Category> criteria = builder.createQuery(Category.class);
        Root<Category> root = criteria.from(Category.class);
        List<Predicate> predicates = new ArrayList<Predicate>();

        if (category.getId() != null) {
            predicates.add(builder.equal(root.get("id"), category.getId()));
        }
        if (category.getName() != null) {
            predicates.add(builder.equal(root.get("name"), category.getName()));
        }

        criteria.where(predicates.toArray(new Predicate[]{}));
        return em.createQuery(criteria);
    }
}
