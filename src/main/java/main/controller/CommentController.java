package main.controller;

import main.dto.CommentResponse;
import main.model.Comment;
import main.service.CommentService;
import main.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping(path = "/")
    @ResponseBody
    public ResponseEntity<Object> postComment(@RequestBody Comment comment) {
        CommentResponse commentResponse;
        commentResponse = commentService.saveComment(comment);

        return ResponseUtil.buildResponse(commentResponse.getComment(), commentResponse.getStatusCode(), commentResponse.getError());
    }
}
