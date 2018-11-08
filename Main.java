package com.isilaev.test;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> nameList = Arrays.asList("Gleb", "Ivan", "Anton", "Sergey", "Anton", "Alexander", "Kirill");

        /*
        Вернуть количество вхождений объекта «a1»
         */

        int howManyAntonsDoWeHave = (int) nameList.stream().filter("Anton"::equals).count();

        System.out.println("Так сколько Антонов то? ");
        System.out.println("Так " + howManyAntonsDoWeHave + " же");


        System.out.println("\n\n");

        /*
        Вернуть первый элемент коллекции или 0, если коллекция пуста
         */

        String aintNobodyHere = "Никого тут нет :(";
        String firstElementOnFilledList = nameList.stream().findFirst().orElse(aintNobodyHere);
        String firstElementOnEmptyList = Stream.of("").findFirst().orElse(aintNobodyHere);

        System.out.println("Лист со значениями вернул: " + firstElementOnFilledList);
        System.out.println("Пустой лист вернул: " + firstElementOnEmptyList);


        System.out.println("\n\n");

        /*
        Вернуть последний элемент коллекции или «empty», если коллекция пуста
         */

        String findAnyOnFilledList = nameList.stream().findAny().orElse(aintNobodyHere);
        String findAnyOnEmpyList = Stream.of("").findAny().orElse(aintNobodyHere);

        System.out.println("Лист со значениями вернул: " + findAnyOnFilledList);
        System.out.println("Пустой лист вернул: " + findAnyOnEmpyList);

        System.out.println("\n\n");

        /*
        Найти элемент в коллекции равный «a3» или кинуть ошибку
         */

        try {
            String findFirstOrThrow = nameList.stream().filter("Evgeniy"::equals).findFirst().get();

            System.out.println(findFirstOrThrow);
        } catch (NoSuchElementException e) {
            System.out.println("Нет таких у нас, алло.");
        }

        nameList.stream().filter("Evgeniy"::equals).findFirst().ifPresent(s -> System.out.println("Нашёл: " + s));


        System.out.println("\n\n");

        /*
        Вернуть третий элемент коллекции по порядку
         */

        nameList.stream().skip(2).findFirst().ifPresent(s -> System.out.println("Пятый элемент: " + s));

        System.out.println("\n\n");

        /*
        Вернуть два элемента начиная со второго
         */

        Object[] streamToArrayWithLimit = nameList.stream().skip(1).limit(3).toArray();

        System.out.println(Arrays.toString(streamToArrayWithLimit));

        /*
        Выбрать все элементы по шаблону
         */

        List<String> employeeWithNameStartOnA = nameList.stream().filter(s -> s.startsWith("A")).collect(Collectors.toList());

        employeeWithNameStartOnA.forEach(System.out::println);

        System.out.println("\n\n");

        List<Employee> employees = new ArrayList<>();

        Employee aKolchin = new Employee("Alexander", "Kolchin", 418);
        employees.add(aKolchin);

        Employee sNikitin = new Employee("Sergey", "Nikitin", 400);
        employees.add(sNikitin);

        Employee gPomerancev = new Employee("Gleb", "Pomerantcev", 417);
        employees.add(gPomerancev);

        Employee iSilaev = new Employee("Ivan", "Silaev", 417);
        employees.add(iSilaev);

        Employee aSekachev = new Employee("Anton", "Sekachev", 417);
        employees.add(aSekachev);

        Employee dChubiryaev = new Employee("Danil", "Chubiryaev", 400);
        employees.add(dChubiryaev);

        /*
        Выбрать всех и рассадить в Map<String, Integer>
         */

        Map<String, Integer> sortedEmployeeMap = employees
                .stream()
                .collect(Collectors.toMap(v -> v.getFirstName() + " " + v.getLastName(), Employee::getRoomNumber))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap
                        (Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));


        List<Employee> employeeList = employees.stream().sorted().collect(Collectors.toList());

        System.out.println("done");
    }
}
