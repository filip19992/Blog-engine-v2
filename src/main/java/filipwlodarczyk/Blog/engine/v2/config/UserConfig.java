package filipwlodarczyk.Blog.engine.v2.config;

import filipwlodarczyk.Blog.engine.v2.role.Role;
import filipwlodarczyk.Blog.engine.v2.role.RoleService;
import filipwlodarczyk.Blog.engine.v2.user.User;
import filipwlodarczyk.Blog.engine.v2.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.*;


@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository, RoleService roleService, BCryptPasswordEncoder encoder) {


        return args ->
        {
            User FilipAdmin = new User("Filip", encoder.encoder().encode("password"),
                    "filipwlodarczyk99@gmail.com", "01/01/2009", true, true,
                    true, true, Collections.singletonList(roleService.findByName("ROLE_ADMIN")));
            userRepository.save(FilipAdmin);


            User MaciekUser = new User("Maciek", encoder.encoder().encode("password"),
                    "maciek99@gmail.com", "01/01/2009", true, true,
                    true, true, Collections.singletonList(roleService.findByName("ROLE_USER")));
            userRepository.saveAll(Arrays.asList(FilipAdmin, MaciekUser));
        };
    }
}
