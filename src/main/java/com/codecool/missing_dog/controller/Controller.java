package com.codecool.missing_dog.controller;

import com.codecool.missing_dog.input.Input;
import com.codecool.missing_dog.model.Dog;
import com.codecool.missing_dog.model.Owner;
import com.codecool.missing_dog.repository.DogRepository;
import com.codecool.missing_dog.repository.OwnerRepository;
import com.codecool.missing_dog.view.View;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Controller {
    private final DogRepository dogRepository;
    private final OwnerRepository ownerRepository;
    private final View view;
    private final Input input;
    private final Map<Integer, Runnable> commands;
    private Boolean isRunning;

    public Controller(DogRepository dogRepository, OwnerRepository ownerRepository,
                      View view, Input input) {
        this.ownerRepository = ownerRepository;
        this.dogRepository = dogRepository;
        this.view = view;
        this.input = input;
        isRunning = true;
        commands = initializeCommands();
    }

    private Map<Integer, Runnable> initializeCommands() {
        Map<Integer, Runnable> map = new HashMap<>();
        map.put(1, this::showDogs);
        map.put(2, this::showOwners);
        map.put(3, this::showDogById);
        map.put(4, this::showOwnerById);
        map.put(5, this::showOwnerByEmail);
        map.put(6, this::showDogsByBreed);
        map.put(7, this::showDogsBySociability);
        map.put(8, this::showOwnerPhoneNoByDogId);
        map.put(9, this::showOwnerEmailByDogId);
        map.put(10, this::showDogsByOwnerId);
        map.put(11, this::showOwnerFullNameByDogId);
        map.put(12, this::showCountOfDogsForOwnerOfDogWithId);
        map.put(13, this::showOtherDogsOfSameBreedAsDogWithId);
        map.put(0, this::exit);
        return map;
    }

    private void showDogs() {
        view.printDogs(dogRepository.getAll());
    }

    private void showOwners() {
        view.printOwners(ownerRepository.getAll());
    }

    /**
     * Method displaying Dog of id given by user.
     * First use the right Input method to gather input from user.
     * Then call the appropriate DogRepository method to get the Dog.
     * Finally use the Optional method
     * to handle two scenarios:
     * 1) Dog is found: print the Dog using the right display method
     * 2) Dog is not found: use display method to inform about that.
     * The right Optional method choice makes the call a single liner.
     */
    void showDogById() {
        int id = input.getIntInput("Type the dog's id to search by");
        Optional<Dog> optionalDog = dogRepository.getById(id);
        optionalDog.ifPresentOrElse(view::printDog, view::noDataFound);
    }

    /**
     * Method displaying Owner of id given by user.
     * First use the right Input method to gather input from user.
     * Then call the appropriate OwnerRepository method to get the Owner.
     * Finally use the Optional method
     * to handle two scenarios:
     * 1) Owner is found: print the Owner using the right display method
     * 2) Owner is not found: use display method to inform about that.
     * The right Optional method choice makes the call a single liner.
     */
    void showOwnerById() {
        int id = input.getIntInput("Type the owner's id to search by");
        Optional<Owner> optionalOwner = ownerRepository.getById(id);
        optionalOwner.ifPresentOrElse(view::printOwner, view::noDataFound);
    }

    /**
     * Method displaying Owner of email given by user.
     * First use the right Input method to gather input from user.
     * Then call the appropriate OwnerRepository method to get the Owner.
     * Finally use the Optional method
     * to handle two scenarios:
     * 1) Owner is found: print the Owner using the right display method
     * 2) Owner is not found: use display method to inform about that.
     * The right Optional method choice makes the call a single liner.
     */
    void showOwnerByEmail() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    private void showDogsByBreed() {
        String value = input.getInput("Type the value to search by");
        List<Dog> dogList = dogRepository.getDogsByBreed(value);
        view.printDogs(dogList);
    }

    /**
     * Method displaying the phone number of Owner of Dog with id given by user.
     * First use the right Input method to gather input from user.
     * Then call the appropriate DogRepository method to get the phone number.
     * Finally use the Optional method
     * to handle two scenarios:
     * 1) phone number is found: print the Owner using the right display method
     * 2) phone number is not found: use display method to inform about that.
     * The right Optional method choice makes the call a single liner.
     */
    void showOwnerPhoneNoByDogId() {
        int id = input.getIntInput("Type the dog's id to search the owner's phone no");
        Optional<String> optionalPhoneNo = dogRepository.getOwnerPhoneNoByDogId(id);
        optionalPhoneNo.ifPresentOrElse(view::printData, view::noDataFound);
    }

    private void showDogsBySociability() {
        Boolean value = input.gatherBooleanInput("Type the value to search by");
        List<Dog> dogList = dogRepository.getDogsBySociability(value);
        view.printDogs(dogList);
    }

    /**
     * Method displaying the email of Owner of Dog with id given by user.
     * First use the right Input method to gather input from user.
     * Then call the appropriate DogRepository method to get the email.
     * Finally use the Optional method
     * to handle two scenarios:
     * 1) email is found: print the email using the right display method
     * 2) email is not found: use display method to inform about that.
     * The right Optional method choice makes the call a single liner.
     */
    void showOwnerEmailByDogId() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    private void showDogsByOwnerId() {
        int value = input.getIntInput("Type the value to search by");
        List<Dog> dogList = dogRepository.getDogsByOwnerId(value);
        view.printDogs(dogList);
    }

    /**
     * Method displaying the full name of Owner of Dog with id given by user.
     * First use the right Input method to gather input from user.
     * Then call the appropriate DogRepository method to get the name.
     * Finally use the Optional method
     * to handle two scenarios:
     * 1) name is found: print the name using the right display method
     * 2) name is not found: use display method to inform about that.
     * The right Optional method choice makes the call a single liner.
     */
    void showOwnerFullNameByDogId() {
        int id = input.getIntInput("Type the dog's id to search the name of an owner");
        Optional<String> optionalName = dogRepository.getOwnerFullNameByDogId(id);
        optionalName.ifPresentOrElse(view::printData, view::noDataFound);
    }

    private void showCountOfDogsForOwnerOfDogWithId() {
        int value = input.getIntInput("Type the value to search by");
        int count = dogRepository.getOwnerDogCountByDogId(value);
        view.printData(count);
    }

    private void showOtherDogsOfSameBreedAsDogWithId() {
        int value = input.getIntInput("Type the value to search by");
        List<Dog> dogs = dogRepository.getOtherDogsOfSameBreedAsDogWithId(value);
        view.printDogs(dogs);
    }

    private void exit() {
        this.isRunning = false;
    }

    public void run() {
        view.welcome();
        while (isRunning) {
            view.displayMainMenu();
            int option = input.getIntInputInRange(commands.size());
            clearScreen();
            commands.get(option).run();
            input.anyKey("Press any key to continue");
            clearScreen();
        }
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
