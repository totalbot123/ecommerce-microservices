package gridu.milanjecmenica.catalog.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gridu.milanjecmenica.catalog.model.Product;

@Repository
public interface CatalogRepository extends CrudRepository<Product, String> {
    
    public List<Product> findBySku(String sku);
}
