package com.microservice.server.product.dto;

import com.microservice.server.product.entity.Product;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class ProductDto {
  private Long id;
  private String name;
  private String description;
  private Date createdDate;

  public ProductDto(String name, String description) {
    this.name = name;
    this.description = description;
  }
  public ProductDto(String name, String description,Long id,Date createdDate) {
    this.name = name;
    this.description = description;
    this.id=id;
    this.createdDate=createdDate;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  @Override public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    ProductDto that = (ProductDto) o;
    return Objects.equals(id, that.id) &&
      Objects.equals(name, that.name) &&
      Objects.equals(description, that.description) &&
      Objects.equals(createdDate, that.createdDate);
  }

  @Override public int hashCode() {
    return Objects.hash(id, name, description, createdDate);
  }

  @Override public String toString() {
    return "ProductDto{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", description='" + description + '\'' +
      ", createdDate=" + createdDate +
      '}';
  }

  public Product convert(){
    Product product= new Product();
    product.setName(this.name);
    product.setDescription(this.description);
    product.setStartTime(Date.from(Instant.now()));
    return product;
  }
}
