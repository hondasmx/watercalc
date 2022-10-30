package org.example;

import java.util.Arrays;

public class WaterCalcValidator {

    private static final int MAX_POSITION = 32000;
    private static final int MAX_HEIGHT = 32000;
    private static final int MIN_HEIGHT = 0;

    public void validate(int[] landScape) {
        if (landScape == null) {
            throw new IllegalArgumentException("landscape should not be null");
        }
        if (landScape.length > MAX_POSITION) {
            throw new IllegalArgumentException("landscape size should be <= " + MAX_POSITION);
        }
        if (Arrays.stream(landScape).anyMatch(el -> el > MAX_HEIGHT || el < MIN_HEIGHT)) {
            throw new IllegalArgumentException("height should be > 0 and <= 32000");
        }
    }
}
