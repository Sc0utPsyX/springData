package ru.gb.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.gb.model.Product;
import ru.gb.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Product> getAll(@RequestParam(defaultValue = "0d") Double minCost, @RequestParam(defaultValue = "150d") Double maxCost) {
        return productService.getAll(minCost, maxCost);
    }

    @PostMapping
    public Product add(@RequestParam String title, @RequestParam Double cost){
        return productService.save(title, cost);
    }
    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        productService.deleteById(id);
    }



}
