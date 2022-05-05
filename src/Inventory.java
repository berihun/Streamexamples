import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Inventory {
    public static void main(String[] args) {
//this example show how we use java in functional programming
        //arraylist variables
        List<Apple> result = new ArrayList<>();
        List<Apple> resultNew = new ArrayList<>();
        //array variable
        Apple a = new Apple("green", 152);
        //add object to the arraylist
        result.add(a);
        a = new Apple("green", 123);
        result.add(a);
        a = new Apple("yellow", 120);
        result.add(a);
        a = new Apple("white", 90);
        result.add(a);
        a = new Apple("blue", 85);
        result.add(a);
        a = new Apple("lightblue", 70);
        result.add(a);
        a = new Apple("lightgreen", 12);
        result.add(a);
        a = new Apple("skyblue", 58);
        result.add(a);

        //create new object/instance of Apple class
        Apple c = new Apple();
        //show data
        System.out.println("all: " + result);
        //using stream to filter only green apple whose wieght is >150
        List<Apple> greenApples = result
                .stream()
                .filter(apple -> "green".equals(apple.getColor()) && apple.getWeight() > 150)
                .collect(Collectors.toList());

        System.out.println("filter by java 8 steam : " + greenApples);
        //example how we might solve the green apple filtering using the imperative approach
        System.out.println("filtered traditional way: " + filterApplesByColor(result, "green"));
      //array of integer
        int[] s = {1, 2, 3, 4, 5};
//        List<Integer> evenNumbers = Arrays.stream(s)
//                .filter(i -> i % 2 == 0)
//                .toArray(Collectors.toa);
       //sorting using comparing in reverse order
        result.sort(Comparator.comparing(Apple::getWeight).reversed());
        System.out.println("after sorting: " + result);
// filter and sort   apple using wieght and  then show only color of apple
        List<String> lowCaloricDishesName =
                result.parallelStream()
                        .filter(d -> d.getWeight() < 400)
                        .sorted(Comparator.comparing(Apple::getWeight))
                        .map(Apple::getColor)
                        .collect(Collectors.toList());

        System.out.println("after sorting: " + lowCaloricDishesName);
        String lines = "I Love Java ] 8 Stream!";

        // split by space, uppercase, and convert to Array
        String[] results = Arrays.stream(lines.split("\\]+"))
                .map(String::toLowerCase)
                .toArray(String[]::new);
        System.out.println("split example by brace: ");
        for (String f : results) {
            System.out.println(f);
        }

        List<String> allAplles = result
                .stream().
                filter(d -> {
                    System.out.println(d);
                    return d.getWeight() > 10;
                })
                .map(d -> {
                    System.out.println(d.getColor());
                    return d.getColor();
                })
                .limit(8)
                .collect(Collectors.toList());

        System.out.println("manipulating all apples.......");
        System.out.println(allAplles);
        System.out.println("foreach statement with println.......");

        allAplles.stream().forEach(System.out::println);
        String k = "Hello { There { Is everything { goind well!";
        String[] kk = Arrays.stream(k.split("\\{+"))
                .map(String::toLowerCase)
                .toArray(String[]::new);

        System.out.println("split json data by curly brace, size is: " + kk.length);
        for (String j : kk)
            System.out.println(j);
        List<String> fields = Arrays.asList(kk);//stream(kk).toList()

        System.out.println("field level spliting size ... " + fields.size());
        List<String> fields1 = fields
                .stream()
                .map(m -> m.split(","))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        System.out.println("after field level spliting size ... " + fields1.size());

        for (String j : fields1)
            System.out.println(j);
//     List<String> t=   fields1.stream()
//                .filter(l -> l.equals("excessorlessamount"))
//                        .findAny()
//                                .co
        int[] s1 = {1, 2, 3, 4, 5};


        System.out.println("excessor .." + fields1);

        System.out.println("distinct item even number:");

        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);
        String[] u = {"abd", "def"};
        int[] arr = new int[]{15, 1, 2, 3, 7, 9, 10};
        int startIndex = 1;
        int endIndex = 4;
        int sum = Arrays.stream(arr, startIndex, endIndex)
                .skip(1)
                .sum();
        System.out.println("sum=" + sum);

        //max
        Integer maxNumber = Stream.of(1, 20, 3, 4, 5, 6, 7, 8, 9)
                .max(Comparator.comparing(Integer::valueOf))
                .get();
        System.out.println("max=" + maxNumber);

        //min
        Integer minNumber = Stream.of(1, 20, 3, 4, 5, 6, 7, 8, 9)
                .min(Comparator.comparing(Integer::valueOf))
                .get();
        System.out.println("min=" + minNumber);

        //count
        long countNumber = Stream.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
                .count();
        System.out.println("count=" + countNumber);
    }

    //     String name=   () -> {return "Mario";}
    public static List<Apple> filterApplesByColor(List<Apple> inventory,
                                                  String color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getColor().equals(color)) {
                result.add(apple);
            }
        }
        return result;
    }
}

