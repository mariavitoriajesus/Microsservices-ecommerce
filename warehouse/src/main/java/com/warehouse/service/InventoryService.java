package com.warehouse.service;

import com.warehouse.model.Inventory;
import com.warehouse.model.Product;
import com.warehouse.repository.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {
    private final InventoryRepository repository;

    public InventoryService(InventoryRepository repository) {
        this.repository = repository;
    }

    public Inventory save(Inventory inventory){
        return repository.save(inventory);
    }

    public List<Inventory> findAll(){
        return repository.findAll();
    }

    public Optional<Inventory> findByProduct(String productId) {
        return repository.findByProduct(productId);
    }
}


