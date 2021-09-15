package filipwlodarczyk.Blog.engine.v2.post;

import filipwlodarczyk.Blog.engine.v2.user.User;
import lombok.Getter;

@Getter
public class PostModel {
    private String content;
    private User user_id;
}
