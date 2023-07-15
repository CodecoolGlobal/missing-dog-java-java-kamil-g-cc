package com.codecool.missing_dog.repository;

import com.codecool.missing_dog.data.FixedData;
import com.codecool.missing_dog.model.Owner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OwnerRepositoryTest {
    private static final FixedData fixedData = new FixedData();
    private static OwnerRepository ownerRepository;

    @BeforeAll
    static void setUp() {
        ownerRepository = new OwnerRepository(fixedData.getOwnerList());
    }

    @Test
    void getById_ShouldReturnOwner_WhenOwnerExists() {
        Owner expectedOwner = fixedData.getOwner1();
        Optional<Owner> optionalActualOwner = ownerRepository.getById(13);
        assertTrue(optionalActualOwner.isPresent());
        assertEquals(expectedOwner, optionalActualOwner.get());
    }

    @Test
    void getById_ShouldReturnEmptyOptional_WhenOwnerDoesNotExist() {
        Optional<Owner> optionalActualOwner = ownerRepository.getById(999);
        assertTrue(optionalActualOwner.isEmpty());
    }

    @Test
    void getByEmail_ShouldReturnOwner_WhenOwnerExists() {
        Owner expectedOwner = fixedData.getOwner2();
        Optional<Owner> optionalActualOwner = ownerRepository.getByEmail("KRYS_POCIESZNA@GMAIL.COM");
        assertTrue(optionalActualOwner.isPresent());
        assertEquals(expectedOwner, optionalActualOwner.get());
    }

    @Test
    void getByEmail_ShouldReturnEmptyOptional_WhenOwnerDoesNotExist() {
        Optional<Owner> optionalActualOwner = ownerRepository.getByEmail("non-existent@email");
        assertTrue(optionalActualOwner.isEmpty());
    }
}
