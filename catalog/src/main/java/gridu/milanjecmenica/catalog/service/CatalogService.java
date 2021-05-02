package gridu.milanjecmenica.catalog.service;

import java.util.List;

import gridu.milanjecmenica.catalog.model.Product;

public interface CatalogService {
    
    public Product getProduct(String id);

    public List<Product> getProducts(String sku);
    
}
