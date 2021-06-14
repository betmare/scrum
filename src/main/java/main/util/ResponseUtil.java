package main.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {

    public static ResponseEntity<Object> buildResponse(final Object body, final HttpStatus httpStatus, final String error) {

        switch (httpStatus) {
            case OK:
                return ResponseEntity.ok(body);
            case BAD_REQUEST:
                return ResponseEntity.badRequest().body(error);
            default:
                break;
        }
        return null;
    }
}
