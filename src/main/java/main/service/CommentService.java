package main.service;

import com.google.i18n.phonenumbers.NumberParseException;
import main.model.Comment;
import main.repository.CommentRepository;
import main.validator.PhoneValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Comment saveComment( Comment comment ) throws NumberParseException {

        if (!PhoneValidator.isValidNumber(comment.getPhone())){
            throw new NumberParseException(NumberParseException.ErrorType.NOT_A_NUMBER, "Invalid Number");
        }
        return commentRepository.save(comment);
    }
}
