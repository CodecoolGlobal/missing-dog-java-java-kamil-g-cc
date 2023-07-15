package com.codecool.missing_dog.model;

import java.time.LocalDate;
import java.util.Objects;

public class Dog {
    private Integer id;
    private String name;
    private LocalDate dateOfBirth;
    private Boolean isMale;
    private String breed;
    private Boolean isSociable;
    private Owner owner;

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Boolean getMale() {
        return isMale;
    }

    public void setMale(Boolean male) {
        isMale = male;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Boolean getSociable() {
        return isSociable;
    }

    public void setSociable(Boolean sociable) {
        isSociable = sociable;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Objects.equals(id, dog.id) && Objects.equals(name, dog.name) && Objects
                .equals(dateOfBirth, dog.dateOfBirth) && Objects.equals(isMale, dog.isMale) && Objects
                .equals(breed, dog.breed) && Objects.equals(isSociable, dog.isSociable) && Objects
                .equals(owner, dog.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, dateOfBirth, isMale, breed, isSociable, owner);
    }
}
