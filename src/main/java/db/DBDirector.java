package db;

import models.Actor;
import models.Director;
import models.Film;
import models.Studio;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DBDirector {


    private static Session session;
    private static Transaction transaction;


    //    To add Actor to a Film:

    public static void addDirectorToStudio(Director director, Studio studio){
        Director.addStudio(studio);
        studio.addDirector(director);
        DBHelper.update(director);
    }
}
