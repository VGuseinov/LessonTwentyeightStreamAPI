package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
	    // Stream API
        // pattern: builder

        /* объект класса Stream можно создать на основе
        * массива либо коллекции*/
        Cat cat = new Cat.Builder()
                .setAge(790)
                .setAge(790)
                .setAge(790)
                .setName("Tom")
                .addVacctinations("159")
                .addVacctinations("1fgljdfk")
                .addVacctinations("15767")
                .build();
        System.out.println(cat);

        IntStream intStream = Arrays.stream(new int[] {1, 2, 3, 5, 7});
        System.out.println(intStream); // stream на основе массива
        Stream s = Stream.of("pussy", "pussy2", "pussy5");
        System.out.println(s);

        // Stream на основе коллекции
        ArrayList<Double> arrayList = new ArrayList<>();
        arrayList.add(-21.123);
        arrayList.add(213.547);
        arrayList.add(-213.546);
        arrayList.add(213.546);
        Stream<Double> stream = arrayList.stream();
        stream
                .filter((e) -> e > 0)
                .sorted(((o1, o2) -> (int)(o1 - o2)))
                .forEach(System.out::println);

        LinkedList<Double> filteredList = new LinkedList<>();
        arrayList.stream()
                .filter((e) -> e > 0)
                .forEach(filteredList::add);
        System.out.println(filteredList);

        Double d = arrayList.stream()
                .filter((e) -> e > 0)
                .findFirst()
                .get();
        System.out.println(d);

        // allMatch - сооответствуют ли все жлементы условию
        // anyMatch - сооответствует ли хотя-бы один элемнт условию

        boolean bool = arrayList.stream()
                .filter((e) -> e > 0)
                .allMatch((e) -> e < 500);
        System.out.println(bool);

        Double aDouble = arrayList.stream()
                .max((a, b) -> (int)(a - b))
                .get();
        System.out.println(aDouble);


        aDouble = arrayList.stream()
                .reduce((p, c) -> p + c)
                .get();
        System.out.println(aDouble);

        System.out.println(arrayList.stream()
            .reduce(100.0, (p, c) -> p + c));

        arrayList
                .parallelStream()
                .forEach(System.out::println);
    }
}
