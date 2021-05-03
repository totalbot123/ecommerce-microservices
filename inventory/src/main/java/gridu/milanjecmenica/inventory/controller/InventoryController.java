package gridu.milanjecmenica.inventory.controller;

import org.springframework.http.ResponseEntity;

import gridu.milanjecmenica.inventory.model.Inventory;

public interface InventoryController {

    public ResponseEntity<Inventory> getInventory(String id);

}
