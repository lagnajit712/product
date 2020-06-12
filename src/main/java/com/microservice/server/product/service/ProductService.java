package com.microservice.server.product.service;

import com.microservice.server.product.dto.ProductDto;
import com.microservice.server.product.entity.Product;
import com.microservice.server.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  @Autowired ProductRepository productRepository;

  public void saveProduct(ProductDto productDto){
    productRepository.save(productDto.convert());
  }
  public void updateProduct(ProductDto productDto){
    productRepository.update(productDto.convert());
  }
  public ProductDto findProduct(Long Id){
    Product pd=productRepository.find(Id);
    ProductDto productDto= new ProductDto(pd.getName(),pd.getDescription(),pd.getId(),pd.getStartTime());;
    return productDto;
  }
  public void deleteProduct(Long Id){
    productRepository.delete(Id);
  }

}
