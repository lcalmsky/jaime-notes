package io.lcalmsky.junit;

import lombok.extern.java.Log;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

@Log
public class BeforeTests {
    @BeforeAll
    public static void setup() {
        log.info("@BeforeAll");
    }

    @BeforeEach
    public void init() {
        log.info("@BeforeEach");
    }
}