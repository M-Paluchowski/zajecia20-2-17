package examples;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        //TWORZENIE STRUNIENI
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6);
        Stream<Integer> streamCollection = integers.stream();
        Stream<Integer> streamOf = Stream.of(1, 2, 3, 4, 5);

        // Czasem przydatne
        //        Stream.empty();

        Stream<Integer> concatStream = Stream.concat(streamCollection, streamOf);

        System.out.println("--------------------------------");

        List<Integer> integers1 = List.of(1, 2, 3, 4, 5, 6);

        integers1.stream()
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) {
                        return integer % 2 == 0;
                    }
                })
                .forEach(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) {
                        System.out.println(integer);
                    }
                });
//        System.out.println(integers1);
        System.out.println("--------------------------------");

        Stream.of("abc", "bca", "qwerty")
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(String string) {
                        return string.startsWith("a");
                    }
                })
                .forEach(new Consumer<String>() {
                    @Override
                    public void accept(String string) {
                        System.out.println(string);
                    }
                });

        System.out.println("--------------------------------");

        List<Integer> integers2 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        integers2.stream()
                .limit(5)
                .forEach(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) {
                        System.out.println(integer);
                    }
                });

        System.out.println("--------------------------------");

        Stream.of(1, 2, 3, 4)
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer) {
                        return integer * 2;
                    }
                })
                .forEach(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) {
                        System.out.println(integer);
                    }
                });

        System.out.println("--------------------------------");

        Set<String> names = Set.of("Ania", "Marcin", "Jarek");
        names.stream()
                .map(new Function<String, Human>() {
                    @Override
                    public Human apply(String name) {
                        return new Human(name);
                    }
                })
                .forEach(new Consumer<Human>() {
                    @Override
                    public void accept(Human human) {
                        System.out.println(human);
                    }
                });

        System.out.println("--------------------------------");

        Set<String> names2 = Set.of("Ania", "Marcin", "Jarek");

        List<Human> collect = names2.stream()
                .map(new Function<String, Human>() {
                    @Override
                    public Human apply(String name) {
                        return new Human(name);
                    }
                })
                .collect(Collectors.toList());
//        Collectors.toSet()
        System.out.println(collect);

        System.out.println("--------------------------------");

        List<Integer> even = Stream.of(1, 2, 3, 4, 5, 6)
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) {
                        return integer % 2 == 0;
                    }
                })
                .collect(Collectors.toList());

        List<Integer> collect2 = even.stream()
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer) {
                        return integer * 2;
                    }
                }).collect(Collectors.toList());

        List<Integer> collect1 = even.stream()
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer) {
                        return integer / 3;
                    }
                })
                .collect(Collectors.toList());

        System.out.println(even);
        System.out.println(collect1);
        System.out.println(collect2);

        System.out.println("--------------------------------");
        int multiplier = 2;

        Stream.of(1, 2, 3, 4, 5, 6)
                .filter(number -> number % 2 == 0)
                .map(number -> number * multiplier)
                .forEach(number -> System.out.println(number));

        System.out.println("--------------------------------");

        Set<String> names3 = Set.of("Ania", "Antek", "Jarek");

        List<Human> collect3 = names3.stream()
                .filter(firstName -> firstName.startsWith("A"))
                .map(firstName -> new Human(firstName))
                .filter(human -> human.getFirstName().endsWith("a"))
                .collect(Collectors.toList());

        System.out.println(collect3);

        System.out.println("--------------------------------");

        List<Integer> integers3 = List.of(1, 2, 3, 4, 5);
        long count = integers3.stream()
                .count();
        System.out.println(count);

        System.out.println("--------------------------------");

        Set<String> names4 = Set.of("Ania", "Antek", "Jarek");
        List<Human> collect4 = names4.stream()
                .map(firstName -> new Human(firstName))
                .collect(Collectors.toList());

        boolean anyMatch = collect4.stream()
                .anyMatch(human -> human.getFirstName().endsWith("z"));
        System.out.println(anyMatch);

        boolean allMatch = collect4.stream()
                .allMatch(person -> person.getFirstName().endsWith("k"));
        System.out.println(allMatch);

        boolean noneMatch = collect4.stream()
                .noneMatch(human -> human.getFirstName().startsWith("W"));
        System.out.println(noneMatch);

        System.out.println("--------------------------------");

        List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).stream()
            .skip(5)
            .forEach(number -> System.out.println(number));

        System.out.println("--------------------------------");

        List<Integer> integers4 = List.of(45, 7645, 6, 32, 4512, 312);
        List<Integer> collect5 = integers4.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(collect5);

        System.out.println("--------------------------------");

        Set<String> names5 = Set.of("Zuza", "Iza", "Ania");
        List<Human> collect6 = names5.stream()
                .map(Human::new)
                .sorted((humanOne, humanTwo) -> humanOne.getFirstName().compareTo(humanTwo.getFirstName()))
//                .sorted(Comparator.comparing((Human human) -> human.getFirstName()).reversed())
                .collect(Collectors.toList());
        System.out.println(collect6);

        System.out.println("--------------------------------");

        Set<String> names6 = Set.of("Zuza", "Iza", "Ania");
        List<Human> collect7 = names5.stream()
                .map(Human::new)
                .sorted((humanOne, humanTwo) -> humanOne.getFirstName().compareTo(humanTwo.getFirstName()))
//                .sorted(Comparator.comparing((Human human) -> human.getFirstName()).reversed())
                .collect(Collectors.toList());
        System.out.println(collect6);

        System.out.println("--------------------------------");
        Set<String> names7 = Set.of("Zuza", "Iza", "Ania");
        List<String> collect8 = names7.stream()
                .filter(Main::checkName)
                .collect(Collectors.toList());
        System.out.println(collect8);
    }

    private static boolean checkName(String name) {
        return name.startsWith("I");
    }

    static class Human {
        private String firstName;

        public Human(String firstName) {
            this.firstName = firstName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        @Override
        public String toString() {
            return "Human{" +
                    "firstName='" + firstName + '\'' +
                    '}';
        }
    }
}
