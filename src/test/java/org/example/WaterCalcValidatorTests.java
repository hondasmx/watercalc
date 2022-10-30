package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WaterCalcValidatorTests {

    private final WaterCalc waterCalc = new WaterCalc();

    @Test
    public void nullLandscapeTest() {
        assertThatThrownBy(() -> waterCalc.calculateWaterAmount(null)).hasMessage("landscape should not be null");
    }

    @Test
    public void maxHeightValidatorTest() {
        assertThatThrownBy(() -> waterCalc.calculateWaterAmount(new int[]{32001})).hasMessage("height should be > 0 and <= 32000");
    }

    @Test
    public void minHeightValidatorTest() {
        assertThatThrownBy(() -> waterCalc.calculateWaterAmount(new int[]{1, 2, -1})).hasMessage("height should be > 0 and <= 32000");
    }

    @Test
    public void maxSizeTest() {
        assertThatThrownBy(() -> waterCalc.calculateWaterAmount(new int[32001])).hasMessage("landscape size should be <= 32000");
    }
}
