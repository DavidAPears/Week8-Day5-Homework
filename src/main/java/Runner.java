import db.DBHelper;
import models.Actor;
import models.Film;
import org.hibernate.id.IdentifierGeneratorHelper;

public class Runner {

    public static void main(String[] args) {



//   ACTORS:


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



//   FILMS:

        Film film1 = new Film("Die Hard", "Action", 28000000.00, "20th Century Fox");
        DBHelper.save(film1);

        Film film2 = new Film("Top Gun", "Action", 15000000.00, "Paramount");
        DBHelper.save(film2);

        Film film3 = new Film("Forest Gump", "Comedy", 55000000.00, "Paramount");
        DBHelper.save(film3);

        Film film4 = new Film("He's Just Not That Into You", "Rom-com", 40000000.00, "New Line Cinema");
        DBHelper.save(film4);

        Film film5 = new Film("Kill Bill", "Action", 30000000.00, "Miramax");
        DBHelper.save(film5);

    }
}
