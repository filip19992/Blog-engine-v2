package filipwlodarczyk.Blog.engine.v2.post;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public List<Post> findAllPosts() {
        return postService.findAll();
    }

    @PutMapping
    public void writePost(@RequestBody PostModel post) {
        postService.writePost(new Post(post.getContent(), post.getUser_id()));
    }
}
