package org.example;

public class WaterCalc {

    private final WaterCalcValidator validator = new WaterCalcValidator();

    public long calculateWaterAmount(int[] landscape) {
        validator.validate(landscape);

        var result = 0;
        var left = 0;
        var right = landscape.length - 1;
        var leftMax = 0;
        var rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, landscape[left]);
            rightMax = Math.max(rightMax, landscape[right]);

            if (leftMax < rightMax) {
                result += leftMax - landscape[left];
                left++;
            } else {
                result += rightMax - landscape[right];
                right--;
            }
        }

        return result;
    }
}