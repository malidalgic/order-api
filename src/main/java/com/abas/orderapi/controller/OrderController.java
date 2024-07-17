package com.abas.orderapi.controller;

import com.abas.orderapi.entity.Order;
import com.abas.orderapi.helper.OrderBuilder;
import com.abas.orderapi.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("order")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/total-amount")
    public double getTotalAmount() {
        List<Order> orders = OrderBuilder.getOrders();
        return orderService.getTotalAmount(orders);
    }

    @GetMapping("/average-price")
    public double getAveragePrice() {
        List<Order> orders = OrderBuilder.getOrders();
        return orderService.getAveragePrice(orders);
    }

    @GetMapping("/average-prices-by-item")
    public Map<Integer, Double> getAveragePricesByItem() {
        List<Order> orders = OrderBuilder.getOrders();
        return orderService.getAveragePricesByItem(orders);
    }

    @GetMapping("/item-order-counts")
    public Map<Integer, Map<Integer, Integer>> getItemOrderCounts() {
        List<Order> orders = OrderBuilder.getOrders();
        return orderService.getItemOrderCounts(orders);
    }

    @PostMapping("/add")
    public Order addOrder(@RequestBody Order order) {
        List<Order> orders = OrderBuilder.getOrders();
        orders.add(order);
        return order;
    }
}
