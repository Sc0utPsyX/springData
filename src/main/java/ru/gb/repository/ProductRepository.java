package ru.gb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.gb.model.Product;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findById(Long id);

    List<Product> findAll();

    void deleteById(Long id);

    @Query("select p from Product p where p.cost between ?1 and ?2")
    List<Product> findAllByCostBetween(Double min, Double max);
}
