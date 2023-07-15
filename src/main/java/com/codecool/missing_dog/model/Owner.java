package com.codecool.missing_dog.model;

import java.util.*;

public class Owner {
    private final Set<Dog> dogSet = new HashSet<>();
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNo;

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Set<Dog> getDogSet() {
        return dogSet;
    }

    public void addDogToList(Dog dog) {
        this.dogSet.add(dog);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return Objects.equals(dogSet, owner.dogSet) && Objects
                .equals(id, owner.id) && Objects.equals(firstName, owner.firstName) && Objects
                .equals(lastName, owner.lastName) && Objects.equals(email, owner.email) && Objects
                .equals(phoneNo, owner.phoneNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dogSet, id, firstName, lastName, email, phoneNo);
    }
}
