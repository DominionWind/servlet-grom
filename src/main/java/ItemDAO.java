import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ItemDAO {

    private SessionFactory sessionFactory;

    public Item save(Item item) {
        Session session = null;
        Transaction tr = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            session.save(item);
            tr.commit();
        } catch (HibernateException e) {
            System.err.println("Save is failed");
            System.err.println(e.getMessage());

            if (tr != null) {
                tr.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        sessionFactory.close();
        System.out.println("Done");
        return item;
    }

    public Item update(Item item){
        Session session = null;
        Transaction tr = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            session.update(item);
            tr.commit();
        } catch (HibernateException e) {
            System.err.println("Update is failed");
            System.err.println(e.getMessage());

            if (tr != null) {
                tr.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        sessionFactory.close();
        return item;
    }

    public void delete(long id){
        Session session = null;
        Transaction tr = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            Item item = new Item();
            item.setId(id);
            session.delete(item);
            tr.commit();
        } catch (HibernateException e) {
            System.err.println("Delete is failed");
            System.err.println(e.getMessage());

            if (tr != null) {
                tr.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        sessionFactory.close();
    }

    public Item findById(long id) throws Exception{
        try (Session session = createSessionFactory().openSession()) {
            return session.get(Item.class, id);
        } catch (HibernateException e) {
            System.err.println("Can`t find by id " + id);
            System.err.println(e.getMessage());
        }
        sessionFactory.close();
        return null;
    }

    public List<Item> getAllItem(){
        try{Session session = createSessionFactory().openSession();
            return (List<Item>) session.createQuery("FROM Item").list();
        }catch (HibernateException e) {
            System.err.println("Cant get all Item");
            System.err.println(e.getMessage());
        }
        return null;
    }

    public SessionFactory createSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }

}
