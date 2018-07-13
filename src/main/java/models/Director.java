package models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "directors")
@Inheritance(strategy = InheritanceType.JOINED)

public class Director {

    private int id;
    private String name;
    private double filmBudget;
    private List<Film> films;
    private Studio studio;

    public Director() {
    }

    public Director(String name, double filmBudget) {
        this.id = id;
        this.name = name;
        this.filmBudget = filmBudget;
        this.films = new ArrayList<Film>();
        this.studio = studio;
    }

//    DIRECTOR ID - Getter & Setter:

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


//    DIRECTOR NAME - Getter & Setter:

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


//  DIRECTOR FILM-BUDGET - Getter & Setter:

    @Column(name = "film_budget")
    public double getFilmBudget() {
        return filmBudget;
    }

    public double setFilmBudget(double filmBudget) {
        return this.filmBudget = filmBudget;
    }


//  ONE-TO-MANY (Director gets Films):

    @OneToMany(mappedBy = "director", fetch = FetchType.LAZY)
    public List<Film> getFilm() {
        return films;
    }

    public void setFilm(List<Film> film) {
        this.films = film;
    }


//   MANY-TO-ONE (Director gets Studio)

    @ManyToOne
    @JoinColumn(name="studio_id", nullable=false)
    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }





}







