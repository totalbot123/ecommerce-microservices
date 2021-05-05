package gridu.milanjecmenica.catalog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gridu.milanjecmenica.catalog.model.Product;
import gridu.milanjecmenica.catalog.repository.CatalogRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class GridUCatalogService implements CatalogService {

    public final static Product productStub = new Product();

    private CatalogRepository catalogRepository;

    @Autowired
    public GridUCatalogService(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    @Override
    @CircuitBreaker(name = "default", fallbackMethod="defaultProduct")
    @Retry(name = "default", fallbackMethod="defaultProduct")
    public Product getProduct(String id) {
        throw new NullPointerException();
        // Product product = this.catalogRepository.findById(id).orElse(productStub);
        // return product;
    }

    @Override
    @CircuitBreaker(name = "default")
    @Retry(name = "default")
    public List<Product> getProducts(String sku) {
        List<Product> productList = this.catalogRepository.findBySku(sku);
        return productList;
    }
    
    public Product defaultProduct(String id, Throwable t) {
        Product product = new Product();
        product.setId("test");
        product.setCategory("test");
        product.setColor("test");
        product.setName("test");
        product.setSku("test");
        return product;
    }
}
