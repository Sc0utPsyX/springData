package ru.gb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.gb.model.Cart;
import ru.gb.model.CartProduct;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {

    Optional<Cart> findById(Long id);

    List<Cart> findAll();

    void deleteById(Long id);

    @Query("select c from Cart c where c.customer.id = ?1")
    List<Cart> findAllByCustomerId(Long id);

    CartProduct save(CartProduct cartProduct);

}
