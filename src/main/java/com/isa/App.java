package com.isa;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class App {

    public static void main(String[] args) {
        App app = new App();
        System.out.println(app.getLettersStats(app.getWords()));
    }

    public List<String> getWords() {
      return Stream.of("hello", "academy", "java", "junior").collect(Collectors.toList());
    }

    public Map<Character, Integer> getLettersStats(List<String> words) {
      return words.stream().map(String::chars).flatMap(IntStream::boxed).collect(toMap(k -> (char) k.intValue(), v -> 1, Integer::sum));
    }
}
