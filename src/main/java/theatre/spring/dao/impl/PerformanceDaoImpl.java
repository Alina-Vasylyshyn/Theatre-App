package theatre.spring.dao.impl;

import theatre.spring.dao.AbstractDao;
import theatre.spring.dao.PerformanceDao;
import theatre.spring.model.Performance;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class PerformanceDaoImpl extends AbstractDao<Performance> implements PerformanceDao {
    public PerformanceDaoImpl(SessionFactory factory) {
        super(factory, Performance.class);
    }
}
