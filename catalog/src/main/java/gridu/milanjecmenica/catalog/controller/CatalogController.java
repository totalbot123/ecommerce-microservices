package gridu.milanjecmenica.catalog.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import gridu.milanjecmenica.catalog.model.Product;

public interface CatalogController {
 
    public ResponseEntity<Product> getProduct(String id);

    public ResponseEntity<List<Product> > getProducts(String sku);

}
