package models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "films")
@Inheritance(strategy = InheritanceType.JOINED)

public class Film {

    private int id;
    private String title;
    private String genre;
    private double cost;
    private Studio studio;
    private Director director;
    private List<Actor> actors;


    public Film() { }

    public Film(String title, String genre, double cost, Studio studio, Director director) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.cost= cost;
        this.studio = studio;
        this.director = director;
        this.actors = new ArrayList<Actor>();
    }

//  FILM ID - Getter & Setter:

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }


//    FILM TITLE - Getter & Setter:

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


//    FILM GENRE - Getter & Setter:

    @Column(name = "genre")
    public String getGenre() {return genre;}

    public void setGenre(String genre) {this.genre = genre;}


//  FILM COST - Getter & Setter:

    @Column(name = "cost")
    public double getCost() {return cost;}

    public double setCost(double cost) { return this.cost = cost;}



//  MANY-TO-ONE (Films get Director):

    @ManyToOne
    @JoinColumn(name="director_id", nullable = false)
    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }


//  MANY-TO-ONE (Films get Studio):

    @ManyToOne
    @JoinColumn(name = "studio_id", nullable = false)
    public Studio getStudio() { return studio;}

    public void setStudio(Studio studio) { this.studio = studio;}


//   MANY-TO-MANY (Films get Actors):

    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToMany
    @JoinTable(name = "film",
            joinColumns = {@JoinColumn(name = "film", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "actor", nullable = false, updatable = false)})
    public List<Actor> getActors() {
        return (List<Actor>) actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public void setFilms(List<Actor> actors) {
        this.actors = actors;
    }

    public void addActor(Actor actor){
        this.actors.add(actor);
    }
    }

