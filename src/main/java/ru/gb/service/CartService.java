package ru.gb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.model.Cart;
import ru.gb.model.CartProduct;
import ru.gb.model.Product;
import ru.gb.repository.CustomerRepository;
import ru.gb.repository.CartRepository;
import ru.gb.repository.ProductRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;

    public Optional<Cart> findById(Long id) {
        return cartRepository.findById(id);
    }

    public List<Cart> getAll() {
        return cartRepository.findAll();
    }

    public void deleteById(Long id){
        cartRepository.deleteById(id);
    }

    public Cart createCart(Long customerId){
        Cart newOrder = new Cart();
        newOrder.setCustomer(customerRepository.findById(customerId).orElseThrow());
        return cartRepository.save(newOrder);
    }

    public Cart update(Long orderId, Long productId){
            Cart changedCart = cartRepository.findById(orderId).orElseThrow();
            Product product = productRepository.findById(productId).orElseThrow();
            AtomicBoolean counted = new AtomicBoolean(false);
            changedCart.getProductList().stream().filter(o -> {
                if (o.getProduct().equals(product)){
                    o.setCount(o.getCount() + 1);
                    counted.set(true);
                }
                return true;
            }).toList();
            if (!counted.get()){
                CartProduct cp = new CartProduct(productRepository.findById(productId).orElseThrow(), 1);
                cartRepository.save(cp);
                changedCart.getProductList().add(cp);
            }
            return cartRepository.save(changedCart);
    }

    public Cart deleteProduct(Cart cart, Long productId){
        if (Objects.isNull(cart.getId())){
            return cart;
        } else {
            Cart changedCart = cartRepository.findById(cart.getId()).orElseThrow();
            Product product = productRepository.findById(productId).orElseThrow();
            AtomicInteger counted = new AtomicInteger(1);
            changedCart.getProductList().stream().filter(o -> {
                if (o.getProduct().equals(product)){
                    o.setCount(o.getCount() - 1);
                    if (o.getCount() < 1) {
                        counted.set(o.getCount());
                    }
                }
                return true;
            }).toList();
            if (counted.get() <= 0){
                changedCart.getProductList().remove(counted.get());
            }
            return cartRepository.save(changedCart);
        }
    }

    public List<Cart> getByCustomerId(Long id) {
        return cartRepository.findAllByCustomerId(id);
    }
}
