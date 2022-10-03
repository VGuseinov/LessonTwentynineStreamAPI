package com.company;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList<Cat> cats = new LinkedList<>();
        cats.add(new Cat("Barsik", 68));
        cats.add(new Cat("Tom", 84));
        cats.add(new Cat("Bublik", 1));
        cats.add(new Cat("Bagira", 16));
        cats.add(new Cat("Brichka", 120));
        cats.add(new Cat("Raiden", 124));
        cats.add(new Cat("Blinchik", 24));
        cats.add(new Cat("Lu-Khan", 5));
        cats.stream()
                // преобразование объектов класса Cat в объекты класса Dog
                .map((Cat cat) -> new Dog("black", cat.getName(), cat.getAge()))
                .skip(3)
                .limit(4)
                .forEach(System.out::println);
        System.out.println("--------------------------------------------------------------------------------------------");

        // пагинация
        DogRepository dogRepository = new DogRepository();
        dogRepository.getDogs(new Dog.PaginationBuilder(2, 3)
                .setMinAge(2)
                .setMaxAge(12)
                .setSort(((d1, d2) -> Integer.compare(d2.getAge(), d1.getAge())))
                .build())
                .stream()
                .forEach(System.out::println);
    }
}
