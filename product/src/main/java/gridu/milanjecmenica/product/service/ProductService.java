package gridu.milanjecmenica.product.service;

import java.util.List;

import gridu.milanjecmenica.product.model.Product;

public interface ProductService {

    public Product getProduct(String id);

    public List<Product> getProducts(String sku);
    
}
