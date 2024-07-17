package com.abas.orderapi.controller;

import com.abas.orderapi.entity.Order;
import com.abas.orderapi.helper.OrderBuilder;
import com.abas.orderapi.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("order")
public class OrderController {

    private final OrderService orderService;
    private final List<Order> orders = OrderBuilder.getOrders();

    @GetMapping("/total-amount")
    public double getTotalAmount() {
        return orderService.getTotalAmount(orders);
    }

    @GetMapping("/average-price")
    public double getAveragePrice() {
        return orderService.getAveragePrice(orders);
    }

    @GetMapping("/average-prices-by-item")
    public Map<Integer, Double> getAveragePricesByItem() {
        return orderService.getAveragePricesByItem(orders);
    }

    @GetMapping("/item-order-counts")
    public Map<Integer, Map<Integer, Integer>> getItemOrderCounts() {
        return orderService.getItemOrderCounts(orders);
    }
}
