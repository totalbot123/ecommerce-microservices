package gridu.milanjecmenica.product.service;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import gridu.milanjecmenica.product.model.Inventory;
import gridu.milanjecmenica.product.model.Product;

@Service
public class GridUProductService implements ProductService {

    @Autowired
    RestTemplate restTemplate;

    Function<Product, Inventory> toInventory = p -> {
        return this.restTemplate.getForObject("http://inventory/inventory/{id}", Inventory.class, p.getId()); 
    };

    @Override
    public Product getProduct(String id) {
        Product product = this.restTemplate.getForObject("http://catalog/product/{id}", Product.class, id);
        Inventory inventory = this.restTemplate.getForObject("http://inventory/inventory/{id}", Inventory.class, id);
        if (inventory.getInventory() > 0) {
            return product;
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Product " + product.getName() + " is not available.");
    }

    @Override
    public List<Product> getProducts(String sku) {
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
        requestBody.add("sku", sku);
        Product[] initialProductsRaw = this.restTemplate.postForObject("http://catalog/products", requestBody, Product[].class);
        List<Product> initialProducts = Arrays.asList(initialProductsRaw);
        List<Product> products = initialProducts.stream()
                                                .map(toInventory)
                                                .flatMap(id -> initialProducts.stream().filter(p -> p.getId().equals(id.getId()) && id.getInventory() > 0))
                                                .collect(Collectors.toList());
        return products;
    }



}
