package io.lcalmsky.junit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

public class AfterTests {

    @AfterAll
    public static void done() {
        // 모든 테스트가 끝난 후 한 번 실행됨
    }

    @AfterEach
    public void teardown() {
        // 테스트 후 매 번 실행됨
    }
}
