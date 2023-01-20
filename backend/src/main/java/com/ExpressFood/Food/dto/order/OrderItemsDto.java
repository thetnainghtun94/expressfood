package com.ExpressFood.Food.dto.order;

import javax.validation.constraints.NotNull;

public class OrderItemsDto {

    private @NotNull double price;
    private @NotNull int quantity;
    private @NotNull int orderId;
    private @NotNull int menuId;

    public OrderItemsDto () {}

    public OrderItemsDto(@NotNull double price, @NotNull int quantity, @NotNull int orderId, @NotNull int menuId) {
        this.price = price;
        this.quantity = quantity;
        this.orderId = orderId;
        this.menuId = menuId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return menuId;
    }

    public void setProductId(int productId) {
        this.menuId = productId;
    }
}
