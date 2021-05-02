package gridu.milanjecmenica.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import gridu.milanjecmenica.inventory.model.Inventory;
import gridu.milanjecmenica.inventory.service.InventoryService;


@RestController
public class GridUInventoryController implements InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @Override
    @GetMapping("/inventory/{id}")
    public Inventory getInventory(@PathVariable String id) {
        return this.inventoryService.getInventory(id);
    }

    
}
