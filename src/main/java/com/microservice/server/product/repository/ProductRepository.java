package com.microservice.server.product.repository;

import com.microservice.server.product.entity.Product;

import java.util.List;

public interface ProductRepository {

  <Product> void save(Product entitie);

  <Product> void update(Product entities);

  <Product> void delete(Long Id);

  Product find(Long Id);

}
