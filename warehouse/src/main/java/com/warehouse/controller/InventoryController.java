package com.warehouse.controller;


import com.warehouse.model.Inventory;
import com.warehouse.model.Product;
import com.warehouse.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inventories")
public class InventoryController {
    private final InventoryService service;

    public InventoryController(InventoryService service) {
        this.service = service;
    }

    // criar novo estoque
    @PostMapping
    public Inventory create(@RequestBody Inventory inventory) {
        return service.save(inventory);
    }
    // listar todos os estoques
    @GetMapping
    public List<Inventory> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventory> findByProduct(@PathVariable String productId) {
        Optional<Inventory> inventory = service.findByProduct(productId);
        return inventory.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/reduce/{productId}/{quantity}")
    public ResponseEntity<String> reduceStock(@PathVariable String productId, @PathVariable Integer quantity){
        Optional<Inventory> inventoryOpt = service.findByProduct(productId);
        if (inventoryOpt.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Produto não encontrado no estoque");
        }

        Inventory inventory = inventoryOpt.get();
        if (inventory.getAvailableQuantity() < quantity){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Estoque induficiente");
        }

        inventory.setAvailableQuantity(inventory.getAvailableQuantity() - quantity);
        service.save(inventory);

        return ResponseEntity.ok("Estoque atualizado com sucesso!");
    }
}
