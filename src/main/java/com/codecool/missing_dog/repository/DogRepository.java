package com.codecool.missing_dog.repository;

import com.codecool.missing_dog.model.Dog;

import java.util.List;
import java.util.Optional;

public class DogRepository {
    private final List<Dog> data;

    public DogRepository(List<Dog> data) {
        this.data = data;
    }

    /**
     * Return Dog if found one with given id,
     * otherwise return Optional.empty()
     *
     * @param id dog's id
     * @return optional of Dog
     */
    public Optional<Dog> getById(int id) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * @return list of all dogs
     */
    public List<Dog> getAll() {
        return data;
    }

    /**
     * Return owner's phone number for the dog of given id,
     * if dog is not found return Optional.empty()
     *
     * @param id dog's id
     * @return owner's phone number
     */
    public Optional<String> getOwnerPhoneNoByDogId(int id) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Return owner's email for the dog of given id,
     * if dog is not found return Optional.empty()
     *
     * @param id dog's id
     * @return owner's email
     */
    public Optional<String> getOwnerEmailByDogId(int id) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Return owner's full name for the dog of given id,
     * if dog is not found return Optional.empty()
     * * @param id
     *
     * @return optional of owner's phone number
     */
    public Optional<String> getOwnerFullNameByDogId(int id) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Return all dogs of given breed.
     * List can be emtpy
     *
     * @param breed value to look by
     * @return list of dogs of given breed
     */
    public List<Dog> getDogsByBreed(String breed) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Return all dogs by their sociability.
     * Pass "true" to find sociable dogs,
     * pass any other value to find unsociable ones.
     * Lists can be empty
     *
     * @param value value to look by
     * @return list of dogs of given sociability
     */
    public List<Dog> getDogsBySociability(Boolean value) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Return all dogs owned by Owner of given id, list can be empty
     *
     * @param id owner's id
     * @return list of dogs owned by specific owner
     */
    public List<Dog> getDogsByOwnerId(int id) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * First find owner of dog with given id.
     * Then return count of dogs the owner has.
     *
     * @param id dog's id
     * @return number of dogs the owner has
     */
    public int getOwnerDogCountByDogId(int id) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Find dog with given id,
     * then find all dogs that have the same breed
     *
     * @param id dog's id
     * @return list of dogs of the same breed as the dog of given id
     */
    public List<Dog> getOtherDogsOfSameBreedAsDogWithId(int id) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
