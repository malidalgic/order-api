package com.abas.orderapi.service;

import com.abas.orderapi.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrderService {

    public double getTotalAmount(List<Order> orders) {
        return orders.stream()
                .mapToDouble(Order::getTotalPrice)
                .sum();
    }

    public double getAveragePrice(List<Order> orders) {
        double totalWeightedPrice = orders.stream()
                .mapToDouble(order -> order.getUnitPrice() * order.getQuantity())
                .sum();
        int totalQuantity = orders.stream()
                .mapToInt(Order::getQuantity)
                .sum();

        return totalWeightedPrice / totalQuantity;
    }

    public Map<Integer, Double> getAveragePricesByItem(List<Order> orders) {
        return orders.stream()
                .collect(Collectors.groupingBy(Order::getItemNumber,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                itemOrders -> {
                                    double totalWeightedPrice = itemOrders.stream()
                                            .mapToDouble(order -> order.getUnitPrice() * order.getQuantity())
                                            .sum();
                                    int totalQuantity = itemOrders.stream()
                                            .mapToInt(Order::getQuantity)
                                            .sum();
                                    return totalWeightedPrice / totalQuantity;
                                }
                        )
                ));
    }

    public Map<Integer, Map<Integer, Integer>> getItemOrderCounts(List<Order> orders) {
        return orders.stream()
                .collect(Collectors.groupingBy(Order::getItemNumber,
                        Collectors.groupingBy(Order::getOrderNumber,
                                Collectors.summingInt(Order::getQuantity))));
    }
}
