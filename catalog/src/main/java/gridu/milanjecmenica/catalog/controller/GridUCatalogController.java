package gridu.milanjecmenica.catalog.controller;

import static gridu.milanjecmenica.catalog.service.GridUCatalogService.productStub;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import gridu.milanjecmenica.catalog.model.Product;
import gridu.milanjecmenica.catalog.service.CatalogService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class GridUCatalogController implements CatalogController {

    private CatalogService catalogService;

    @Autowired
    public GridUCatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @Override
    @GetMapping(value = "/product/{id}", produces = "application/json")
    @ResponseBody
    public ResponseEntity<Product> getProduct(@PathVariable String id) {
        Product product = catalogService.getProduct(id);
        if (product.equals(productStub)) {
            log.error("GridUCatalogController :: getProduct - Product not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        log.info("GridUCatalogController :: getProduct - Success!");
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @Override
    @PostMapping("/products")
    public ResponseEntity<List<Product> > getProducts(@RequestParam String sku) {
        List<Product> productList = catalogService.getProducts(sku);
        if (productList.isEmpty()) {
            log.error("GridUCatalogController :: getProducts - No products with set SKU");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        log.info("GridUCatalogController :: getProducts - Success!");
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
    
}
