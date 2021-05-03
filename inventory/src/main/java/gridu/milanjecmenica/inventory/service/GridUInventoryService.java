package gridu.milanjecmenica.inventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gridu.milanjecmenica.inventory.model.Inventory;
import gridu.milanjecmenica.inventory.repository.InventoryRepository;

@Service
public class GridUInventoryService implements InventoryService {

    public final static Inventory stub = new Inventory();

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public Inventory getInventory(String id) {
        return this.inventoryRepository.findById(id).orElse(stub);
    }

}
