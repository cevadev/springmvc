package com.ceva.config.root;

import com.ceva.data.Person;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementacion del DataRepository para Hibernate
 */
@Transactional // incluimos en el sistema de transacciones de hibernate
public class HibernateRepository implements DataRepository {
    private SessionFactory sessionFactory;

    public HibernateRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.save(person);
    }

    @Override
    public List<Person> list() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from com.ceva.data.Person order by id_person").list();
    }

    @Override
    public void delete(int id_person) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from com.ceva.data.Person where id_person=:id_person")
                .setParameter("id_person", id_person)
                .executeUpdate();
    }
}

