

import model.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * Класс для реализации домашнего задания номер три, часть 2.
 */
public class Homework3_2 {

    /**
     * Реализовать метод при помощи {@link java.util.stream.Stream} который:
     * - группирует заданых персон по возрасту
     * - фильтрует по минимальному возрасту
     * - Убирает дубликаты персон по имени
     * @param persons - заданный список персон
     * @param minimalAgeFilter - указанный минимальный возраст
     * @param removeDupes - флаг отвечающий за исключение дубликатов из результата
     * @return словарь где ключ возраст, а значение лист персон с этим возрастом
     */
    public Map<Integer, List<Person>> groupByAge(List<Person> persons, int minimalAgeFilter, boolean removeDupes) {


        if (removeDupes) {
            return persons.stream()
                    .filter(person -> person.getAge() >= minimalAgeFilter)
                    .collect(Collectors.groupingBy(Person::getAge,
                            Collectors.collectingAndThen(
                                    Collectors.toMap(
                                            Person::getName,
                                            Function.identity(),
                                            (existing, replacement) -> existing
                                    ),
                                    map -> new ArrayList<>(map.values())
                            )));
        } else {
            return persons.stream()
                    .filter(person -> person.getAge() >= minimalAgeFilter)
                    .collect(Collectors.groupingBy(Person::getAge));
        }

        //return Map.of();
    }
}
