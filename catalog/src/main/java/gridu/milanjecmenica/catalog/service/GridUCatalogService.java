package gridu.milanjecmenica.catalog.service;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import gridu.milanjecmenica.catalog.model.Product;
import gridu.milanjecmenica.catalog.repository.CatalogRepository;

@Service
public class GridUCatalogService implements CatalogService {

    private CatalogRepository catalogRepository;

    @JsonProperty(value = "products", required = true)
    List<Product> productList;

    @Autowired
    public GridUCatalogService(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    @Override
    public Product getProduct(String id) {
        return this.catalogRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find product with id: " + id));
    }

    @Override
    public List<Product> getProducts(String sku) {
        productList = this.catalogRepository.findBySku(sku);
        if (productList.isEmpty()) { 
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are no products matching " + sku + " SKU.");
        }
        return productList;
    }
    
}
