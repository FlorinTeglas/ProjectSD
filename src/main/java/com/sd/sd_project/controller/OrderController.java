package com.sd.sd_project.controller;

import com.sd.sd_project.model.Order;
import com.sd.sd_project.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/order")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class OrderController {

    @Autowired
    OrderService orderService;


    @GetMapping("/all")
    public List<Order> getAll(){
        return orderService.getAll();
    }

    //@GetMapping("/{id}")
    //public Order getOrderById(@PathVariable("id") int id){
      //  return orderService.getOrderById(id);
    //}

    @GetMapping("/{id}")
    public List<Order> getOrderByUserId(@PathVariable("id") int id){
        return orderService.getOrdersByUserId(id);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Order insertOrder(@RequestBody Order order) {
        return orderService.save(order);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteOrder(@PathVariable("id") int id) {
        orderService.deleteOrderById(id);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public Order updateOrder(@RequestBody Order order, @PathVariable("id") int id) {
        return orderService.update(order, id);
    }


}
