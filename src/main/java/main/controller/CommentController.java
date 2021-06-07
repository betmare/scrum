package main.controller;

import main.model.Comment;
import main.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/comment")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @PostMapping(path = "/")
    public Comment postComment(@RequestBody Comment comment) {
        return commentRepository.save(comment);
    }
}