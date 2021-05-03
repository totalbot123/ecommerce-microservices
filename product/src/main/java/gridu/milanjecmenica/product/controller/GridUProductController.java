package gridu.milanjecmenica.product.controller;

import static gridu.milanjecmenica.product.service.GridUProductService.productStub;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gridu.milanjecmenica.product.model.Product;
import gridu.milanjecmenica.product.service.ProductService;

@RestController
public class GridUProductController implements ProductController {

    @Autowired
    private ProductService productService;

    @Override
    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable String id) {
        Product product = productService.getProduct(id);
        if (product.equals(productStub)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @Override
    @PostMapping("/products")
    public ResponseEntity<List<Product> > getProducts(@RequestParam String sku) {
        List<Product> productList = productService.getProducts(sku);
        if (productList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
    
}
