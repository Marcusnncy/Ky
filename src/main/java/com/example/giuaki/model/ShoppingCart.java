
package com.example.giuaki.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "ShoppingCart")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cart_id;

    @Column(nullable = false)
    private int user_id;

    @Column(name = "created_at", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp created_at;

    // Constructors
    public ShoppingCart() {
    }

    public ShoppingCart(int user_id) {
        this.user_id = user_id;
    }

    // Getters and Setters
    public int getCartId() {
        return cart_id;
    }

    public void setCartId(int cart_id) {
        this.cart_id = cart_id;
    }

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    public Timestamp getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(Timestamp created_at) {
        this.created_at = created_at;
    }
}
