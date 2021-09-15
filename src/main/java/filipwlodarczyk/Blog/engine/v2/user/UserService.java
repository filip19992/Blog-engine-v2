package filipwlodarczyk.Blog.engine.v2.user;

import filipwlodarczyk.Blog.engine.v2.role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    @Autowired
    private final UserRepository userRepository;
    private Role role;


    public UserService(UserRepository userRepo) {
        this.userRepository = userRepo;
    }


    public void saveUser(User user) {
        userRepository.save(user);
    }

    public List<User> findAll() {
       return userRepository.findAll();
    }
}
