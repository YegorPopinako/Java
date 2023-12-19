package org.example;

import java.util.ArrayList;
import java.util.List;

public class ECommerceService {
    private final Cart cart;
    private Order order;

    public ECommerceService(Cart cart) {
        this.cart = cart;
    }

    public boolean addToCart(Product product) {
        return cart.getProducts().add(product);
    }

    public boolean removeFromCart(int productId) {
        return cart.getProducts().removeIf(product -> product.getId() == productId);
    }

    public Order placeOrder() {
        order = new Order(new ArrayList<>(cart.getProducts()));
        cart.getProducts().clear();
        return order;
    }

    public void cancelOrder() {
        if (order != null) {
            order.setStatus(Order.Status.CANCELED);
        }
    }

    public void completeOrder() {
        if (order != null) {
            order.setStatus(Order.Status.COMPLETED);
        }
    }
}
