package com.codecool.missing_dog.repository;

import com.codecool.missing_dog.model.Owner;

import java.util.List;
import java.util.Optional;

public class OwnerRepository {
    private final List<Owner> data;

    public OwnerRepository(List<Owner> data) {
        this.data = data;
    }

    /**
     * Return Owner if found one with given id,
     * otherwise return Optional.empty()
     *
     * @param id owner's id
     * @return optional of Owner
     */
    public Optional<Owner> getById(int id) {
        return data.stream().filter(owner -> owner.getId() == id).findFirst();
    }

    /**
     * @return list of all owners
     */
    public List<Owner> getAll() {
        return data;
    }

    /**
     * Return Owner with given email if found,
     * otherwise return Optional.empty()
     *
     * @param value email to search by
     * @return optional of Owner
     */
    public Optional<Owner> getByEmail(String value) {
        return data.stream().filter(owner -> owner.getEmail().equals(value)).findFirst();
    }
}
