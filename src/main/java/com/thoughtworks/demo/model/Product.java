package com.thoughtworks.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sun.util.resources.zh.TimeZoneNames_zh_CN;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.TimeZone;

@Entity
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void updateProduct(Product product) {
        this.name = product.getName();
        this.brand = product.getBrand();
        this.price = product.getPrice();
        this.category = product.getCategory();
        this.description = product.getDescription();
        this.productionDate = product.getProductionDate();
        this.productionPlace = product.getProductionPlace();
    }

    private String name;
    private Double price;
    private String category;
    private String brand;
    private String description;
    @Column(name = "production_date")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date productionDate;
    @Column(name = "production_place")
    private String productionPlace;
}
