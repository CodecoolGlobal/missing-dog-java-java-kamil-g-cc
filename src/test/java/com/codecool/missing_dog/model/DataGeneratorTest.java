package com.codecool.missing_dog.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class DataGeneratorTest {

    static List<Dog> setUpDogs() {
        Data data = new DataGenerator().createData();
        return data.getDogList();
    }

    @ParameterizedTest
    @MethodSource("setUpDogs")
    public void createData_ShouldReturnListOfDogsEachHavingOwner(Dog dog) {
        assertNotNull(dog.getOwner());
    }
}
