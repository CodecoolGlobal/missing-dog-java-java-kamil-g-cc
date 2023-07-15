package com.codecool.missing_dog.controller;

import com.codecool.missing_dog.input.Input;
import com.codecool.missing_dog.model.Dog;
import com.codecool.missing_dog.model.Owner;
import com.codecool.missing_dog.repository.DogRepository;
import com.codecool.missing_dog.repository.OwnerRepository;
import com.codecool.missing_dog.view.View;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ControllerTest {
    private final static ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final static PrintStream originalOut = System.out;
    private static DogRepository dogRepository;
    private static OwnerRepository ownerRepository;
    private static View view;
    private static Controller controller;

    @BeforeAll
    static void setUp() {
        System.setOut(new PrintStream(outContent));
        dogRepository = mock(DogRepository.class);
        ownerRepository = mock(OwnerRepository.class);
        view = new View();
        Input input = mock(Input.class);
        controller = new Controller(dogRepository, ownerRepository, view, input);
    }

    @AfterAll
    static void restoreStreams() {
        System.setOut(originalOut);
    }

    @AfterEach
    void clearStreams() {
        outContent.reset();
    }


    @Test
    public void showDogById_ShouldPrintDog_WhenDogExists() {
        Dog dog = createDog();
        when(dogRepository.getById(anyInt())).thenReturn(Optional.of(dog));
        controller.showDogById();
        assertEquals(view.returnDogPrint(dog).trim(), outContent.toString().trim());
    }

    @Test
    public void showDogById_ShouldPrintNoDataInfo_WhenDogDoesNotExist() {
        when(dogRepository.getById(anyInt())).thenReturn(Optional.empty());
        controller.showDogById();
        assertEquals(view.returnNoDataFoundPrint().trim(), outContent.toString().trim());
    }

    @Test
    void showOwnerById_ShouldPrintOwner_WhenOwnerExists() {
        Owner owner = createOwner();
        when(ownerRepository.getById(anyInt())).thenReturn(Optional.of(owner));
        controller.showOwnerById();
        assertEquals(view.returnOwnerPrint(owner).trim(), outContent.toString().trim());
    }

    @Test
    public void showOwnerById_ShouldPrintNoDataInfo_WhenOwnerDoesNotExist() {
        when(ownerRepository.getById(anyInt())).thenReturn(Optional.empty());
        controller.showOwnerById();
        assertEquals(view.returnNoDataFoundPrint().trim(), outContent.toString().trim());
    }

    @Test
    void showOwnerByEmail_ShouldPrintOwner_WhenOwnerExists() {
        Owner owner = createOwner();
        when(ownerRepository.getByEmail(any())).thenReturn(Optional.of(owner));
        controller.showOwnerByEmail();
        assertEquals(view.returnOwnerPrint(owner).trim(), outContent.toString().trim());
    }

    @Test
    public void showOwnerByEmail_ShouldPrintNoDataInfo_WhenOwnerDoesNotExist() {
        when(ownerRepository.getByEmail(any())).thenReturn(Optional.empty());
        controller.showOwnerByEmail();
        assertEquals(view.returnNoDataFoundPrint().trim(), outContent.toString().trim());
    }

    @Test
    void showOwnerEmailByDogId_ShouldPrintOwnerEmail_WhenExists() {
        Owner owner = createOwner();
        String email = owner.getEmail();
        when(dogRepository.getOwnerEmailByDogId(anyInt())).thenReturn(Optional.of(email));
        controller.showOwnerEmailByDogId();
        assertEquals(email, outContent.toString().trim());
    }

    @Test
    void showOwnerEmailByDogId_ShouldPrintNoData_WhenDoesNotExists() {
        when(dogRepository.getOwnerEmailByDogId(anyInt())).thenReturn(Optional.empty());
        controller.showOwnerEmailByDogId();
        assertEquals(view.returnNoDataFoundPrint(), outContent.toString().trim());
    }


    @Test
    void showOwnerPhoneNoByDogId_ShouldPrintOwnerPhoneNo_WhenExists() {
        Owner owner = createOwner();
        String phoneNo = owner.getPhoneNo();
        when(dogRepository.getOwnerPhoneNoByDogId(anyInt())).thenReturn(Optional.of(phoneNo));
        controller.showOwnerPhoneNoByDogId();
        assertEquals(phoneNo, outContent.toString().trim());
    }

    @Test
    void showOwnerPhoneNoByDogId_ShouldPrintNoData_WhenDoesNotExists() {
        when(dogRepository.getOwnerPhoneNoByDogId(anyInt())).thenReturn(Optional.empty());
        controller.showOwnerPhoneNoByDogId();
        assertEquals(view.returnNoDataFoundPrint(), outContent.toString().trim());
    }

    @Test
    void showOwnerFullNameByDogId_ShouldPrintOwnerName_WhenExists() {
        Owner owner = createOwner();
        String fullName = owner.getFirstName() + " " + owner.getLastName();
        when(dogRepository.getOwnerFullNameByDogId(anyInt())).thenReturn(Optional.of(fullName));
        controller.showOwnerFullNameByDogId();
        assertEquals(fullName, outContent.toString().trim());
    }

    @Test
    void showOwnerFullNameByDogId_ShouldPrintOwnerName_WhenDoesNotExists() {
        when(dogRepository.getOwnerFullNameByDogId(anyInt())).thenReturn(Optional.empty());
        controller.showOwnerFullNameByDogId();
        assertEquals(view.returnNoDataFoundPrint(), outContent.toString().trim());
    }


    private Dog createDog() {
        Dog dog = new Dog();
        dog.setId(12);
        dog.setName("ZORRO");
        dog.setBreed("POLISH GREYHOUND");
        dog.setDateOfBirth(LocalDate.of(2020, 10, 12));
        dog.setMale(true);
        dog.setSociable(false);
        return dog;
    }

    private Owner createOwner() {
        Owner owner = new Owner();
        owner.setFirstName("JAN");
        owner.setLastName("BUCZYNA");
        owner.setEmail("JAN.BUKA@GMAIL.COM");
        owner.setPhoneNo("+48502629050");
        owner.setId(12);
        return owner;
    }
}
