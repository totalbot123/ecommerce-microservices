package gridu.milanjecmenica.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import gridu.milanjecmenica.product.model.Product;
import gridu.milanjecmenica.product.service.ProductService;

@RestController
public class GridUProductController implements ProductController {

    @Autowired
    private ProductService productService;

    @Override
    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable String id) {
        return productService.getProduct(id);
    }

    @Override
    @PostMapping("/products")
    public List<Product> getProducts(String sku) {
        return productService.getProducts(sku);
    }
    
}
