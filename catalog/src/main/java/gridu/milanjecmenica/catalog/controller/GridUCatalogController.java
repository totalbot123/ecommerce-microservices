package gridu.milanjecmenica.catalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import gridu.milanjecmenica.catalog.model.Product;
import gridu.milanjecmenica.catalog.service.CatalogService;

@RestController
public class GridUCatalogController implements CatalogController {

    private CatalogService catalogService;

    @Autowired
    public GridUCatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @Override
    @GetMapping(value = "/product/{id}", produces = "application/json")
    @ResponseBody
    public Product getProduct(@PathVariable String id) {
        return catalogService.getProduct(id);
    }

    @Override
    @PostMapping("/products")
    public List<Product> getProducts(@RequestParam String sku) {
        return catalogService.getProducts(sku);
    }
    
}
