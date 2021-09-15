package filipwlodarczyk.Blog.engine.v2.utils;

import filipwlodarczyk.Blog.engine.v2.privilege.Privilege;
import filipwlodarczyk.Blog.engine.v2.privilege.PrivilegeRepository;
import filipwlodarczyk.Blog.engine.v2.privilege.PrivilegeService;
import filipwlodarczyk.Blog.engine.v2.role.Role;
import filipwlodarczyk.Blog.engine.v2.role.RoleRepository;
import filipwlodarczyk.Blog.engine.v2.role.RoleService;
import filipwlodarczyk.Blog.engine.v2.user.UserRepository;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;


@Component
public class SetupDataLoader  implements ApplicationListener<ContextRefreshedEvent> {


    boolean alreadySetup = false;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PrivilegeService privilegeService;


//    @Autowired
//    private PasswordEncoder passwordEncoder;


    @SneakyThrows
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (alreadySetup) {
            return;
        }

        Privilege readPrivilege = privilegeService.createPrivilegeIfNotFound("READ_PRIVILEGE");
        Privilege writePrivilege = privilegeService.createPrivilegeIfNotFound("WRITE_PRIVILEGE");

        List<Privilege> adminPrivileges = Arrays.asList(readPrivilege, writePrivilege);
        List<Privilege> userPrivileges = Arrays.asList(readPrivilege);

        roleService.createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
        roleService.createRoleIfNotFound("ROLE_USER", userPrivileges);

    }
}
