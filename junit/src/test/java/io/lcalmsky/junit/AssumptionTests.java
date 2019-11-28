package io.lcalmsky.junit;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.*;

public class AssumptionTests {
    @Test
    public void trueAssumption() {
        assumeTrue(5 > 1);
//        assumeTrue(() -> 5 > 1); // 역시 람다 형태(BooleanSupplier)를 제공
        assertEquals(5 + 2, 7);
    }

    @Test
    public void falseAssumption() {
        assumeFalse(5 < 1);
//        assumeFalse(() -> 5 < 1);
        assertEquals(5 + 2, 7);
    }

    @Test
    public void assumingThatTest() {
        assumingThat(
                () -> 5 > 1, // 참이면
                () -> assertEquals(5 + 2, 7) // 실행됨
        );
//        assumingThat(
//                5 > 1,
//                () -> assertEquals(5 + 2, 7)
//        ); // assumption 부분에 바로 boolean 타입 사용 가능
    }
}
