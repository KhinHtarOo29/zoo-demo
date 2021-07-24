package com.example.zoodemo.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categoryType;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "category",orphanRemoval = true)
    private List<Animal> animalList = new ArrayList<>();

    public void addAnimal(Animal animal){
        this.animalList.add(animal);
        animal.setCategory(this);
    }

    public Category() {
    }

    public Category(String categoryType) {
        this.categoryType = categoryType;
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", categoryType='" + categoryType + '\'' +
                '}';
    }
}
