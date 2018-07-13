package models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "studios")
@Inheritance(strategy = InheritanceType.JOINED)

public class Studio {

    private int id;
    private String name;
    private double overallBudget;
    private List<Director> directors;
    private List<Film> films;
    private List<Actor> actors;

    public Studio() {
    }

    public Studio(String name, double overallBudget) {
        this.id = id;
        this.name = name;
        this.overallBudget = overallBudget;
        this.directors = new ArrayList<Director>();
        this.films = new ArrayList<Film>();
        this.actors = new ArrayList<Actor>();
    }

//  STUDIO ID - Getter & Setters:

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }


//  STUDIO NAME - Getter & Setter:

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


//    STUDIO OVERALL-BUDGET - Getter & Setter:

    @Column(name = "overall_budget")
    public double getOverallBudget() {return overallBudget;}

    public double setOverallBudget(double overallBudget) { return this.overallBudget = overallBudget;}




//   ONE-TO-MANY (Studio gets Directors):

    @OneToMany(mappedBy = "studio", fetch = FetchType.LAZY)
    public List<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Director> director) {
        this.directors = director;
    }


//    ONE-TO-MANY ((Studio gets Films):

    @OneToMany(mappedBy = "studio", fetch = FetchType.LAZY)
    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> film) {
        this.films = film;
    }


//  ONE-TO-MANY (Studio gets Actors)

    @OneToMany(mappedBy = "studio", fetch = FetchType.LAZY)
    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actor) { this.actors = actor; }






}
