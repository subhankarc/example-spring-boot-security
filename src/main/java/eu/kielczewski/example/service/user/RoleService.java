package eu.kielczewski.example.service.user;

import java.util.Collection;
import java.util.Optional;

import eu.kielczewski.example.domain.Role;

public interface RoleService {

    Optional<Role> getRoleById(long id);

    Optional<Role> getRoleByName(String name);

    Collection<Role> getAllRoles();

    Role create(String name);

}
