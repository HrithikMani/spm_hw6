import static org.junit.Assert.*;
import org.junit.Test;

public class VelocityCalculatorTest {

    @Test
    public void testCalculateAverageVelocity_WithPositiveIntegers() {
        // Normal case with positive integers
        int[] sprintPoints = {24, 30, 28, 32, 26};
        assertEquals("Average velocity with positive integers", 28.0, VelocityCalculator.calculateAverageVelocity(sprintPoints), 0.001);
    }

    @Test
    public void testCalculateAverageVelocity_WithEmptyArray() {
        // Empty array
        int[] sprintPoints = {};
        assertEquals("Average velocity with empty array", 0.0, VelocityCalculator.calculateAverageVelocity(sprintPoints), 0.001);
    }

    @Test
    public void testCalculateAverageVelocity_WithNullArray() {
        // Null array
        assertEquals("Average velocity with null input", 0.0, VelocityCalculator.calculateAverageVelocity(null), 0.001);
    }

    @Test
    public void testCalculateAverageVelocity_WithSingleElement() {
        // Array with a single element
        int[] sprintPoints = {29};
        assertEquals("Average velocity with single element", 29.0, VelocityCalculator.calculateAverageVelocity(sprintPoints), 0.001);
    }

    @Test
    public void testCalculateAverageVelocity_WithNegativeAndPositiveIntegers() {
        // Array with negative and positive integers
        int[] sprintPoints = {20, -5, 25, 10};
        assertEquals("Average velocity with negative and positive integers", 12.5, VelocityCalculator.calculateAverageVelocity(sprintPoints), 0.001);
    }
}
