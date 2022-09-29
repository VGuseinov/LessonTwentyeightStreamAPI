package com.company;

import java.util.LinkedList;

public class Cat {
    private String name;
    private int age;
    private LinkedList<String> vacctinations = new LinkedList<>();

    @Override
    public String toString() {
        return "Cat{" +
                " name = '" + name + '\'' +
                ", age = " + age +
                ", vacctinations = " + vacctinations +
                '}';
    }


    public static class Builder {
        private Cat cat = new Cat();

        /* промеждуточные (Intermediate) методы
         * 1. должны возвращать ссылку на текущий объект Builder
         * 2. не должны прерывать процесс построения объекта */


        public Builder setName(String name) {
            cat.name = name;
            return this;
        }

        public Builder setAge(int age) {
            cat.age = age;
            return this;
        }

        public Builder addVacctinations(String v) {
            cat.vacctinations.add(v);
            return this;
        }

        /* в классе обязан присутствовать конечный метоод (Terminated)
        * должен завершать процесс простроения
        * и возвращать итоговый объект*/


        public Cat build() {
            return this.cat;
        }
    }
}
