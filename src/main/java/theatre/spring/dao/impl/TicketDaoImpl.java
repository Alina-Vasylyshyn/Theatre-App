package theatre.spring.dao.impl;

import theatre.spring.dao.AbstractDao;
import theatre.spring.dao.TicketDao;
import theatre.spring.model.Ticket;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class TicketDaoImpl extends AbstractDao<Ticket> implements TicketDao {
    public TicketDaoImpl(SessionFactory factory) {
        super(factory, Ticket.class);
    }
}
