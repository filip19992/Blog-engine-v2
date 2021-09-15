package filipwlodarczyk.Blog.engine.v2.role;

import filipwlodarczyk.Blog.engine.v2.privilege.Privilege;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Transactional
    public Role createRoleIfNotFound(String name, Collection<Privilege> privileges) {
        {

            Role role = roleRepository.findByName(name);
            if (role == null) {
                role = new Role(name);
                role.setPrivileges(privileges);
                roleRepository.save(role);
            }
            return role;
        }
    }

    public Role findByName(String name) {
       return roleRepository.findByName(name);
    }
}