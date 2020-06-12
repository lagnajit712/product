package com.microservice.server.product.repository;

import com.microservice.server.product.entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class ProductRepositoryImpl implements ProductRepository {

  private static final Logger log = LoggerFactory.getLogger(ProductRepositoryImpl.class);

  @PersistenceContext
  private EntityManager entityManager;

  @Override public <Product> void save(Product entity) {
    entityManager.persist(entity);
  }

  @Override public <Product> void update(Product entity) {
    entityManager.merge(entity);
  }

  @Override public <Product> void delete(Long id) {
    entityManager.remove(find(id));
  }

  @Override public Product find(Long id) {
    TypedQuery<Product> query;
    Product result = new Product();
    try {
      query = entityManager.createQuery("SELECT p FROM Product p where p.id =:id ", Product.class);
      query.setParameter("id", id);
      //query.setMaxResults(Optional.of(Integer.parseInt(config.getProperty("batch.max.results"))).orElse(200));
      log.debug("Query Executing : {}", query.toString());
      result = query.getSingleResult();
      return result;
    } catch (Exception e) {
      log.error("Exception in Id : {}, message {}", id, e);
    }
    return result;
  }
}
