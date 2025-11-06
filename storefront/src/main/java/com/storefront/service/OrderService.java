package com.storefront.service;

import com.storefront.client.WharehouseClient;
import com.storefront.dto.InventoryResponse;
import com.storefront.model.Order;
import com.storefront.model.OrderItem;
import com.storefront.repository.OrderRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository repository;
    private final WharehouseClient wharehouseClient;
    private final OrderPublisher orderPublisher;
    public OrderService(OrderRepository repository, WharehouseClient wharehouseClient, OrderPublisher orderPublisher) {
        this.repository = repository;
        this.wharehouseClient = wharehouseClient;
        this.orderPublisher = orderPublisher;
    }

    public Order createOrder(Order order){
        for (OrderItem item : order.getItems()) {
            InventoryResponse inventory = wharehouseClient.getInventoryByProductId(item.getProductSku());
            if (inventory == null || inventory.getAvailableQuantity() < item.getQuantity()) {
                throw new RuntimeException("Estoque insuficiente para o produto" + item.getProductSku());
            }
            wharehouseClient.reduceStock(item.getProductSku(), item.getQuantity());
        }

        double total = order.getItems().stream()
                .mapToDouble(i -> i.getPrice() * i.getQuantity())
                .sum();
        order.setTotal(total);

        Order savedOrder = repository.save(order);
        orderPublisher.sendOrder(savedOrder);

        return savedOrder;
    }

    public Order save(Order order) {
        double total = order.getItems().stream()
                .mapToDouble(i -> i.getPrice() * i.getQuantity())
                .sum();
        order.setTotal(total);

        order.getItems().forEach(item -> item.setOrder(order));

        return repository.save(order);
    }

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Optional<Order> findById(Long id) {
        return repository.findById(id);
    }

}
