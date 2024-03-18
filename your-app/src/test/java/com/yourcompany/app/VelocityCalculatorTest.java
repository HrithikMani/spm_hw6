package com.yourcompany.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VelocityCalculatorTest {

    @Test
    public void testCalculateAverageVelocity_WithPositiveIntegers() {
        // Normal case with positive integers
        int[] sprintPoints = {24, 30, 28, 32, 26};
        double actual = VelocityCalculator.calculateAverageVelocity(sprintPoints);
        double expected = 28.0;
        assertEquals(expected, actual, 0.001, "The average velocity should be 28.0");
    }

    @Test
    public void testCalculateAverageVelocity_WithEmptyArray() {
        // Empty array
        int[] sprintPoints = {};
        double actual = VelocityCalculator.calculateAverageVelocity(sprintPoints);
        assertEquals(0.0, actual, 0.001, "Average velocity with empty array should be 0.0");
    }

    @Test
    public void testCalculateAverageVelocity_WithNullArray() {
        // Null array
        double actual = VelocityCalculator.calculateAverageVelocity(null);
        assertEquals(0.0, actual, 0.001, "Average velocity with null input should be 0.0");
    }

    @Test
    public void testCalculateAverageVelocity_WithSingleElement() {
        // Array with a single element
        int[] sprintPoints = {29};
        double actual = VelocityCalculator.calculateAverageVelocity(sprintPoints);
        assertEquals(29.0, actual, 0.001, "Average velocity with single element should be 29.0");
    }

    @Test
    public void testCalculateAverageVelocity_WithNegativeAndPositiveIntegers() {
        // Array with negative and positive integers
        int[] sprintPoints = {20, -5, 25, 10};
        double actual = VelocityCalculator.calculateAverageVelocity(sprintPoints);
        assertEquals(12.5, actual, 0.001, "Average velocity with negative and positive integers should be 12.5");
    }
}

class VelocityCalculator {
 
    public static double calculateAverageVelocity(int[] sprintPoints) {
        if (sprintPoints == null || sprintPoints.length == 0) {
            return 0; // Return 0 if the array is null or empty to avoid division by zero
        }

        double sum = 0;
        for (int points : sprintPoints) {
            sum += points; // Summing all the sprint points
        }
        return sum / sprintPoints.length; // Calculating the average
    }
}
