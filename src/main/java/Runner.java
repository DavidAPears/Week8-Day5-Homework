import db.*;
import models.Actor;
import models.Director;
import models.Film;
import models.Studio;
import org.hibernate.id.IdentifierGeneratorHelper;

import java.util.List;

public class Runner {

    public static void main(String[] args) {


//  STUDIOS:

        Studio studio1 = new Studio("20th Century Fox", 100.00);
        DBHelper.save(studio1);

        Studio studio2 = new Studio("Paramount", 90.00);
        DBHelper.save(studio2);

        Studio studio3 = new Studio("New Line Cinema", 25.00);
        DBHelper.save(studio3);

        Studio studio4 = new Studio("Buena Vista Pictures", 25.00);
        DBHelper.save(studio4);

        Studio studio5 = new Studio("Miramax", 600.00);
        DBHelper.save(studio5);



//  DIRECTORS:


        Director director1 = new Director("John McTiernan", 50.00);
        DBHelper.save(director1);

        Director director2 = new Director("Tony Scott", 100.00);
        DBHelper.save(director2);

        Director director3 = new Director("Robert Zemeckis", 200.00);
        DBHelper.save(director3);

        Director director4 = new Director("Ken Kwapis", 75.00);
        DBHelper.save(director4);

        Director director5 = new Director("Garry Marshall", 75.00);
        DBHelper.save(director5);

        Director director6 = new Director("Quentin Tarantino", 50.00);
        DBHelper.save(director6);



//  ACTORS:


        Actor actor1 = new Actor("Bruce", "Willis", 10.00, true);
        DBHelper.save(actor1);

        Actor actor2 = new Actor("Tom", "Cruise", 15.00, true);
        DBHelper.save(actor2);

        Actor actor3 = new Actor("Tom", "Hanks",9.00, false);
        DBHelper.save(actor3);

        Actor actor4 = new Actor("Scarlett", "Johansson", 7.00, true);
        DBHelper.save(actor4);

        Actor actor5 = new Actor("Julia", "Roberts", 5.00, true);
        DBHelper.save(actor5);

        Actor actor6 = new Actor("Uma", "Thurman", 1.00, false);
        DBHelper.save(actor6);



//  FILMS:

        Film film1 = new Film("Die Hard", "Action", 28.00, studio1, director1);
        DBHelper.save(film1);

        Film film2 = new Film("Top Gun", "Action", 15.00, studio2, director2);
        DBHelper.save(film2);

        Film film3 = new Film("Forest Gump", "Comedy", 55.00, studio2, director3);
        DBHelper.save(film3);

        Film film4 = new Film("He's Just Not That Into You", "Rom-com", 40.00, studio3, director4);
        DBHelper.save(film4);

        Film film5 = new Film("Pretty Woman", "Rom-com", 14.00, studio4, director5);
        DBHelper.save(film5);

        Film film6 = new Film("Kill Bill", "Action", 30.00, studio5, director6);
        DBHelper.save(film6);


//  METHODS:


//      Actor(s) gets added to Film(s):
        DBActor.addActorToFilm(actor1, film1);
        DBActor.addActorToFilm(actor2, film2);
        DBActor.addActorToFilm(actor3, film3);
        DBActor.addActorToFilm(actor4, film4);
        DBActor.addActorToFilm(actor5, film5);
        DBActor.addActorToFilm(actor6, film6);


//      Film(s) gets added to Studio(s):
        DBFilm.addFilmToStudio(film1, studio1);
        DBFilm.addFilmToStudio(film2, studio2);
        DBFilm.addFilmToStudio(film3, studio2);
        DBFilm.addFilmToStudio(film4, studio3);
        DBFilm.addFilmToStudio(film5, studio4);
        DBFilm.addFilmToStudio(film6, studio5);


//      Director gets added to Studio:
        DBDirector.addDirectorToStudio(director1, studio1);


//      Returns Actor for Films:
        List<Actor> filmActor = DBFilm.getFilmActors(film1);


//      Returns Films for Studio:
        List<Studio> films = DBStudio.getFilmsByStudio(studio1);


//      Returns ALL from each Class:

        List<Actor> actorsagain = DBHelper.getAll(Actor.class);

        List<Studio> studios = DBHelper.getAll(Studio.class);

        List<Film> film = DBHelper.getAll(Film.class);

        List<Director> directors = DBHelper.getAll(Director.class);


    }


}
