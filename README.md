# Order Management API

This project provides a basic order management API. It calculates the total amount of orders, average prices, and allows you to add new orders.

## Contents

- [API Endpoints](#api-endpoints)
  - [Total Amount](#total-amount)
  - [Average Price](#average-price)
  - [Average Prices by Item](#average-prices-by-item)
  - [Item Order Counts](#item-order-counts)
  - [Add New Order](#add-new-order)
 
  - #### Total Amount

Returns the average unit price of all orders.

- **Endpoint:** `GET /order/total-amount`
- **Response:**
    ```json
    {
      "totalAmount": 69621.418
    }
    ```

#### Average Price

Returns the average unit price of all orders.

- **Endpoint:** `GET /order/average-price`
- **Response:**
    ```json
    {
      "averagePrice": 135.18721941747575
    }
    ```

#### Average Prices by Item

Returns the weighted average prices for each item.

- **Endpoint:** `GET /order/average-prices-by-item`
- **Response:**
    ```json
    {
    "2000": 100.51,
    "2001": 85.03132773109243,
    "2002": 96.63450867052023,
    "2003": 203.35294117647058,
    "2004": 220.46136363636364,
    "2005": 44.1,
    "2006": 90.0
    }
    ```

#### Item Order Counts

Returns the number of orders for each item in which it appears.

- **Endpoint:** `GET /order/item-order-counts`
- **Response:**
    ```json
    {
      "2000": {
        "1000": 12
      },
      "2001": {
        "1000": 31,
        "1001": 88
      },
      "2002": {
        "1000": 22,
        "1001": 135,
        "1002": 16
      },
      "2003": {
        "1000": 41,
        "1002": 10
      },
      "2004": {
        "1000": 55,
        "1001": 74,
        "1002": 3
      },
      "2005": {
        "1002": 9
      },
      "2006": {
        "1002": 19
      }
    }
    ```

#### Add New Order

Adds a new order.

- **Endpoint:** `POST /order/add`
- **Request:**
    ```json
    {
      "orderNumber": 1003,
      "itemNumber": 2007,
      "quantity": 10,
      "unitPrice": 99.99
    }
    ```
- **Response:**
    ```json
    {
      "orderNumber": 1003,
      "itemNumber": 2007,
      "quantity": 10,
      "unitPrice": 99.99
    }
    ```
