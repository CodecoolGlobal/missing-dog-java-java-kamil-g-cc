package com.codecool.missing_dog.data;

import com.codecool.missing_dog.model.Dog;
import com.codecool.missing_dog.model.Owner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class FixedData {
    private List<Dog> dogList;
    private List<Owner> ownerList;
    private Dog dog1;
    private Dog dog2;
    private Dog dog3;
    private Dog dog4;
    private Owner owner1;
    private Owner owner2;
    private Owner owner3;

    public FixedData() {
        setUpData();
    }

    private void setUpData() {
        owner1 = createOwner1();
        owner2 = createOwner2();
        owner3 = createOwner3();

        dog1 = createDog1();
        dog2 = createDog2();
        dog3 = createDog3();
        dog4 = createDog4();

        dog1.setOwner(owner1);
        dog4.setOwner(owner1);
        dog3.setOwner(owner1);

        owner1.addDogToList(dog3);
        owner1.addDogToList(dog1);
        owner1.addDogToList(dog4);

        dog2.setOwner(owner2);
        owner2.addDogToList(dog2);

        dogList = Arrays.asList(dog1, dog2, dog3, dog4);
        ownerList = Arrays.asList(owner1, owner2, owner3);
    }

    private Dog createDog4() {
        Dog dog4 = new Dog();
        dog4.setId(47);
        dog4.setName("BAKA");
        dog4.setDateOfBirth(LocalDate.of(2018, 9, 18));
        dog4.setBreed("POLISH GREYHOUND");
        dog4.setMale(false);
        dog4.setSociable(false);
        return dog4;
    }

    private Dog createDog3() {
        Dog dog3 = new Dog();
        dog3.setId(32);
        dog3.setName("GRUCHA");
        dog3.setDateOfBirth(LocalDate.of(2015, 2, 12));
        dog3.setBreed("POINTER");
        dog3.setMale(false);
        dog3.setSociable(false);
        return dog3;
    }

    private Dog createDog2() {
        Dog dog2 = new Dog();
        dog2.setId(21);
        dog2.setName("KULKA");
        dog2.setDateOfBirth(LocalDate.of(2017, 10, 3));
        dog2.setBreed("IRISH SETTER");
        dog2.setMale(false);
        dog2.setSociable(true);
        return dog2;
    }

    private Dog createDog1() {
        Dog dog1 = new Dog();
        dog1.setId(11);
        dog1.setName("ARAKI");
        dog1.setDateOfBirth(LocalDate.of(2019, 5, 2));
        dog1.setBreed("POLISH GREYHOUND");
        dog1.setMale(true);
        dog1.setSociable(false);
        return dog1;
    }

    private Owner createOwner3() {
        Owner owner3 = new Owner();
        owner3.setId(52);
        owner3.setFirstName("ZBYCHU");
        owner3.setLastName("OBUCH");
        owner3.setEmail("OBUCHEM@GMAIL.COM");
        owner3.setPhoneNo("+48601313934");
        return owner3;
    }

    private Owner createOwner2() {
        Owner owner2 = new Owner();
        owner2.setId(41);
        owner2.setFirstName("KRYSTYNA");
        owner2.setLastName("POCIECHA");
        owner2.setEmail("KRYS_POCIESZNA@GMAIL.COM");
        owner2.setPhoneNo("+48601313934");
        return owner2;
    }

    private Owner createOwner1() {
        Owner owner1 = new Owner();
        owner1.setId(13);
        owner1.setFirstName("PABLO");
        owner1.setLastName("WATA");
        owner1.setEmail("P.VAT@GMAIL.COM");
        owner1.setPhoneNo("+48507912042");
        return owner1;
    }

    public List<Dog> getDogList() {
        return dogList;
    }

    public List<Owner> getOwnerList() {
        return ownerList;
    }

    public Dog getDog1() {
        return dog1;
    }

    public Dog getDog2() {
        return dog2;
    }

    public Dog getDog3() {
        return dog3;
    }

    public Dog getDog4() {
        return dog4;
    }

    public Owner getOwner1() {
        return owner1;
    }

    public Owner getOwner2() {
        return owner2;
    }

    public Owner getOwner3() {
        return owner3;
    }
}
