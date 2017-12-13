package com.rxx.jdk8new;

import org.junit.Test;

import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2017/12/11 15:08
 */
public class LambdaTest {

    @Test
    public void test01_01() throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World!");
            }
        }).start();
        TimeUnit.SECONDS.sleep(1000);
    }

    @Test
    public void test01_02() throws InterruptedException {
        new Thread(() -> System.out.println("Hello World!")).start();
        TimeUnit.SECONDS.sleep(1000);
    }

    @Test
    public void test02_01() {
        String[] datas = new String[]{"peng", "zhao", "li"};
        Arrays.sort(datas);
        Stream.of(datas).forEach(param -> System.out.println(param));
    }

    @Test
    public void test02_02() {
        String[] datas = new String[]{"peng", "zhao", "li"};
        Arrays.sort(datas, (v1, v2) -> Integer.compare(v1.length(), v2.length()));
        Stream.of(datas).forEach(param -> System.out.println(param));
    }

    @Test
    public void test03_01() throws InterruptedException {
        String[] datas = new String[]{"peng", "zhao", "li"};
        Comparator<String> comp = (v1, v2) -> Integer.compare(v1.length(), v2.length());
        Arrays.sort(datas, comp);
        Stream.of(datas).forEach(param -> {
            System.out.println(param);
        });
    }

    @Test
    public void test04_01() {
        String[] datas = new String[]{"peng", "zhao", "li"};
        Stream.of(datas).forEach(param -> {
            System.out.println(param);
        });
        Stream.of(datas).forEach(System.out::println);
    }

    @Test
    public void test04_02() {
        String[] datas = new String[]{"peng", "Zhao", "li"};
        Arrays.sort(datas, String::compareToIgnoreCase);
        Stream.of(datas).forEach(System.out::println);
    }

    @Test
    public void test05_01() {
        String str = "test";
        Stream.of(str).map(String::new).peek(System.out::println)
                .findFirst().ifPresent(System.out::print);
    }

    @Test
    public void test05_02() {
        String[] datas = new String[]{"peng", "Zhao", "li"};
        String[] copyDatas = Stream.of(datas).toArray(String[]::new);
        Stream.of(copyDatas).forEach(x -> System.out.println(x));
    }

    @Test
    public void test06_01() {
        // Java 8 以前
        final String[] datas1 = new String[]{"peng", "Zhao", "li"};
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(datas1);
            }
        }).start();

        // Java 8，没有 final 修饰，但是要求 datas2 是 effectively final
        String[] datas2 = new String[]{"peng", "Zhao", "li"};
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(datas2);
            }
        }).start();

        // Java 8 Lambda 表达式
        new Thread(() -> System.out.println(datas2)).start();
    }

    @Test
    public void test06_02() {
        String[] datas = new String[]{"peng", "Zhao", "li"};
        // race condition
//        datas = null;
        new Thread(() -> System.out.println(datas)).start();
    }

    @Test
    public void test07_01() {
        // 平方数
        System.out.println("===== 平方数 =====");
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        List<Integer> list01 = nums.stream().
                map(n -> n * n).
                collect(Collectors.toList());
        list01.stream().forEach(System.out::println);

        // 转换大写
        System.out.println("===== 转换大写 =====");
        List<String> wordList = Arrays.asList("peng", "Zhao", "li");
        List<String> list02 = wordList.stream().
                map(String::toUpperCase).
                collect(Collectors.toList());
        list02.stream().forEach(System.out::println);

        // 一对多
        System.out.println("===== 一对多 =====");
        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6));
        Stream<Integer> outputStream = inputStream.
                flatMap((childList) -> childList.stream());
        List<Integer> list03 = outputStream.collect(Collectors.toList());
        list03.stream().forEach(System.out::println);
    }

    @Test
    public void test07_02() {
        // 留下偶数
        System.out.println("===== 留下偶数 =====");
        Integer[] sixNums = {1, 2, 3, 4, 5, 6};
        Integer[] evens = Stream.of(sixNums).filter(n -> n % 2 == 0).toArray(Integer[]::new);
        Arrays.stream(evens).forEach(System.out::println);
        // 	把单词挑出来（这段代码首先把每行的单词用 flatMap 整理到新的 Stream，然后保留长度>2的）
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                new ByteArrayInputStream("A-BB-CCC-DDDD".getBytes())));
        List<String> output = reader.lines().flatMap(line -> Stream.of(line.split("-")))
                .filter(word -> word.length() > 2).collect(Collectors.toList());
        output.stream().forEach(System.out::println);
    }

    @Test
    public void test07_03() {
        Integer[] sixNums = {1, 2, 3, 4, 5, 6};
        // Java 8
        System.out.println("===== Java 8 =====");
        Arrays.stream(sixNums).filter(num -> num > 3).forEach(num -> System.out.println(num));
        // Pre-Java 8
        System.out.println("===== Pre-Java 8 =====");
        for (Integer num : sixNums) {
            if (num > 3) {
                System.out.println(num);
            }
        }

    }

    @Test
    public void test07_04() {
        String strA = " abcd ", strB = null;
        print(strA);
        //abcd\n
        //abcd\n
        print("");
        // \n
        // \n
        print(strB);
        System.out.println(getLength(strA));
        System.out.println(getLength(""));
        System.out.println(getLength(strB));
    }

    public static void print(String text) {
        // Java 8
        Optional.ofNullable(text).ifPresent(System.out::println);
        // Pre-Java 8
        if (text != null) {
            System.out.println(text);
        }
    }

    public static int getLength(String text) {
        // Java 8
        return Optional.ofNullable(text).map(String::length).orElse(-1);
        // Pre-Java 8
        // return if (text != null) ? text.length() : -1;
    }

    @Test
    public void test07_05() {
        Stream<Integer> integers01 = Arrays.asList(1, 2, 3, 4, 5, 6).stream();
        Stream<Integer> integers02 = Arrays.asList(1, 2, 3, 4, 5, 6).stream();
        Integer sum01 = integers01.reduce(0, (a, b) -> a + b);
        Integer sum02 = integers02.reduce(0, Integer::sum);
        System.out.println(sum01 + " " + sum02);
    }

    @Test
    public void tet07_06() {
        // 字符串连接，concat = "ABCD"
        String concat = Stream.of("A", "B", "C", "D").reduce("_", String::concat);
        System.out.println("String::concat：" + concat);
        // 求最小值，minValue = -3.0
        double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min);
        System.out.println("Double::min：" + minValue);
        // 求和，sumValue = 10, 有起始值
        int sumValue = Stream.of(1, 2, 3, 4).reduce(20, Integer::sum);
        System.out.println("Integer::sum：" + sumValue);
        // 求和，sumValue = 10, 无起始值
        sumValue = Stream.of(1, 2, 3, 4).reduce(Integer::sum).get();
        System.out.println("reduce(Integer::sum).get()：" + sumValue);
        // 过滤，字符串连接，concat = "ace"
        concat = Stream.of("a", "B", "c", "D", "e", "F").
                filter(x -> x.compareTo("Z") > 0).
                reduce("", String::concat);
        System.out.println("Integer::sum：" + concat);
    }

    @Test
    public void test07_07() {
        List<Person> persons = new ArrayList();
        for (int i = 1; i <= 10000; i++) {
            Person person = new Person(i, "name" + i);
            persons.add(person);
        }
        List<String> personList2 = persons.stream().
                map(Person::getName).limit(5).skip(3).collect(Collectors.toList());
        System.out.println(personList2);
    }

    private class Person {
        public int no;
        private String name;
        private int age;

        public Person(int no, String name) {
            this.no = no;
            this.name = name;
        }

        public Person(int no, String name, int age) {
            this.no = no;
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }

    @Test
    public void test07_08() {
        List<Person> persons = new ArrayList();
        for (int i = 5; i > 0; i--) {
            Person person = new Person(i, "name" + i);
            persons.add(person);
        }
        List<String> personList2 = persons.stream()
                .sorted(Comparator.comparing(Person::getName))
                .limit(2).map(Person::getName).collect(Collectors.toList());
        System.out.println(personList2);
    }

    @Test
    public void test07_09() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("E:\\公司文件\\笔记\\周分享\\test.txt"));
        int longest = br.lines().
                mapToInt(String::length).
                max().getAsInt();
        br.close();
        System.out.println(longest);
    }

    @Test
    public void test07_10() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("E:\\公司文件\\笔记\\周分享\\test.txt"));
        //找出全文的单词，转小写，并排序
        List<String> words = br.lines().
                flatMap(line -> Stream.of(line.split(" "))).
                filter(word -> word.length() > 0).
                map(String::toLowerCase).
                distinct().
                sorted().
                collect(Collectors.toList());
        br.close();
        System.out.println(words);
    }

    @Test
    public void test07_11() {
        List<Person> persons = new ArrayList();
        persons.add(new Person(1, "name" + 1, 10));
        persons.add(new Person(2, "name" + 2, 21));
        persons.add(new Person(3, "name" + 3, 34));
        persons.add(new Person(4, "name" + 4, 6));
        persons.add(new Person(5, "name" + 5, 55));

        boolean isAllAdult = persons.stream().
                allMatch(p -> p.getAge() > 18);
        System.out.println("All are adult? " + isAllAdult);

        boolean isThereAnyChild = persons.stream().
                anyMatch(p -> p.getAge() < 12);
        System.out.println("Any child? " + isThereAnyChild);
    }

    @Test
    public void test_07_12() {
        //生成10个随机数
        Random seed = new Random();
        Supplier<Integer> random = seed::nextInt;
        Stream.generate(random).limit(5).forEach(System.out::println);
        //Another way
        IntStream.generate(() -> (int) (System.nanoTime() % 100)).
                limit(5).forEach(System.out::println);
    }

    @Test
    public void test07_13() {
        Stream.generate(new PersonSupplier()).
                limit(5).
                forEach(p -> System.out.println(p.getName() + ", " + p.getAge()));
    }

    private class PersonSupplier implements Supplier<Person> {
        private int index = 0;
        private Random random = new Random();

        @Override
        public Person get() {
            return new Person(index++, "StormTestUser" + index, random.nextInt(100));
        }
    }

    @Test
    public void test07_14() {
        Stream.iterate(0, n -> n + 3).limit(5).forEach(x -> System.out.print(x + " "));
    }

    @Test
    public void test07_15() {
        //groupingBy/partitioningBy 按照年龄归组
        Map<Integer, List<Person>> personGroups = Stream.generate(new PersonSupplier()).
                limit(5).collect(Collectors.groupingBy(Person::getAge));
        Iterator it = personGroups.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, List<Person>> persons = (Map.Entry) it.next();
            System.out.println("Age " + persons.getKey() + " = " + persons.getValue().size());
        }


        //按照未成年人和成年人归组
        Map<Boolean, List<Person>> children = Stream.generate(new PersonSupplier()).
                limit(5).
                collect(Collectors.partitioningBy(p -> p.getAge() < 18));
        System.out.println("Children number: " + children.get(true).size());
        System.out.println("Adult number: " + children.get(false).size());
    }
}
