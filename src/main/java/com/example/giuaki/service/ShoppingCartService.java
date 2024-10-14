package com.example.giuaki.service;

import com.example.giuaki.model.ShoppingCart;
import com.example.giuaki.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartService {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    public List<ShoppingCart> findAll() {
        return shoppingCartRepository.findAll();
    }

    public ShoppingCart findById(int id) {
        return shoppingCartRepository.findById(id).orElseThrow(() -> new RuntimeException("ShoppingCart not found"));
    }

    public ShoppingCart save(ShoppingCart cart) {
        return shoppingCartRepository.save(cart);
    }

    public ShoppingCart update(ShoppingCart cart) {
        return shoppingCartRepository.save(cart);
    }

    public void delete(int id) {
        shoppingCartRepository.deleteById(id);
    }
}
