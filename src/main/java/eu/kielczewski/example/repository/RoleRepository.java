package eu.kielczewski.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import eu.kielczewski.example.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findOneByName(String name);
}
