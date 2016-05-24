package eu.kielczewski.example.service.user;

import java.util.Collection;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import eu.kielczewski.example.domain.Role;
import eu.kielczewski.example.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoleServiceImpl.class);
    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository RoleRepository) {
        this.roleRepository = RoleRepository;
    }

    @Override
    public Optional<Role> getRoleById(long id) {
        LOGGER.debug("Getting Role={}", id);
        return Optional.ofNullable(roleRepository.findOne(id));
    }

    @Override
    public Optional<Role> getRoleByName(String name) {
        LOGGER.debug("Getting Role by email={}", name.replaceFirst("@.*", "@***"));
        return roleRepository.findOneByName(name);
    }

    @Override
    public Collection<Role> getAllRoles() {
        LOGGER.debug("Getting all Roles");
        return roleRepository.findAll(new Sort("name"));
    }

    @Override
    public Role create(String name) {
        Role role = new Role();
        role.setName(name);
        return roleRepository.save(role);
    }

}
