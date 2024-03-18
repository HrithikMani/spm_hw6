public class VelocityCalculatorAcceptanceTest {

    public static void main(String[] args) {
        System.out.println("Acceptance Test for Feature A: Calculate a Sprint Team's Velocity");

        // Happy Path
        testCalculateAverageVelocityWithValidData();

        // Unhappy Path - No Data
        testCalculateAverageVelocityWithNoData();

        // Unhappy Path - Invalid Data (Negative Values)
        testCalculateAverageVelocityWithInvalidData();
    }

    private static void testCalculateAverageVelocityWithValidData() {
        int[] sprintPoints = {24, 30, 28, 32, 26}; // Sample data for points completed per sprint
        double averageVelocity = calculateAverageVelocity(sprintPoints);
        System.out.println("Happy Path Test: Expected average velocity is 28.0, Actual average velocity is " + averageVelocity);
    }

    private static void testCalculateAverageVelocityWithNoData() {
        int[] sprintPoints = {}; // No data
        double averageVelocity = calculateAverageVelocity(sprintPoints);
        String result = averageVelocity == 0 ? "Passed" : "Failed";
        System.out.println("Unhappy Path Test (No Data): Test " + result);
    }

    private static void testCalculateAverageVelocityWithInvalidData() {
        int[] sprintPoints = {24, -30, 28}; // Contains invalid (negative) data
        try {
            double averageVelocity = calculateAverageVelocity(sprintPoints);
            System.out.println("Unhappy Path Test (Invalid Data): Unexpected result, test Failed");
        } catch (IllegalArgumentException e) {
            System.out.println("Unhappy Path Test (Invalid Data): Test Passed (caught expected exception)");
        }
    }

    private static double calculateAverageVelocity(int[] sprintPoints) {
        if (sprintPoints == null || sprintPoints.length == 0) {
            return 0; // Return 0 if the array is null or empty to avoid division by zero
        }

        double sum = 0;
        for (int points : sprintPoints) {
            if (points < 0) {
                throw new IllegalArgumentException("Sprint points cannot be negative.");
            }
            sum += points; // Summing all the sprint points
        }
        return sum / sprintPoints.length; // Calculating the average
    }
}
