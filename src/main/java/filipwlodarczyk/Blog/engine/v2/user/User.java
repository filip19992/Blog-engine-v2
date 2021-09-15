package filipwlodarczyk.Blog.engine.v2.user;

import filipwlodarczyk.Blog.engine.v2.role.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {


    @Id
    @SequenceGenerator(name = "userId_generator", sequenceName = "userId_generator", allocationSize = 1)
    @GeneratedValue(generator = "userId_generator" ,strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    private String username;
    private String password;
    private String email;
    private String dateOfBirth;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
    private boolean isEnabled;
    @Column
    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

    public User(String username,
                String password,
                String email,
                String dateOfBirth,
                boolean isAccountNonExpired,
                boolean isAccountNonLocked,
                boolean isCredentialsNonExpired,
                boolean isEnabled,
                Collection<Role> roles) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.isEnabled = isEnabled;
        this.roles = roles;
    }
}
