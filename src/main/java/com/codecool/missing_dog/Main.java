package com.codecool.missing_dog;

import com.codecool.missing_dog.model.Data;
import com.codecool.missing_dog.model.DataGenerator;

public class Main {
    /**
     * Uncomment when DataGenerator functionality is implemented
     */
    public static void main(String[] args) {

       Data data = new DataGenerator().createData();
        System.out.println("hello");

        //        Display display = new Display();
//        Input input = new Input();

//        Data data = new ModelFactory().createData();

//        DogRepository dogRepository = new DogRepository(data.getDogList());
//        OwnerRepository ownerRepository = new OwnerRepository(data.getOwnerList());
//
//        DogHotelRegistry dogHotelRegistry = new DogHotelRegistry(dogRepository, ownerRepository, display, input);
//        dogHotelRegistry.run();
    }
}
