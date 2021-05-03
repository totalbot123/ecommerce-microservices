package gridu.milanjecmenica.inventory.controller;

import static gridu.milanjecmenica.inventory.service.GridUInventoryService.stub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Inventory> getInventory(@PathVariable String id) {
        Inventory inventory = this.inventoryService.getInventory(id);
        if (inventory.equals(stub)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(inventory, HttpStatus.OK);
    }

    
}
