package com.example.giuaki.controller;

import com.example.giuaki.model.ShoppingCart;
import com.example.giuaki.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    // GET ALL ShoppingCarts
    @GetMapping("/carts")
    @ResponseBody
    public List<ShoppingCart> getAllCarts() {
        return shoppingCartService.findAll();
    }

    // GET ShoppingCart by ID
    @GetMapping("/carts/{id}")
    public ResponseEntity<ShoppingCart> getCartById(@PathVariable("id") int cartId) {
        ShoppingCart cart = shoppingCartService.findById(cartId);
        if (cart != null) {
            return ResponseEntity.status(200).body(cart);
        }
        return ResponseEntity.status(404).body(null);
    }

    // CREATE NEW ShoppingCart
    @PostMapping("/cart")
    public ResponseEntity<ShoppingCart> createCart(@RequestBody ShoppingCart cart) {
        shoppingCartService.save(cart);
        return ResponseEntity.status(201).body(cart);
    }

    // UPDATE ShoppingCart
    @PutMapping("/carts/{id}")
    public ResponseEntity<ShoppingCart> updateCart(@PathVariable("id") int cartId, @RequestBody ShoppingCart updateCart) {
        ShoppingCart cart = shoppingCartService.findById(cartId);
        if (cart != null) {
            cart.setUserId(updateCart.getUserId());
            shoppingCartService.save(cart);
            return ResponseEntity.status(200).body(cart);
        }
        return ResponseEntity.status(404).body(null);
    }

    // DELETE ShoppingCart by ID
    @DeleteMapping("/carts/{id}")
    @ResponseBody
    public List<ShoppingCart> deleteCartById(@PathVariable("id") int cartId) {
        shoppingCartService.delete(cartId);
        return shoppingCartService.findAll();
    }
}
