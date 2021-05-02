package gridu.milanjecmenica.inventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import gridu.milanjecmenica.inventory.model.Inventory;
import gridu.milanjecmenica.inventory.repository.InventoryRepository;

@Service
public class GridUInventoryService implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public Inventory getInventory(String id) {
        Inventory inventory = this.inventoryRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find inventory for product with id: " + id));
        return inventory;
    }

}
