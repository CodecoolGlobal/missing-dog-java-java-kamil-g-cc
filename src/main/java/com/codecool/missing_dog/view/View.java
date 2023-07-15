package com.codecool.missing_dog.view;

import com.codecool.missing_dog.model.Dog;
import com.codecool.missing_dog.model.Owner;

import java.util.Arrays;
import java.util.List;

public class View {
    private final List<String> options = Arrays.asList("1. Show all dogs", "2. Show all owners",
            "3. Find dog by id", "4. Find owner by id", "5. Find owner by email",
            "6. Find dogs by breed", "7. Get dogs by sociability",
            "8. Find phone number to owner of dog of given id",
            "9. Find owner's email by dog id", "10. Show dogs of owner by their id",
            "11. Find owner's full name by their dog's id", "12. Count dogs for owner of dog with id",
            "13. Show other dogs of same breed as dog with id",
            "0. Exit");

    public void displayMainMenu() {
        for (String command : options) {
            System.out.println(command);
        }
    }

    public void welcome() {
        String welcome = "Welcome to dog registry!";
        String instruct = "Choose a number to browse: ";
        System.out.println(welcome);
        System.out.println(instruct);
    }

    public void printDog(Dog dog) {
        System.out.println(toFormattedString(dog));
    }

    public String returnDogPrint(Dog dog) {
        return toFormattedString(dog);
    }

    public String returnOwnerPrint(Owner owner) {
        return toFormattedString(owner);
    }

    public void printOwner(Owner owner) {
        System.out.println(toFormattedString(owner));
    }

    public void printOwners(List<Owner> list) {
        if (list.size() == 0) {
            noDataFound();
        }
        for (Owner object : list) {
            printOwner(object);
        }
    }

    public void printDogs(List<Dog> list) {
        if (list.size() == 0) {
            noDataFound();
        }
        for (Dog object : list) {
            printDog(object);
        }
    }

    public void noDataFound() {
        System.out.println("No data found");
    }

    public String returnNoDataFoundPrint() {
        return "No data found";
    }

    public void printData(String data) {
        System.out.println(data);
    }

    public void printData(int data) {
        System.out.println(data);
    }

    private String toFormattedString(Owner owner) {
        String idFormat = fixedLengthString(String.valueOf(owner.getId()), 6);
        String firstNameFormat = fixedLengthString(owner.getFirstName(), 15);
        String lastNameFormat = fixedLengthString(owner.getLastName(), 15);
        String emailFormat = fixedLengthString(owner.getEmail(), 45);
        String phoneNoFormat = fixedLengthString(owner.getPhoneNo(), 15);
        return "" + idFormat +
                ", " + firstNameFormat +
                ", " + lastNameFormat +
                ", " + emailFormat +
                ", " + phoneNoFormat;
    }

    private String toFormattedString(Dog dog) {
        String sexString = dog.getMale() ? "MALE" : "FEMALE";
        String sociableString = dog.getSociable() ? "SOCIABLE" : "UNSOCIABLE";
        String idFormat = fixedLengthString(String.valueOf(dog.getId()), 6);
        String nameFormat = fixedLengthString(dog.getName(), 15);
        String dateOfBirthFormat = fixedLengthString(dog.getDateOfBirth().toString(), 15);
        String sexFormat = fixedLengthString(sexString, 10);
        String sociableFormat = fixedLengthString(sociableString, 15);
        String breedFormat = fixedLengthString(dog.getBreed(), 26);
        return idFormat + "." +
                nameFormat +
                dateOfBirthFormat +
                sexFormat +
                breedFormat +
                sociableFormat;
    }

    private String fixedLengthString(String string, int length) {
        return String.format("%1$" + length + "s", string);
    }
}
