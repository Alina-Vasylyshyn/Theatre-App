package theatre.spring.service.impl;

import org.springframework.stereotype.Service;
import theatre.spring.dao.RoleDao;
import theatre.spring.exception.DataProcessingException;
import theatre.spring.model.Role;
import theatre.spring.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Role getRoleByName(String roleName) {
        return roleDao.getRoleByName(roleName).orElseThrow(
                () -> new DataProcessingException("Role with name " + roleName + " not found"));
    }

    @Override
    public Role add(Role role) {
        return roleDao.add(role);
    }
}
