package db;

import models.Actor;
import models.Director;
import models.Studio;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBStudio {

    private static Session session;

    public static List<Actor> getActorsForStudio(Studio studio) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Actor> results = null;
        try {
            Criteria cr = session.createCriteria(Actor.class);
            cr.add(Restrictions.eq("studio", studio));
            results = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }


    public static Director getDirector(Studio studio){
        session = HibernateUtil.getSessionFactory().openSession();
        Director director = null;

        try {
            Criteria cr = session.createCriteria(Director.class);
            cr.add(Restrictions.eq("studio", studio));
            director = (Director) cr.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return director ;
    }

//  Returns Films for Studio
    public static List<Studio> getFilmsByStudio(Studio studio1) {
        List<Studio> results = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria cr = session.createCriteria(Actor.class);
            cr.createAlias("studios", "studio");
            cr.add(Restrictions.eq("studio.id", studio1.getId()));
            results = cr.list();
        } catch (HibernateException ex){
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;

    }
//
//    //    To add Film to a Studio:
//
//    public static void addStudioToFilm(Film film, Studio studio){
//        Film.addStudio(studio);
//        studio.addFilm(film);
//        DBHelper.update(film);
//    }
}

