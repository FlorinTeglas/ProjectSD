package com.sd.sd_project.service;

import com.sd.sd_project.model.Product;
import com.sd.sd_project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;


    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public Product getProductById(int id) {
        return productRepository.findById(id);
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public void deleteProductById(int id){
        productRepository.deleteById(id);
    }

    public Product update(Product product){ return productRepository.save(product); }
}
