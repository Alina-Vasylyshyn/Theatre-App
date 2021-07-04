package theatre.spring.dao.impl;

import theatre.spring.dao.AbstractDao;
import theatre.spring.dao.TheatreStageDao;
import theatre.spring.model.TheatreStage;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class TheatreStageDaoImpl extends AbstractDao<TheatreStage> implements TheatreStageDao {
    public TheatreStageDaoImpl(SessionFactory factory) {
        super(factory, TheatreStage.class);
    }
}
