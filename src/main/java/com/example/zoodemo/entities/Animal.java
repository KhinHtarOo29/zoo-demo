package com.example.zoodemo.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Animal implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int total_no;
    private String type;

    @OneToOne(mappedBy = "animal")
    private Cage cage;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.PERSIST})
    @JoinTable(name = "ANIMAL_FOOD_ITEM",
            joinColumns = @JoinColumn(name = "ANIMAL_ID"),
            inverseJoinColumns = @JoinColumn(name = "FOOD_ITEM_ID")
    )
    private Set<FoodItem> foodItems = new HashSet<>();

    public void addFoodItem(FoodItem foodItem){
        this.foodItems.add(foodItem);
        foodItem.getAnimals().add(this);
    }

    public Animal() {
    }

    public Animal(String type, int total_no) {
        this.type = type;
        this.total_no = total_no;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<FoodItem> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(Set<FoodItem> foodItems) {
        this.foodItems = foodItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTotal_no() {
        return total_no;
    }

    public void setTotal_no(int total_no) {
        this.total_no = total_no;
    }

    public Cage getCage() {
        return cage;
    }

    public void setCage(Cage cage) {
        this.cage = cage;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", total_no=" + total_no +
                '}';
    }
}
