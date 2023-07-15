package com.codecool.missing_dog.model;

import java.util.List;

public class Data {
    private final List<Dog> dogList;
    private final List<Owner> ownerList;

    public Data(List<Dog> dogList, List<Owner> ownerList) {
        this.dogList = dogList;
        this.ownerList = ownerList;
    }

    public List<Dog> getDogList() {
        return dogList;
    }

    public List<Owner> getOwnerList() {
        return ownerList;
    }
}
