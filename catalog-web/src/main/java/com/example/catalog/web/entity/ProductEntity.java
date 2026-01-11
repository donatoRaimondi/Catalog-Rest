package com.example.catalog.web.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class ProductEntity {

  @Id
  @Column(length = 50)
  private String id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private boolean active = true;

  protected ProductEntity() {}

  public ProductEntity(String id, String name, boolean active) {
    this.id = id;
    this.name = name;
    this.active = active;
  }

  public String getId() { return id; }
  public void setId(String id) { this.id = id; }

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  public boolean isActive() { return active; }
  public void setActive(boolean active) { this.active = active; }
}

