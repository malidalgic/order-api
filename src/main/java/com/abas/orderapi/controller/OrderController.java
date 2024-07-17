package com.abas.orderapi.controller;

import com.abas.orderapi.entity.Order;
import com.abas.orderapi.helper.OrderBuilder;
import com.abas.orderapi.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("order")
public class OrderController {

    private final OrderService orderService;
    private final List<Order> orders = OrderBuilder.getOrders();

    @GetMapping("/total-amount")
    public ResponseEntity<Map<String, Double>> getTotalAmount() {
        double totalAmount = orderService.getTotalAmount(orders);
        return ResponseEntity.ok(Map.of("totalAmount", totalAmount));
    }

    @GetMapping("/average-price")
    public ResponseEntity<Map<String, Double>> getAveragePrice() {
        double averagePrice = orderService.getAveragePrice(orders);
        return ResponseEntity.ok(Map.of("averagePrice", averagePrice));
    }

    @GetMapping("/average-prices-by-item")
    public ResponseEntity<Map<Integer, Double>> getAveragePricesByItem() {
        Map<Integer, Double> averagePricesByItem = orderService.getAveragePricesByItem(orders);
        return ResponseEntity.ok(averagePricesByItem);
    }

    @GetMapping("/item-order-counts")
    public ResponseEntity<Map<Integer, Map<Integer, Integer>>> getItemOrderCounts() {
        Map<Integer, Map<Integer, Integer>> itemOrderCounts = orderService.getItemOrderCounts(orders);
        return ResponseEntity.ok(itemOrderCounts);
    }

    @PostMapping("/add")
    public ResponseEntity<Order> addOrder(@RequestBody Order order) {
        orders.add(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }
}
