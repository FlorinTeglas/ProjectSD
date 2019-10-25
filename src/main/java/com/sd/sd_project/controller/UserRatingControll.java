package com.sd.sd_project.controller;

import com.sd.sd_project.model.Comment;
import com.sd.sd_project.model.Product;
import com.sd.sd_project.model.User;
import com.sd.sd_project.service.CommentService;
import com.sd.sd_project.service.ProductService;
import com.sd.sd_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class UserRatingControll {

    @Autowired
    ProductService productService;
    @Autowired
    CommentService commentService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/rate", method = RequestMethod.POST)
    public void rateProduct(@RequestParam String product_id, @RequestParam String stars){
        Product product = productService.getProductById(Integer.parseInt(product_id));

        double rating = product.getRating();
        int nrRaters = product.getNrRaters();
        double newRating = (rating + Integer.parseInt(stars))/(nrRaters + 1.0);
        DecimalFormat df = new DecimalFormat("#.##");
        double nnewRating = Double.valueOf(df.format(newRating));
        System.out.println("\nrating " + nnewRating +"\n");
        product.setRating(nnewRating);
        product.setNrRaters(nrRaters + 1);
        productService.save(product);
    }


    //user comment controll


    @RequestMapping(value = "/comm", method = RequestMethod.POST)
    public Comment addComment(@RequestParam String user_id, @RequestParam String product_id, @RequestParam String comm) {
        User user = userService.getUserById(Integer.parseInt(user_id));
        Product product = productService.getProductById(Integer.parseInt(product_id));

        Comment comment = new Comment();
        comment.setComment(comm);
        comment.setProduct(product);
        comment.setUser(user);

        commentService.save(comment);
        return comment;

    }

    @RequestMapping(value = "/comm/delete/{id}", method = RequestMethod.DELETE)
    public void deleteComment(@PathVariable("id") int id) {
        commentService.deleteCommentById(id);
    }

    @GetMapping("/comm/all")
    public List<Comment> getAll(){
        return commentService.getAll();
    }

    @GetMapping("/comm/{id}")
    public List<Comment> getCommentByProductId(@PathVariable("id") int id){
        return commentService.getCommentByProductId(id);
    }



}
