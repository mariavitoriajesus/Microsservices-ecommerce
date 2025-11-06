package com.warehouse.repository;

import com.warehouse.model.Inventory;
import com.warehouse.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    Optional<Inventory> findByProduct(String product);
}
