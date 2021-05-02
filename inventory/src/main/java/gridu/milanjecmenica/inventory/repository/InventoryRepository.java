package gridu.milanjecmenica.inventory.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gridu.milanjecmenica.inventory.model.Inventory;

@Repository
public interface InventoryRepository extends CrudRepository<Inventory, String> {
    
}
