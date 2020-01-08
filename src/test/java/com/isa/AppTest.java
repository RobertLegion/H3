package com.isa;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

  private App app = new App();
  private static List<String> wordsExpected;
  private static Map<String, Long> mapExpected;

  @BeforeAll
  public static void setup() {
    wordsExpected = Arrays.asList("hello", "academy", "java", "junior");
    mapExpected = new HashMap<>();
    mapExpected.put("a", 4L);
    mapExpected.put("c", 1L);
    mapExpected.put("d", 1L);
    mapExpected.put("e", 2L);
    mapExpected.put("h", 1L);
    mapExpected.put("i", 1L);
    mapExpected.put("j", 2L);
    mapExpected.put("l", 2L);
    mapExpected.put("m", 1L);
    mapExpected.put("n", 1L);
    mapExpected.put("o", 2L);
    mapExpected.put("r", 1L);
    mapExpected.put("u", 1L);
    mapExpected.put("v", 1L);
    mapExpected.put("y", 1L);
  }

  @Test
  public void shouldAnswerWithTrue() {
    assertTrue(true);
  }

  @Test
  public void shouldAnswerWithProperList() {
    Assertions.assertThat(app.getWords()).hasSize(wordsExpected.size()).containsAll(wordsExpected);
  }

  @Test
  public void shouldAnswerWithProperMap() {
    Assertions.assertThat(app.getLettersStats(app.getWords())).hasSize(mapExpected.size()).matches(
        (Map<String, Long> t)
            -> t.entrySet().stream().allMatch((Map.Entry<String, Long> actualEntry)
            -> mapExpected.containsKey(actualEntry.getKey())
            && mapExpected.get(actualEntry.getKey()) == actualEntry.getValue()));
  }
}
