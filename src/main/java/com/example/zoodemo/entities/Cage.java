package com.example.zoodemo.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Cage implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cage_no;
    private String location;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ANIMAL_ID")
    private Animal animal;

    public Cage() {
    }

    public Cage(String cage_no, String location) {
        this.cage_no = cage_no;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCage_no() {
        return cage_no;
    }

    public void setCage_no(String cage_no) {
        this.cage_no = cage_no;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    @Override
    public String toString() {
        return "Cage{" +
                "id=" + id +
                ", cage_no='" + cage_no + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
