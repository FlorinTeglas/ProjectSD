package com.sd.sd_project.repository;

import com.sd.sd_project.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    Order findById(int id);

}
