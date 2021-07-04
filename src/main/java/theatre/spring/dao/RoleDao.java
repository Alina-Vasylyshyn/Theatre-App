package theatre.spring.dao;

import java.util.Optional;
import theatre.spring.model.Role;

public interface RoleDao {
    Optional<Role> getRoleByName(String roleName);

    Role add(Role role);
}
