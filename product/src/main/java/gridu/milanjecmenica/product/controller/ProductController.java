package gridu.milanjecmenica.product.controller;

import java.util.List;

import gridu.milanjecmenica.product.model.Product;

public interface ProductController {

    public Product getProduct(String id);

    public List<Product> getProducts(String sku);
}
