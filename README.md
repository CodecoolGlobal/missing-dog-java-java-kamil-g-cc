# Missing Dog

## Story

### Missing Dog
```DISCLAIMER: no real dogs are missing - do not worry```

Your friend's aunt Clarence runs a dog hotel. Good for her the business grows
and more and more dog owners leave their dogs there going for holidays.
Good for you because when Clarence heard you are good at *computer stuff*
she asked for help with creating a computer registry
that would replace her old notebook registry version.
However, the advantage of a notebook is that is does not break down, so
your code must handle situations when the registry search criteria are not met -
and where there should be a dog, there is none.

In this project, your primary goal is to get familiar with **Optional API** as well as
review and practice the usage of **Stream API**. Three classes need method implementation.

Run unit tests to see if your implementation is correct.
Focus on handling potential null pointers in given data and use Streams to finish this project.

**IMPORTANT**: Optional API serves many purposes
so several correct implementations are possible.
Do not stick with one solution, try to play around with as many methods as possible.


## What are you going to learn?

- learn the Optional API
- review and practise Streams API


## Tasks

1. Implement the `pairDogsWithOwners()` method in `DataGenerator` class.
    - For each iteration of pairing the Dog with the Owner, the Owner's id is chosen randomly.
    - For each iteration method `pairDogsWithOwners()` uses `Optional.ifPresent()` and adds the Dog to Owner dogSet and sets that Dog's Owner to that Owner.
    - As a result of `pairDogsWithOwners()` each Dog must have an Owner, Owner on the other hand may be assigned several or zero Dogs.

2. Implement the `OwnerRepository` class that will provide owner data management functionality for the application.
    - `getById()` returns Owner if found one with given id, otherwise returns Optional.empty().
    - `getByEmail()` returns Owner with given email if found, otherwise returns Optional.empty().

3. Implement the `DogRepository` class that will provide dog data management functionality for the application.
    - `getById()` returns Dog if found one with given id, otherwise returns Optional.empty().
    - `getOwnerPhoneNoByDogId()` returns owner's phone number for the dog of given id, if dog is not found returns Optional.empty().
    - `getOwnerEmailByDogId()` returns owner's email for the dog of given id, if dog is not found returns Optional.empty().
    - `getOwnerFullNameByDogId()` returns owner's full name for the dog of given id, if dog is not found returns Optional.empty().
    - `getDogsByBreed()` returns all dogs of given breed. List can be empty.
    - `getDogsBySociability()` returns all dogs by their sociability. Lists can be empty.
    - `getDogsByOwnerId()` returns all dogs owned by Owner of given id, list can be empty
    - `getOwnerDogCountByDogId()` returns count of dogs the owner has.
    - `getOtherDogsOfSameBreedAsDogWithId()` returns list of dogs of the same breed as dog of given id, list can be empty

4. Implement methods according to their description.
    - The `showDogById()` uses right Input method to gather input from user.
    - The `showDogById()` uses appropriate DogRepository method to get the Dog.
    - The `showDogById()` uses the Optional method to handle two scenarios:
  1) Dog is found - prints the Dog using the right display method
  2) Dog is not found - uses display method to inform about that.
    - The `showDogById()` uses the Optional method that makes the call a single liner.
    - The `showOwnerById()` uses right Input method to gather input from user.
    - The `showOwnerById()` uses appropriate OwnerRepository method to get the Owner.
    - The `showOwnerById()` uses the Optional method to handle two scenarios
  1) Owner is found - print the Owner using the right display method
  2) Owner is not found - use display method to inform about that.
The right Optional method choice makes the call a single liner.
    - The right Optional method choice makes the call a single liner.
    - The `showOwnerPhoneNoByDogId()` uses right Input method to gather input from user.
    - The `showOwnerPhoneNoByDogId()` uses the appropriate DogRepository method to get the phone number.
    - The `showOwnerPhoneNoByDogId()` uses the Optional method to handle two scenarios
  1) email is found - print the email using the right display method
  2) email is not found - use display method to inform about that.
The right Optional method choice makes the call a single liner.
    - The right Optional method choice makes the call a single liner.
    - The `showOwnerFullNameByDogId()` uses right Input method to gather input from user.
    - The `showOwnerFullNameByDogId()` uses the appropriate DogRepository method to get the name.
    - The `showOwnerFullNameByDogId()` uses the Optional method to handle two scenarios
  1) name is found - print the name using the right display method
  2) name is not found - use display method to inform about that.
    - The right Optional method choice makes the call a single liner.

## General requirements

None

## Hints

- Complete tasks in given order, that is first implement `ModelFactory`
  then `OwnerRepository` and `DogRepository`  and finally `DogHotelRegistry` class
- Remember that Streams are your friends ;)
- Although it might be tempting to use `if statement` combined with `Optional.isPresent()`
  do your best to avoid this approach. Such usage is considered a bad practise. All necessary methods can be found in the background materials.
- Feel free to write your own tests as an additional way of checking your code's correctness

## Background materials

- [Optional documentation](https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html)
- [Optional Guide by Oracle](https://www.oracle.com/technical-resources/articles/java/java8-optional.html)
- [Another Optional guide](https://www.baeldung.com/java-optional)
- Once you get a good feeling of Optionals have some [Optional practice](https://www.codingame.com/playgrounds/20782/java-guild-meeting-52018/optionals---practice)
- [Guide through Streams](https://stackify.com/streams-guide-java-8/)
- [Another Streams guide](https://www.baeldung.com/java-stream-operations-on-strings)
- [Using Map in Streams](https://www.baeldung.com/java-maps-streams)
- [Using Filter in Streams](https://www.baeldung.com/java-stream-filter-lambda)
- [Using Count in Streams](https://www.baeldung.com/java-stream-filter-count)
- [Using Collectors in Streams](https://www.baeldung.com/java-8-collectors)

