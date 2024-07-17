package com.abas.orderapi.helper;

import com.abas.orderapi.entity.Order;

import java.util.List;

public class OrderBuilder {
    public static List<Order> getOrders() {

        return List.of(
                Order.builder().orderNumber(1000).itemNumber(2000).quantity(12).unitPrice(100.51).build(),
                Order.builder().orderNumber(1000).itemNumber(2001).quantity(31).unitPrice(200).build(),
                Order.builder().orderNumber(1000).itemNumber(2002).quantity(22).unitPrice(150.86).build(),
                Order.builder().orderNumber(1000).itemNumber(2003).quantity(41).unitPrice(250).build(),
                Order.builder().orderNumber(1000).itemNumber(2004).quantity(55).unitPrice(244).build(),

                Order.builder().orderNumber(1001).itemNumber(2001).quantity(88).unitPrice(44.531).build(),
                Order.builder().orderNumber(1001).itemNumber(2002).quantity(121).unitPrice(88.11).build(),
                Order.builder().orderNumber(1001).itemNumber(2004).quantity(74).unitPrice(211).build(),
                Order.builder().orderNumber(1001).itemNumber(2002).quantity(14).unitPrice(88.11).build(),

                Order.builder().orderNumber(1002).itemNumber(2003).quantity(2).unitPrice(12.1).build(),
                Order.builder().orderNumber(1002).itemNumber(2004).quantity(3).unitPrice(22.3).build(),
                Order.builder().orderNumber(1002).itemNumber(2003).quantity(8).unitPrice(12.1).build(),
                Order.builder().orderNumber(1002).itemNumber(2002).quantity(16).unitPrice(94).build(),
                Order.builder().orderNumber(1002).itemNumber(2005).quantity(9).unitPrice(44.1).build(),
                Order.builder().orderNumber(1002).itemNumber(2006).quantity(19).unitPrice(90).build());
    }
}
