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
        PhoneValidator.isValidNumber(comment.getPhone());

        return commentRepository.save(comment);
    }
}
