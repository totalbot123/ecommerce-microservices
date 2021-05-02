package gridu.milanjecmenica.catalog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "product_catalog")
@Data
public class Product {
    
    @Id
    @Column(name = "uniq_id")
    private String id;

    @Column(name = "sku")
    private String sku;

    @Column(name = "name_title")
    private String name;

    @Column(name = "color")
    private String color;

    @Column(name = "category")
    private String category;

}