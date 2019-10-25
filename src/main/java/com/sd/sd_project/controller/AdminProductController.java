package com.sd.sd_project.controller;


import com.sd.sd_project.model.Product;
import com.sd.sd_project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/product")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class AdminProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/all")
    public List<Product> getAll(){
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") int id){
        return productService.getProductById(id);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Product insertProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable("id") int id) {
        productService.deleteProductById(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Product updateProduct(@RequestBody Product product) {
        return productService.update(product);
    }
}
