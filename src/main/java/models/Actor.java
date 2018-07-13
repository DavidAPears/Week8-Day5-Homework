package models;


import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "actors")
@Inheritance(strategy = InheritanceType.JOINED)

public class Actor {

    private int id;
    private String firstName;
    private String lastName;
    private double performanceFee;
    private boolean guildMember;
    private List<Film> film;


    public Actor() {
    }


    public Actor(String firstName, String lastName, double performanceFee, boolean guildMember) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.performanceFee = performanceFee;
        this.guildMember = guildMember;
        this.film = new ArrayList<Film>();
    }

//  ACTOR ID - Getter & Setter:

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//  ACTOR FIRST NAME - Getter & Setter:

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirsName(String firstName) {
        this.firstName = firstName;
    }



//  ACTOR LAST NAME - Getter & Setter:

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



//  ACTOR PERFORMANCE FEE - Getter & Setter:

    @Column(name = "performance_fee")
    public double getPerformanceFee() {return performanceFee;}

    public double setPerformanceFee(double performanceFee) { return this.performanceFee = performanceFee; }



//  ACTOR GUILD MEMBER - Getters & Setters:

    @Column(name = "guild_member")
    private boolean getGuildMember() { return guildMember;}

    public boolean setGuildMember(boolean guildMember) {return this.guildMember = guildMember; }



//  ONE-TO-MANY (Actor gets Films):

//    @ManyToMany (mappedBy = "actor", fetch = FetchType.LAZY)
//    public List<Film> getFilm() {
//        return film;
//    }
//
//    public void setFilm(List<Film> film) {
//        this.film = film;
//    }


//  MANY-TO-MANY (Actors get Films)

    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToMany
    @JoinTable(name = "actor_film",
            joinColumns = {@JoinColumn(name = "actor_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "film_id", nullable = false, updatable = false)})
    public List<Film> getFilms() {
        return film;
    }

    public void setFilms(List<Film> films) { this.film = films;}

    public void addFilm(Film film){
        this.film.add(film);
    }

}

