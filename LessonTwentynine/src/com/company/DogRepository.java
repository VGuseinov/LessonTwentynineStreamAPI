package com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DogRepository {
    private LinkedList<Dog> dogs = new LinkedList<>();

    public DogRepository() {
        this.dogs.add(new Dog("grey", "Russel", 56));
        this.dogs.add(new Dog("orange", "Jack", 4));
        this.dogs.add(new Dog("blue", "Bill", 2));
        this.dogs.add(new Dog("red", "Jim", 51));
        this.dogs.add(new Dog("brown", "Akhmed", 156));
        this.dogs.add(new Dog("sky-blue", "Sadam", 26));
        this.dogs.add(new Dog("black", "BlueRay", 6));
        this.dogs.add(new Dog("green", "Ray Dalton", 36));
        this.dogs.add(new Dog("grey", "Jeff Besos", 516));
        this.dogs.add(new Dog("yellow-black", "Mark Zuckerberg", 66));
        this.dogs.add(new Dog("grey-blue", "Ilon Mask", 59));
        this.dogs.add(new Dog("red-sky", "James Webb", 1));
        this.dogs.add(new Dog("black-white", "Woren Buffet", 11));
        this.dogs.add(new Dog("white", "Bill Gates", 45));
        this.dogs.add(new Dog("violet", "Arnold Sharznegger", 12));
        this.dogs.add(new Dog("blue-yellow", "Jason Stathem", 42));
        this.dogs.add(new Dog("yellow", "Vin Diesel", 21));
        this.dogs.add(new Dog("black-gray", "Kurt Russel", 57));
        this.dogs.add(new Dog("gray-green", "Polina BuBuBu", 89));
        this.dogs.add(new Dog("green-white", "Lee Priest", 8));
        this.dogs.add(new Dog("red-black", "Bruce Lee", 2));
        this.dogs.add(new Dog("green-yellow", "Jackie Chan", 3));
    }

    public List<Dog> getDogs(Dog.Pagination p) {
        Stream<Dog> stream = this.dogs.stream();
        // сортировка (если указана)
        if (p.getSortBy() != null) {
            stream = stream.sorted(p.getSortBy());
        }

        // фильтр по возрасту (если задан)
        if (p.getFromAge() != null) {
            stream = stream.filter((dog) -> dog.getAge() >= p.getFromAge());
        }
        if (p.getToAge() != null) {
            stream = stream.filter((dog) -> dog.getAge() <= p.getToAge());
        }
        return stream
                .skip((p.getPage() - 1) * p.getPerPage())
                .limit(p.getPerPage())
                .collect(Collectors.toList());
    }
}