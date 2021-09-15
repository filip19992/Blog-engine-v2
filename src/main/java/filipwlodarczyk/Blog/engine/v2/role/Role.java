package filipwlodarczyk.Blog.engine.v2.role;

import filipwlodarczyk.Blog.engine.v2.privilege.Privilege;
import filipwlodarczyk.Blog.engine.v2.user.User;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Setter
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;

    @ManyToMany
    @JoinTable(
            name = "roles_privileges",
            joinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "privilege_id", referencedColumnName = "id"))
    private Collection<Privilege> privileges;

    public Collection<Privilege> getPrivileges() {
        return privileges;
    }

    public Role(String name) {
        this.name = name;
    }

    public Role(String name, Collection<User> users, Collection<Privilege> privileges) {
        this.name = name;
        this.users = users;
        this.privileges = privileges;
    }
}

