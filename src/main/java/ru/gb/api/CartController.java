package ru.gb.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.gb.model.Cart;
import ru.gb.service.CartService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/carts")
public class CartController {

    @Autowired
    private CartService cartService;


    @GetMapping("/{id}")
    public String getCartById(@PathVariable Long id) {
        return cartService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)).toString();
    }

    @GetMapping
    public List<String> getAll() {
        return cartService.getAll().stream()
                .map((Cart::toString)).toList();
    }

    @GetMapping("/customer/{id}")
    public List<String> getCartByCustomerId(@PathVariable Long id) {
        return cartService.getByCustomerId(id).stream()
                .map((Cart::toString)).toList();
    }

    @PostMapping
    public String createCart(@RequestParam Long customerId){
        return cartService.createCart(customerId).toString();
    }

    @PutMapping
    String updateCart(@RequestParam Long cartId,
                      @RequestParam Long productId){
        return cartService.update(cartId, productId).toString();
    }

    @DeleteMapping("/{id}")
    public int deleteById(@PathVariable Long id){
        cartService.deleteById(id);
        return HttpStatus.OK.value();
    }

    @DeleteMapping("/product")
    public int deleteByProductId(@RequestParam Long cartId, @RequestParam Long productId){
        cartService.deleteProduct(cartService.findById(cartId).orElseThrow(), productId);
        return HttpStatus.OK.value();
    }



}
