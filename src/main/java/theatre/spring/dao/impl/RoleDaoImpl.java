package theatre.spring.dao.impl;

import java.util.Optional;
import theatre.spring.dao.AbstractDao;
import theatre.spring.dao.RoleDao;
import theatre.spring.exception.DataProcessingException;
import theatre.spring.model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl extends AbstractDao<Role> implements RoleDao {

    public RoleDaoImpl(SessionFactory factory) {
        super(factory, Role.class);
    }

    @Override
    public Optional<Role> getRoleByName(String roleName) {
        try (Session session = factory.openSession()) {
            Query<Role> roleNameQuery = session
                    .createQuery("FROM Role r WHERE r.roleName = :rolename",
                    Role.class);
            roleNameQuery.setParameter("rolename", Role.RoleName.valueOf(roleName));
            return roleNameQuery.uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException("Role with name " + roleName + " not found");
        }
    }
}
