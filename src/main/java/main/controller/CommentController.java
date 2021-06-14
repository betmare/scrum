package main.controller;

import com.google.i18n.phonenumbers.NumberParseException;
import main.model.Comment;
import main.service.CommentService;
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
        Comment commentResponse;
        try {
            commentResponse = commentService.saveComment(comment);
        } catch (NumberParseException e) {
            return ResponseEntity.badRequest().body("Phone: "+e.getErrorType()+" "+e.getMessage());
        }
        return ResponseEntity.accepted().body(commentResponse);
    }
}
