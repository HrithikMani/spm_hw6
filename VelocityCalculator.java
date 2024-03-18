public class VelocityCalculator {
    public static void main(String[] args) {
        int[] sprintPoints = {24, 30, 28, 32, 26}; // Sample data for points completed per sprint
        System.out.println("Average Velocity: " + calculateAverageVelocity(sprintPoints) + " points per sprint");
    }

    private static double calculateAverageVelocity(int[] sprintPoints) {
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
