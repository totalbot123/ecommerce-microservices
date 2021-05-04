package gridu.milanjecmenica.inventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gridu.milanjecmenica.inventory.model.Inventory;
import gridu.milanjecmenica.inventory.repository.InventoryRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GridUInventoryService implements InventoryService {

    public final static Inventory stub = new Inventory();

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public Inventory getInventory(String id) {
        log.info("GridUInventoryService :: getInventory - Success!");
        return this.inventoryRepository.findById(id).orElse(stub);
    }

}
