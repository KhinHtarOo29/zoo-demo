package com.example.zoodemo.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Supplier implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String supplier_name;
    private String contactNumber;
    private String address;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "supplier",orphanRemoval = true)
    private List<FoodItem> foodItemList = new ArrayList<>();

    public Supplier() {
    }

    public void addFoodItem(FoodItem foodItem){
        this.foodItemList.add(foodItem);
        foodItem.setSupplier(this);
    }

    public Supplier(String supplier_name, String contactNumber, String address) {
        this.supplier_name = supplier_name;
        this.contactNumber = contactNumber;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSupplier_name() {
        return supplier_name;
    }

    public void setSupplier_name(String supplier_name) {
        this.supplier_name = supplier_name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<FoodItem> getFoodItemList() {
        return foodItemList;
    }

    public void setFoodItemList(List<FoodItem> foodItemList) {
        this.foodItemList = foodItemList;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", supplier_name='" + supplier_name + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
