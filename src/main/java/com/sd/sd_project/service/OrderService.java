package com.sd.sd_project.service;

import com.sd.sd_project.model.Order;
import com.sd.sd_project.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService{

    @Autowired
    OrderRepository orderRepository;

    public List<Order> getAll(){
        return orderRepository.findAll();
    }

    public List<Order> getOrdersByUserId(int user_id) {
        List<Order> orders = this.getAll();
        List<Order> newOrders = new ArrayList<Order>();
        for(Order order: orders)
            if(order.getUser().getId() == user_id)
                newOrders.add(order);
            return newOrders;
    }

    public Order getOrderById(int id) {
        return orderRepository.findById(id);
    }

    public Order save(Order order){
        return orderRepository.save(order);
    }

    public void deleteOrderById(int id){
        orderRepository.deleteById(id);
    }

    public Order update(Order order, int id){
        Order forUpdateOrder = getOrderById(id);

        forUpdateOrder.setPrice(order.getPrice());

        return orderRepository.save(forUpdateOrder);


    }

}
