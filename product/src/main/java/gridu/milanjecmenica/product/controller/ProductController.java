package gridu.milanjecmenica.product.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import gridu.milanjecmenica.product.model.Product;

public interface ProductController {

    public ResponseEntity<Product> getProduct(String id);

    public ResponseEntity<List<Product> > getProducts(String sku);
    
}
