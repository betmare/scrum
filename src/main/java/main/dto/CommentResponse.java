package main.dto;

import lombok.Builder;
import lombok.Data;
import main.model.Comment;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class CommentResponse {
    private Comment comment;
    private String error;
    private HttpStatus statusCode;
}
