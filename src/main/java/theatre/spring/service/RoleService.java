package theatre.spring.service;

import theatre.spring.model.Role;

public interface RoleService {
    Role getRoleByName(String roleName);

    Role add(Role role);
}
