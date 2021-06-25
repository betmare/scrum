package main.service;

import com.google.i18n.phonenumbers.NumberParseException;
import main.dto.CommentResponse;
import main.model.Comment;
import main.repository.CommentRepository;
import main.validator.EmailValidator;
import main.validator.PhoneValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public CommentResponse saveComment(Comment comment ) {

        CommentResponse commentResponse = validatePhoneNumber(comment.getPhone());
        if (commentResponse.getError() == null ) {
            commentResponse = validateEmail(comment.getEmail());
        }
        if (commentResponse.getError() != null ) {
            return commentResponse;
        } else {
            commentResponse.setComment(commentRepository.save(comment));
            commentResponse.setStatusCode(HttpStatus.OK);
        }
        return commentResponse;
    }

    private CommentResponse validatePhoneNumber( final String phoneNumber) {
        CommentResponse commentResponse = CommentResponse.builder().build();
        try {
            if (!PhoneValidator.isValidNumber(phoneNumber) ){
                commentResponse.setStatusCode(HttpStatus.BAD_REQUEST);
                commentResponse.setError("Invalid Number");
            }
        } catch (NumberParseException e) {
            commentResponse.setStatusCode(HttpStatus.BAD_REQUEST);
            commentResponse.setError(e.getMessage());
        }
        return commentResponse;
    }

    private CommentResponse validateEmail( final String email ) {
        CommentResponse commentResponse = CommentResponse.builder().build();

        if (!EmailValidator.isValidEmail(email) ){
            commentResponse.setStatusCode(HttpStatus.BAD_REQUEST);
            commentResponse.setError("Invalid Email");
        }

        return commentResponse;
    }

}
