import db.DBHelper;
import models.Actor;
import models.Director;
import models.Film;
import org.hibernate.id.IdentifierGeneratorHelper;

import java.util.List;

public class Runner {

    public static void main(String[] args) {


//  DIRECTORS:


        Director director1 = new Director("John McTiernan", 50000000.00);
        DBHelper.save(director1);

        Director director2 = new Director("Tony Scott", 100000000.00);
        DBHelper.save(director2);

        Director director3 = new Director("Robert Zemeckis", 200000000.00);
        DBHelper.save(director3);

        Director director4 = new Director("Ken Kwapis", 75000000.00);
        DBHelper.save(director4);

        Director director5 = new Director("Garry Marshall", 75000000.00);
        DBHelper.save(director5);

        Director director6 = new Director("Quentin Tarantino", 50000000.00);
        DBHelper.save(director6);



//  ACTORS:


        Actor actor1 = new Actor("Bruce", "Willis", 10000000.00, true);
        DBHelper.save(actor1);

        Actor actor2 = new Actor("Tom", "Cruise", 15000000.00, true);
        DBHelper.save(actor2);

        Actor actor3 = new Actor("Tom", "Hanks",9000000.00, false);
        DBHelper.save(actor3);

        Actor actor4 = new Actor("Scarlett", "Johansson", 7000000.00, true);
        DBHelper.save(actor4);

        Actor actor5 = new Actor("Julia", "Roberts", 5000000.00, true);
        DBHelper.save(actor5);

        Actor actor6 = new Actor("Uma", "Thurman", 1000000.00, false);
        DBHelper.save(actor6);



//  FILMS:

        Film film1 = new Film("Die Hard", "Action", 28000000.00, "20th Century Fox");
        DBHelper.save(film1);

        Film film2 = new Film("Top Gun", "Action", 15000000.00, "Paramount");
        DBHelper.save(film2);

        Film film3 = new Film("Forest Gump", "Comedy", 55000000.00, "Paramount");
        DBHelper.save(film3);

        Film film4 = new Film("He's Just Not That Into You", "Rom-com", 40000000.00, "New Line Cinema");
        DBHelper.save(film4);

        Film film5 = new Film("Pretty Woman", "Rom-com", 14000000.00, "Buena Vista Pictures");
        DBHelper.save(film5);

        Film film6 = new Film("Kill Bill", "Action", 30000000.00, "Miramax");
        DBHelper.save(film6);


//  METHODS:

        List<Actor> actors = DBHelper.getAll(Actor.class);

    }


}
