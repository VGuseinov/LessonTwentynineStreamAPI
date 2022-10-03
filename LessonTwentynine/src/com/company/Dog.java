package com.company;

import java.util.Comparator;

public class Dog {
    private String name;
    private int age;
    private String color;

    public Dog(String color, String name, int age) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static class Pagination {
        private int page;
        private int perPage;
        private Integer fromAge = null;
        private Integer toAge = null;
        private Comparator<Dog> sortBy = null;

        public Comparator<Dog> getSortBy() {
            return sortBy;
        }

        public int getPage() {
            return page;
        }

        public int getPerPage() {
            return perPage;
        }

        public Integer getFromAge() {
            return fromAge;
        }

        public Integer getToAge() {
            return toAge;
        }
    }

    public static class PaginationBuilder {
        private Pagination p;

        public PaginationBuilder (int page, int perPage) {
            this.p = new Pagination();
            this.p.perPage = perPage;
            this.p.page = page;
        }

        public PaginationBuilder setSort(Comparator<Dog> sort) {
            this.p.sortBy = sort;
            return this;
        }

        public PaginationBuilder setMinAge(Integer age) {
            this.p.fromAge = age;
            return this;
        }

        public PaginationBuilder setMaxAge(Integer age) {
            this.p.toAge = age;
            return this;
        }

        public Pagination build() {
            return this.p;
        }
    }
}
