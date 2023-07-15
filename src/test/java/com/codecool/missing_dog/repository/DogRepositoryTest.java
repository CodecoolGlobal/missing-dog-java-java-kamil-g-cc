package com.codecool.missing_dog.repository;

import com.codecool.missing_dog.data.FixedData;
import com.codecool.missing_dog.model.Dog;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class DogRepositoryTest {
    private static final FixedData fixedData = new FixedData();
    private static DogRepository dogRepository;

    @BeforeAll
    static void setUp() {
        dogRepository = new DogRepository(fixedData.getDogList());
    }

    @Test
    void getById_ShouldReturnDog_WhenExists() {
        Dog expected = fixedData.getDog4();
        Optional<Dog> actual = dogRepository.getById(47);
        assertTrue(actual.isPresent());
        assertEquals(expected, dogRepository.getById(47).orElse(null));
    }

    @Test
    void getById_ShouldReturnEmptyOptional_WhenDogDoesNotExist() {
        Optional<Dog> actual = dogRepository.getById(999);
        assertTrue(actual.isEmpty());
    }

    @Test
    void getOwnerPhoneNoByDogId_ShouldReturnPhoneNo_WhenDogExists() {
        String expectedPhoneNo = fixedData.getOwner1().getPhoneNo();
        Optional<String> optionalActualPhoneNo = dogRepository.getOwnerPhoneNoByDogId(11);
        assertTrue(optionalActualPhoneNo.isPresent());
        assertEquals(expectedPhoneNo, optionalActualPhoneNo.get());
    }

    @Test
    void getOwnerPhoneNoByDogId_ShouldReturnEmptyOptional_WhenDogDoesNotExist() {
        Optional<String> optionalActualPhoneNo = dogRepository.getOwnerPhoneNoByDogId(99);
        assertTrue(optionalActualPhoneNo.isEmpty());
    }

    @Test
    void getOwnerEmailByDogId_ShouldReturnEmail_WhenDogExists() {
        String expectedEmail = fixedData.getOwner2().getEmail();
        Optional<String> optionalActualEmail = dogRepository.getOwnerEmailByDogId(21);
        assertTrue(optionalActualEmail.isPresent());
        assertEquals(expectedEmail, optionalActualEmail.get());
    }

    @Test
    void getOwnerEmailByDogId_ShouldReturnEmptyOptional_WhenDogDoesNotExist() {
        Optional<String> optionalActualEmail = dogRepository.getOwnerEmailByDogId(999);
        assertTrue(optionalActualEmail.isEmpty());
    }

    @Test
    void getOwnerFullNameByDogId_ShouldReturnFullName_WhenDogExists() {
        String expectedName = fixedData.getOwner2().getFullName();
        Optional<String> optionalActualName = dogRepository.getOwnerFullNameByDogId(21);
        assertTrue(optionalActualName.isPresent());
        assertEquals(expectedName, optionalActualName.get());
    }

    @Test
    void getOwnerFullNameByDogId_ShouldReturnEmptyOptional_WhenDogDoesNotExist() {
        Optional<String> optionalActualName = dogRepository.getOwnerFullNameByDogId(999);
        assertTrue(optionalActualName.isEmpty());
    }

    @Test
    void getDogsByBreed_ShouldReturnPolishGreyhoundList_WhenSearchForPolishGreyhound() {
        Dog dog1 = fixedData.getDog1();
        Dog dog4 = fixedData.getDog4();
        List<Dog> expectedDogList = Arrays.asList(dog1, dog4);
        List<Dog> actualDogList = dogRepository.getDogsByBreed("POLISH GREYHOUND");
        assertAll(() -> {
            assertEquals(actualDogList.size(), expectedDogList.size());
            assertTrue(expectedDogList.containsAll(actualDogList));
            assertTrue(actualDogList.containsAll(expectedDogList));
        });
    }

    @Test
    void getDogsByBreed_ShouldReturnEmptyList_WhenNonExistentBreedPassed() {
        List<Dog> expectedDogList = new ArrayList<>();
        List<Dog> actualDogList = dogRepository.getDogsByBreed("NON EXISTENT BREED");
        assertEquals(expectedDogList, actualDogList);
    }

    @Test
    void getDogsBySociability_ShouldReturnUnsociableDogs_WhenSearchByFalse() {
        Dog dog1 = fixedData.getDog1();
        Dog dog4 = fixedData.getDog4();
        Dog dog3 = fixedData.getDog3();
        List<Dog> expectedDogList = Arrays.asList(dog1, dog3, dog4);
        List<Dog> actualDogList = dogRepository.getDogsBySociability(false);
        assertAll(() -> {
            assertEquals(actualDogList.size(), expectedDogList.size());
            assertTrue(expectedDogList.containsAll(actualDogList));
            assertTrue(actualDogList.containsAll(expectedDogList));
        });
    }

    @Test
    void getDogsBySociability_ShouldReturnSociableDogs_WhenSearchByTrue() {
        Dog dog2 = fixedData.getDog2();
        List<Dog> expectedDogList = Collections.singletonList(dog2);
        List<Dog> actualDogList = dogRepository.getDogsBySociability(true);
        assertAll(() -> {
            assertEquals(actualDogList.size(), expectedDogList.size());
            assertTrue(expectedDogList.containsAll(actualDogList));
            assertTrue(actualDogList.containsAll(expectedDogList));
        });
    }

    @Test
    void getDogsByOwnerId_ShouldReturnAllOwner13Dogs_WhenId13Passed() {
        Dog dog1 = fixedData.getDog1();
        Dog dog4 = fixedData.getDog4();
        Dog dog3 = fixedData.getDog3();
        List<Dog> expectedDogList = Arrays.asList(dog1, dog4, dog3);
        List<Dog> actualDogList = dogRepository.getDogsByOwnerId(13);
        assertAll(() -> {
            assertEquals(actualDogList.size(), expectedDogList.size());
            assertTrue(expectedDogList.containsAll(actualDogList));
            assertTrue(actualDogList.containsAll(expectedDogList));
        });
    }

    @Test
    void getDogsByOwnerId_ShouldReturnEmptyList_WhenNonExistentOwnerIdPassed() {
        List<Dog> expectedDogList = new ArrayList<>();
        List<Dog> actualDogList = dogRepository.getDogsByOwnerId(999);
        assertEquals(expectedDogList, actualDogList);
    }

    @Test
    void getCountOfDogsForOwnerOfDogWithId_ShouldReturnOne_WhenId21Passed() {
        int expectedCount = 1;
        int actualCount = dogRepository.getOwnerDogCountByDogId(21);
        assertEquals(expectedCount, actualCount);
    }

    @Test
    void getCountOfDogsForOwnerOfDogWithId_ShouldReturnZero_WhenNonExistentDogIdPassed() {
        int expectedCount = 0;
        int actualCount = dogRepository.getOwnerDogCountByDogId(999);
        assertEquals(expectedCount, actualCount);
    }

    @Test
    void getOtherDogsOfSameBreedAsDogWithId_ShouldReturnListOfGreyHound_WhenId11Passed() {
        Dog dog1 = fixedData.getDog1();
        Dog dog4 = fixedData.getDog4();
        List<Dog> expectedDogList = Arrays.asList(dog1, dog4);
        List<Dog> actualDogList = dogRepository.getOtherDogsOfSameBreedAsDogWithId(11);
        assertAll(() -> {
            assertEquals(actualDogList.size(), expectedDogList.size());
            assertTrue(expectedDogList.containsAll(actualDogList));
            assertTrue(actualDogList.containsAll(expectedDogList));
        });
    }

    @Test
    void getOtherDogsOfSameBreedAsDogWithId_ShouldReturnEmptyList_WhenNonExistentDogIdPassed() {
        List<Dog> expectedDogList = new ArrayList<>();
        List<Dog> actualDogList = dogRepository.getOtherDogsOfSameBreedAsDogWithId(999);
        assertEquals(expectedDogList, actualDogList);
    }
}
