package com.abas.orderapi.entity;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private int orderNumber;
    private int itemNumber;
    private int quantity;
    private double unitPrice;
}
