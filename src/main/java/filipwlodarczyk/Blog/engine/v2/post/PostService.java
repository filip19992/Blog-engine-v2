package filipwlodarczyk.Blog.engine.v2.post;

import filipwlodarczyk.Blog.engine.v2.user.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public void writePost(Post post) {
        postRepository.save(post);
    }
}
