package io.lcalmsky.junit;

import org.junit.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionTests {
    @Test
    public void originalExpression() {
        assertTrue(Stream.of(1, 2, 3)
                .mapToInt(i -> i)
                .sum() > 5);

    }

    @Test
    public void booleanSupplier() {
        assertTrue(() -> Stream.of(1, 2, 3)
                .mapToInt(i -> i)
                .sum() > 5
        );
    }

    @Test
    public void lambdaExpressions() {
        assertTrue(
                () -> Stream.of(1, 2, 3)
                        .mapToInt(i -> i)
                        .sum() > 5,
                () -> "sum should be greater than 5");
    }

    @Test
    public void groupAssertions() {
        int[] numbers = {0, 1, 2, 3, 4};
        assertAll("numbers",
                () -> assertEquals(numbers[0], 0),
                () -> assertEquals(numbers[3], 3),
                () -> assertEquals(numbers[4], 4));
    }
}
