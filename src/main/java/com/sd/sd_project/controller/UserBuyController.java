package com.sd.sd_project.controller;

import com.sd.sd_project.model.Order;
import com.sd.sd_project.model.Product;
import com.sd.sd_project.model.User;
import com.sd.sd_project.service.OrderService;
import com.sd.sd_project.service.ProductService;
import com.sd.sd_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/products")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class UserBuyController {

    @Autowired
    OrderService orderService;
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;

    @RequestMapping(value = {"/addInCart"}, method = RequestMethod.POST)
    public Order addOrderInCart(@RequestParam String user_id, @RequestParam String product_id){
        User user = userService.getUserById(Integer.parseInt(user_id));
        Product product = productService.getProductById(Integer.parseInt(product_id));

        int totalPrice = 1 * product.getPrice();

        Order order = new Order();
        order.setPrice(totalPrice);
        order.setProduct(product);
        order.setUser(user);
        order.setBought(false);
        Order o = orderService.save(order);

        product.setNrTotal(product.getNrTotal()-1);
        product.setNrBought(product.getNrBought()+1);
        productService.save(product);

        return o;

    }

    @RequestMapping(value = {"/removeProductFromCart"}, method = RequestMethod.DELETE)
    public void removeOrderFromCart(@RequestParam int order_id){
        Order order = orderService.getOrderById(order_id);
        if(order.getBought() == false)
            orderService.deleteOrderById(order_id);
    }

    @RequestMapping(value = {"/buy/{user_id}"}, method = RequestMethod.GET)
    public User buy(@PathVariable("user_id") int user_id){
        User u = null;

        int totalPrice = 0;
        List<Order> orders = orderService.getAll();
        for(Order order: orders) {
            if (order.getUser().getId() == user_id && order.getBought() == false)
                totalPrice += order.getPrice();
        }

        User user = userService.getUserById(user_id);
        if(user.getWalletAmount()>= totalPrice) {
            user.setWalletAmount(user.getWalletAmount()-totalPrice);
             u = userService.save(user);
            for(Order order: orders) {
                if (order.getUser().getId() == user_id && order.getBought() == false) {
                    order.setBought(true);
                    orderService.save(order);
                }
            }
        }
        return  u;
    }


}
