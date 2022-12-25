package ru.gb.service;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.gb.model.Product;
import ru.gb.repository.ProductRepository;


@Component
public class ProductDataGenerator {
    @Autowired
    private ProductRepository productRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void generateDataOnStartup() {
        Faker faker = new Faker();

        for (int i = 0; i < 10; i++) {
            Product product = new Product();
            product.setTitle(faker.food().fruit());
            product.setCost(faker.number().randomDouble(2, 10L, 150L));
            productRepository.save(product);
        }
    }
}
