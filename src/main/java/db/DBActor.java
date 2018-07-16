package db;

import models.Actor;
import models.Film;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBActor {


    private static Session session;
    private static Transaction transaction;

//    To sort by Actor.performanceFee:

    public static List<Actor> orderByPerfortmancerFee(){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Actor> actorss = null;
        try {
            Criteria cr = session.createCriteria(Actor.class);
            cr.addOrder(Order.desc("age"));
            actorss = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return actorss;
    }

//    To add Actor to a Film:

    public static void addActorToFilm(Actor actor1, Film film1){
        actor1.addFilm(film1);
        film1.addActor(actor1);
        DBHelper.update(actor1);
    }

//    To return which Films an Actor is in:

    public static List<Film> getActorFilms(Actor actor){
        List<Film> results = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria cr = session.createCriteria(Film.class);
            cr.createAlias("actors", "actor");
            cr.add(Restrictions.eq("actor.id", actor.getId()));
            results = cr.list();
        } catch (HibernateException ex){
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;

    }

}
