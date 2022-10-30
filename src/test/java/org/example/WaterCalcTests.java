package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class WaterCalcTests {

    private final WaterCalc waterCalc = new WaterCalc();

    private static Stream<Arguments> positiveTestData() {
        return Stream.of(
                Arguments.of(new int[]{5, 2, 3, 4, 5, 4, 0, 3, 1}, 9),
                Arguments.of(new int[]{3, 3, 3}, 0),
                Arguments.of(new int[]{}, 0),
                Arguments.of(new int[32000], 0),
                Arguments.of(new int[]{3, 2, 1}, 0),
                Arguments.of(new int[]{1, 2, 3}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("positiveTestData")
    void positiveTests(int[] landscape, long expectedResult) {
        Assertions.assertThat(waterCalc.calculateWaterAmount(landscape)).isEqualTo(expectedResult);
    }
}
