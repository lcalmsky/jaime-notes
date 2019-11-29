package io.lcalmsky.junit;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFactoryTests {

    private List<String> in = new ArrayList<>(Arrays.asList("안녕", "응", "아니"));
    private List<String> out = new ArrayList<>(Arrays.asList("Hello", "Yes", "No"));

    @TestFactory
    public Stream<DynamicTest> translateDynamicTestsFromStream() {
        return in
                .stream()
                .map(word -> DynamicTest.dynamicTest("Test translate " + word, () -> {
                    int id = in.indexOf(word);
                    assertEquals(out.get(id), translate(word));
                }));
    }

    private String translate(String word) {
        if ("안녕".equalsIgnoreCase(word)) {
            return "Hello";
        } else if ("응".equalsIgnoreCase(word)) {
            return "Yes";
        } else if ("아니".equalsIgnoreCase(word)) {
            return "No";
        }
        return "Error";
    }
}
