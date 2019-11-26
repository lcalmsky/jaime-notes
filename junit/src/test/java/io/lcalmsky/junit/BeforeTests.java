package io.lcalmsky.junit;

import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Log
public class BeforeTests {
    @BeforeAll
    public void setup() {
        log.info("@BeforeAll");
    }

    @BeforeEach
    public void init() {
        log.info("@BeforeEach");
    }

    @Test
    public void one() {
        log.info("one: executed");
        assertTrue(true);
    }

    @Test
    public void two() {
        log.info("two: executed");
        assertTrue(true);
    }
}