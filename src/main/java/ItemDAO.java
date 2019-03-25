import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ItemDAO {

    private SessionFactory sessionFactory;

    Item save(Item item) {
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

    Item update(Item item){
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

        }   finally {
                if (session != null) {
                    session.close();
                }
            }
        sessionFactory.close();
        return item;
    }

    void delete(long id){
        Session session;
        try {
            session = createSessionFactory().openSession();
            Item item = new Item();
            item.setId(id);
            session.delete(item);
        } catch (HibernateException e) {
            System.err.println("Delete is failed");
            System.err.println(e.getMessage());
        }
        sessionFactory.close();
    }

    Item findById(long id) throws Exception{
        Item item = new Item();
        Session session = null;
        try {
            session = createSessionFactory().openSession();
            item = session.get(Item.class, id);
        } catch (HibernateException e) {
            System.err.println("Can`t find by id " + id);
            System.err.println(e.getMessage());
        } finally {
            session.close();
        }
        sessionFactory.close();
        return item;
    }

    List<Item> getAllItem(){
        Session session = null;
        List<Item> items = null;
        try{session = createSessionFactory().openSession();
            items = session.createQuery("FROM Item").list();
        }catch (HibernateException e) {
            System.err.println("Cant get all Item");
            System.err.println(e.getMessage());
        } finally {
            session.close();
        }
        return items;
    }

    private SessionFactory createSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }

}
