package gridu.milanjecmenica.catalog.controller;

import java.util.List;

import gridu.milanjecmenica.catalog.model.Product;

public interface CatalogController {
 
    public Product getProduct(String id);

    public List<Product> getProducts(String sku);

}
