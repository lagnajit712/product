package com.microservice.server.product.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "product", uniqueConstraints = {@UniqueConstraint(columnNames = {"Id", "startTime"})})
public class Product implements Serializable {

  private static final Logger log = LoggerFactory.getLogger(Product.class);

  @Id
  @SequenceGenerator(name = "PD_ID_SEQ", sequenceName = "PD_ID_SEQ", allocationSize = 1)
  @GeneratedValue(generator = "PD_ID_SEQ", strategy = GenerationType.SEQUENCE)
  private Long id;
  private String name;
  private String description;
  private Date startTime;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public Date getStartTime() {
    return startTime;
  }

  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  @Override public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Product product = (Product) o;
    return Objects.equals(id, product.id) &&
      Objects.equals(name, product.name) &&
      Objects.equals(description, product.description) &&
      Objects.equals(startTime, product.startTime);
  }

  @Override public int hashCode() {
    return Objects.hash(id, name, description, startTime);
  }

  @Override public String toString() {
    return "Product{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", description='" + description + '\'' +
      ", startTime=" + startTime +
      '}';
  }
}
