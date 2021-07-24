package com.example.zoodemo.services;

import com.example.zoodemo.entities.*;
import com.example.zoodemo.repositories.AnimalRepository;
import com.example.zoodemo.repositories.CageRepository;
import com.example.zoodemo.repositories.CategoryRepository;
import com.example.zoodemo.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ZooService {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private CageRepository cageRepository;

    @Autowired
    SupplierRepository supplierRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Transactional
    public void saveData() {
        Cage cage1 = new Cage("01", "East");
        Cage cage2 = new Cage("02", "SouthEast");
        Cage cage3 = new Cage("03", "South");
        Cage cage4 = new Cage("04", "West");
        Cage cage5 = new Cage("05", "North");

        Animal animal1 = new Animal("Tiger", 1);
        Animal animal2 = new Animal("seahorses", 10);
        Animal animal3 = new Animal("crocodiles", 5);
        Animal animal4 = new Animal("penguins", 4);
        Animal animal5 = new Animal("rabbits", 20);

        Supplier supplier1 = new Supplier("Lisa", "55-123-132", "Thailand");
        Supplier supplier2 = new Supplier("Rose", "21-432-99","Australia");
        Supplier supplier3 = new Supplier("Jennie", "43-987-987","Korea");

        FoodItem foodItem1 = new FoodItem("Meat", 5);
        FoodItem foodItem2 = new FoodItem("Mysis Shrimp", 5);
        FoodItem foodItem3 = new FoodItem("Fish", 5);
        FoodItem foodItem4 = new FoodItem("Krill", 5);
        FoodItem foodItem5 = new FoodItem("Carrots", 5);

        Category category1 = new Category("Mammals");
        Category category2 = new Category("Birds");
        Category category3 = new Category("Fish");
        Category category4 = new Category("Reptiles");

        cage1.setAnimal(animal1);
        cage2.setAnimal(animal2);
        cage3.setAnimal(animal3);
        cage4.setAnimal(animal4);
        cage5.setAnimal(animal5);

        cageRepository.save(cage1);
        cageRepository.save(cage2);
        cageRepository.save(cage3);
        cageRepository.save(cage4);
        cageRepository.save(cage5);

        supplier1.addFoodItem(foodItem3);
        supplier1.addFoodItem(foodItem4);
        supplier2.addFoodItem(foodItem1);
        supplier3.addFoodItem(foodItem2);
        supplier3.addFoodItem(foodItem5);

        supplierRepository.save(supplier1);
        supplierRepository.save(supplier2);
        supplierRepository.save(supplier3);

        category1.addAnimal(animal1);
        category1.addAnimal(animal5);
        category2.addAnimal(animal4);
        category3.addAnimal(animal2);
        category4.addAnimal(animal3);

        categoryRepository.save(category1);
        categoryRepository.save(category2);
        categoryRepository.save(category3);
        categoryRepository.save(category4);

        animal1.addFoodItem(foodItem1);
        animal1.addFoodItem(foodItem3);
        animal2.addFoodItem(foodItem2);
        animal2.addFoodItem(foodItem4);
        animal3.addFoodItem(foodItem3);
        animal4.addFoodItem(foodItem3);
        animal4.addFoodItem(foodItem4);
        animal5.addFoodItem(foodItem5);

        animalRepository.save(animal1);
        animalRepository.save(animal2);
        animalRepository.save(animal3);
        animalRepository.save(animal4);
        animalRepository.save(animal5);



    }

}
