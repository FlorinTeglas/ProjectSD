package com.sd.sd_project.service;

import com.sd.sd_project.model.Comment;
import com.sd.sd_project.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    public List<Comment> getAll(){
        return commentRepository.findAll();
    }


    public void deleteCommentById(int id){
        commentRepository.deleteById(id);
    }

    public void save(Comment comment){ commentRepository.save(comment);}

    public List<Comment> getCommentByProductId(int id) {
        List<Comment> comments = this.getAll();
        List<Comment> newComments = new ArrayList<Comment>();

        for(Comment comment: comments)
            if(comment.getProduct().getId() == id)
                newComments.add(comment);
            return newComments;
    }

}
