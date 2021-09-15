package filipwlodarczyk.Blog.engine.v2.post;

import filipwlodarczyk.Blog.engine.v2.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user_id;

    public Post(String content, User user_id) {
        this.content = content;
        this.user_id = user_id;
    }
}
