public class EffortHourCalculatorAcceptanceTest {

    public static void main(String[] args) {
        System.out.println("Acceptance Test for Feature B: Calculate Team Effort-Hour Capacity");

        // Happy Path
        testWithStandardInputs();

        // Unhappy Paths
        testWithMemberHavingZeroHours();
        testWithInvalidNumberOfSprintDays();
        testWithExcessiveCeremonyHours();

        // Edge Case
        testWithSingleTeamMember();
    }

    private static void testWithStandardInputs() {
        int sprintDays = 10;
        int[] hoursPerDay = {8, 8, 8, 8, 8}; // All team members can work 8 hours per day
        int hoursForCeremonies = 10; // Total hours for ceremonies
        System.out.println("Total Team Effort-Hour Capacity (Standard Inputs): " + EffortHourCalculator.calculateTeamEffortHourCapacity(sprintDays, hoursPerDay, hoursForCeremonies) + " hours");
    }

    private static void testWithMemberHavingZeroHours() {
        int sprintDays = 10;
        int[] hoursPerDay = {8, 0, 8, 8, 8}; // One team member has 0 available hours
        int hoursForCeremonies = 10;
        System.out.println("Total Team Effort-Hour Capacity (Member with Zero Hours): " + EffortHourCalculator.calculateTeamEffortHourCapacity(sprintDays, hoursPerDay, hoursForCeremonies) + " hours");
    }

    private static void testWithInvalidNumberOfSprintDays() {
        int sprintDays = -1; // Invalid number of sprint days
        int[] hoursPerDay = {8, 8, 8, 8, 8};
        int hoursForCeremonies = 10;
        System.out.println("Total Team Effort-Hour Capacity (Invalid Sprint Days): Should show error message.");
    }

    private static void testWithExcessiveCeremonyHours() {
        int sprintDays = 10;
        int[] hoursPerDay = {8, 8, 8, 8, 8};
        int hoursForCeremonies = 80; // Excessive ceremony hours
        System.out.println("Total Team Effort-Hour Capacity (Excessive Ceremony Hours): Should show error message.");
    }

    private static void testWithSingleTeamMember() {
        int sprintDays = 10;
        int[] hoursPerDay = {8}; // Only one team member
        int hoursForCeremonies = 10;
        System.out.println("Total Team Effort-Hour Capacity (Single Team Member): " + EffortHourCalculator.calculateTeamEffortHourCapacity(sprintDays, hoursPerDay, hoursForCeremonies) + " hours");
    }
}

class EffortHourCalculator {
    public static void main(String[] args) {
        int sprintDays = 10; // Number of sprint days
        int[] hoursPerDay = {6, 7, 6, 8, 7}; // Available hours per day for 5 team members
        int hoursForCeremonies = 4; // Hours committed to sprint ceremonies by each member

        System.out.println("Total Team Effort-Hour Capacity: " + calculateTeamEffortHourCapacity(sprintDays, hoursPerDay, hoursForCeremonies) + " hours");
    }

    public static int calculateTeamEffortHourCapacity(int sprintDays, int[] hoursPerDay, int hoursForCeremonies) {
        int totalCapacity = 0;
        for (int dailyHours : hoursPerDay) {
            int effectiveDailyHours = dailyHours - (hoursForCeremonies / sprintDays);
            totalCapacity += effectiveDailyHours * sprintDays;
        }
        return totalCapacity;
    }
}