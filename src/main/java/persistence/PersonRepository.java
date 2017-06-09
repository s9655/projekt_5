package persistence;

import java.util.List;
import model.Person;
import org.hibernate.Session;

/**
 * Created with IntelliJ IDEA.
 * @author Yegor Bugayenko (yegor@tpc2.com)
 * @version $Id$
 * @since 1.0
 */
@SuppressWarnings("unchecked")
public class PersonRepository {

    Session session = HibernateUtil.getSessionFactory().openSession();

    public String add(final Person person) {
        session.beginTransaction();
        final String saved = String.valueOf((Long) session.save(person));
        session.getTransaction().commit();
        return saved;
    }

    public List<Person> findAll() {
        session.beginTransaction();
        final List<Person> persons = (List<Person>) session.createQuery("from Person").list();
        session.getTransaction().commit();
        return persons;
    }

    public Person remove(Long id) {
        session.beginTransaction();
        final Person found = (Person) session.get(Person.class, id);
        session.delete(found);
        session.getTransaction().commit();
        return found;
    }

    public Person update(final Person person) {
        session.beginTransaction();
        session.update(person);
        return person;
    }
}
