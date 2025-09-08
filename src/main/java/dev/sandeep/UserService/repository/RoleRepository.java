package dev.sandeep.UserService.repository;

import dev.sandeep.UserService.model.Role;
import dev.sandeep.UserService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
