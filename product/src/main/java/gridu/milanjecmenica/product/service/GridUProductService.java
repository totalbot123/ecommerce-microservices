package gridu.milanjecmenica.product.service;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import gridu.milanjecmenica.product.model.Inventory;
import gridu.milanjecmenica.product.model.Product;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GridUProductService implements ProductService {

    public static final Product productStub = new Product();

    @Autowired
    RestTemplate restTemplate;

    Function<Product, ResponseEntity<Inventory>> toInventory = p -> {
        return this.restTemplate.getForEntity("http://inventory/inventory/{id}", Inventory.class, p.getId()); 
    };

    @Override
    public Product getProduct(String id) {
        ResponseEntity<Product> productEntity = this.restTemplate.getForEntity("http://catalog/product/{id}", Product.class, id);
        ResponseEntity<Inventory> inventoryEntity = this.restTemplate.getForEntity("http://inventory/inventory/{id}", Inventory.class, id);
        if (productEntity.getStatusCode() == HttpStatus.NOT_FOUND || inventoryEntity.getStatusCode() == HttpStatus.NOT_FOUND) {
            log.error("GridUProductService :: getProduct - Error!");
            return productStub;
        }
        Inventory inventory = inventoryEntity.getBody();
        if (inventory.getInventory() <= 0) {
            log.info("GridUProductService :: getProduct - Inventory 0 for product: " + inventory.getId());
            return productStub;
        }
        log.info("GridUProductService :: getProduct - Success!");
        return productEntity.getBody();
    }

    @Override
    public List<Product> getProducts(String sku) {
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
        requestBody.add("sku", sku);
        Product[] initialProductsRaw = this.restTemplate.postForObject("http://catalog/products", requestBody, Product[].class);
        List<Product> initialProducts = Arrays.asList(initialProductsRaw);
        List<Product> products = initialProducts.stream()
                                                .map(toInventory)
                                                .flatMap(id -> initialProducts.stream()
                                                                              .filter(p -> filterProducts(id, p)))
                                                .collect(Collectors.toList());
        log.info("GridUProductService :: getProducts - Success!");
        return products;
    }

    private boolean filterProducts(ResponseEntity<Inventory> inventoryResponse, Product product) {
        return inventoryResponse.getStatusCode() == HttpStatus.OK 
            && inventoryResponse.getBody().getInventory() > 0 
            && inventoryResponse.getBody().getId().equals(product.getId());
    }

}
