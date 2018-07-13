package models;

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
    private String studio;
    private List<Actor> actors;


    public Film() {
    }

    public Film(String title, String genre, double cost, String studio) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.cost= cost;
        this.studio = studio;
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


//    FILM STUDIO - Getters & Setter:

    @Column(name = "studio")
    public String getStudio() {return studio;}

    public void setStudio(String studio) {this.studio = studio;}


//   ONE-TO-MANY (Film gets Actors):

    @OneToMany(mappedBy = "film", fetch = FetchType.LAZY)
    public List<Actor> getActor() {
        return actors;
    }

    public void setActor(List<Actor> actor) {
        this.actors = actor;
    }
    }

