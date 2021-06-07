package Main.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/comment")
public class CommentController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String main() {
        return "New Sms";
    }
}
