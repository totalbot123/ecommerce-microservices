package gridu.milanjecmenica.catalog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gridu.milanjecmenica.catalog.model.Product;
import gridu.milanjecmenica.catalog.repository.CatalogRepository;

@Service
public class GridUCatalogService implements CatalogService {

    public final static Product productStub = new Product();

    private CatalogRepository catalogRepository;

    @Autowired
    public GridUCatalogService(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    @Override
    public Product getProduct(String id) {
        Product product = this.catalogRepository.findById(id).orElse(productStub);
        return product;
    }

    @Override
    public List<Product> getProducts(String sku) {
        List<Product> productList = this.catalogRepository.findBySku(sku);
        return productList;
    }
    
}
