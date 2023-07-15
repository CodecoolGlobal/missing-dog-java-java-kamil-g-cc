package com.codecool.missing_dog.model;

import java.time.LocalDate;
import java.util.*;

public class DataGenerator {
    private final static int ownersAmount = 20;
    private final static int dogsAmount = 30;
    private final static List<String> dogNames = new ArrayList<>(Arrays.asList("BELLA", "BUDDY", "MAX", "SADIE", "LUCY",
            "BAILEY", "DAISY", "LUNA", "CHARLIE", "MAGGIE", "MOLLY", "COOPER", "GINGER", "JACK",
            "WILLOW", "ABBY", "BEAR", "LILY", "DUKE", "KODA"));
    private final static List<String> ownerLastNames = new ArrayList<>(Arrays.asList("Smith", "Johnson", "Williams", "Brown",
            "Jones", "Miller", "Davis", "Garcia", "Rodriguez", "Wilson"));
    private final static List<String> ownerFirstNames = new ArrayList<>(Arrays.asList("June", "Kellie", "Kirstin", "Moira",
                    "Veronica", "Ellen", "Evelyn", "Hilary", "Janine", "Lesley", "Abigail", "Diana", "Erica", "Roslyn",
                    "Annmarie", "David", "John", "Paul", "Mark", "James", "Andrew", "Scott", "Steven", "Robert",
                    "Stephen", "William", "Craig", "Michael", "Stuart", "Christopher", "Sabrina"));
    private final static List<String> breeds = new ArrayList<>(Arrays.asList("BLUE GASCONY GRIFFON",
            "POLISH GREYHOUND", "NORMAN ARTESIEN BASSET", "PORTUGUESE WATER DOG",
            "WELSH CORGI (CARDIGAN)", "LABRADOR", "IRISH TERRIER", "YUGOSLAVIAN SHEPHERD DOG",
            "JÄMTHUND", "BASENJI", "BERNESE MOUNTAIN DOG", "APPENZELL CATTLE DOG", "ENTLEBUCH CATTLE DOG",
            "KARELIAN BEAR DOG", "FINNISH SPITZ", "NEWFOUNDLAND", "FINNISH HOUND", "POLISH HOUND"));
    private final static Random random = new Random();

    private Owner createOwner(int id) {
        Owner owner = new Owner();
        int randomFirstNameIndex = getRandomIntInRange(ownerFirstNames.size());
        int randomLastNameIndex = getRandomIntInRange(ownerLastNames.size());
        String firstName = ownerFirstNames.get(randomFirstNameIndex).toUpperCase();
        String lastName = ownerLastNames.get(randomLastNameIndex).toUpperCase();
        String randomNumber = String.valueOf(getRandomIntInRange(100));
        String email = (firstName.substring(0, 3) + "." + lastName + randomNumber + "@domain.com").toUpperCase();
        String phoneNo = "+" + (10000000000L + ((long) random.nextInt(900000000) * 100) + random.nextInt(100));
        owner.setId(id);
        owner.setFirstName(firstName);
        owner.setLastName(lastName);
        owner.setEmail(email);
        owner.setPhoneNo(phoneNo);
        return owner;
    }

    private int getRandomIntInRange(int bound) {
        return random.ints(0, bound).findFirst().orElse(0);
    }

    private int getRandomIntInRange(int origin, int bound) {
        return random.ints(origin, bound).findFirst().orElse(0);
    }

    private long getRandomLongInRange(long origin, long bound) {
        return random.longs(origin, bound).findFirst().orElse(0L);
    }

    private Dog createDog(int id) {
        Dog dog = new Dog();
        int randomNameIndex = getRandomIntInRange(dogNames.size());
        int randomBreedIndex = getRandomIntInRange(breeds.size());
        String name = dogNames.get(randomNameIndex).toUpperCase();
        String breed = breeds.get(randomBreedIndex).toUpperCase();
        LocalDate startingDate = LocalDate.of(2005, 1, 1);
        LocalDate dateOfBirth = getRandomDateFrom(startingDate);
        Boolean isMale = random.nextBoolean();
        Boolean isSociable = random.nextBoolean();
        dog.setId(id);
        dog.setName(name);
        dog.setBreed(breed);
        dog.setMale(isMale);
        dog.setSociable(isSociable);
        dog.setDateOfBirth(dateOfBirth);
        return dog;
    }

    private LocalDate getRandomDateFrom(LocalDate startInclusive) {
        long startEpochDay = startInclusive.toEpochDay();
        long endEpochDay = LocalDate.now().toEpochDay();
        long randomDay = getRandomLongInRange(startEpochDay, endEpochDay);
        return LocalDate.ofEpochDay(randomDay);
    }

    public Data createData() {
        List<Dog> dogList = createDogList();
        List<Owner> ownerList = createOwnerList();
        pairDogsWithOwners(dogList, ownerList);
        return new Data(dogList, ownerList);
    }

    /**
     * Method assigning an Owner for each Dog.
     * As the result of this method each Dog must have an Owner,
     * Owner on the other hand may be assigned several or zero Dogs.
     * Iterating over List of Dogs
     * find Owner of id = randomOwnerId.
     * If Owner of given id is found
     * add the Dog from this iteration to their dogList
     * and set the Dog's Owner to that Owner.
     * @param dogList list of randomly generated Dogs with no Owner assigned
     * @param ownerList list of randomly generated Owners with empty List of Dogs
     */
    private void pairDogsWithOwners(List<Dog> dogList, List<Owner> ownerList) {
        throw new UnsupportedOperationException("Not implemented yet");

//        for (Dog dog : dogList) {
//            int randomOwnerId = getRandomIntInRange(1, ownersAmount);
//        }
    }

    private List<Dog> createDogList() {
        List<Dog> dogList = new ArrayList<>();
        for (int i = 1; i <= dogsAmount; i++) {
            dogList.add(createDog(i));
        }
        return dogList;
    }

    private List<Owner> createOwnerList() {
        List<Owner> ownerList = new ArrayList<>();
        for (int i = 1; i <= ownersAmount; i++) {
            ownerList.add(createOwner(i));
        }
        return ownerList;
    }
}
