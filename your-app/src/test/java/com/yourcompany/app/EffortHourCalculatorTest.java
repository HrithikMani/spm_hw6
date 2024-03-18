package com.yourcompany.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EffortHourCalculatorTest {

    @Test
    public void testCalculateTeamEffortHourCapacity_StandardInputs() {
        int sprintDays = 10;
        int[] hoursPerDay = {8, 8, 8, 8, 8}; // Standard 8-hour days for each team member
        int hoursForCeremonies = 10; // 10 total hours for ceremonies during the sprint
        int expected = 390; // Expected effort-hour capacity
        int actual = EffortHourCalculator.calculateTeamEffortHourCapacity(sprintDays, hoursPerDay, hoursForCeremonies);
        assertEquals(expected, actual, "Effort-hour capacity should be correctly calculated for standard inputs.");
    }

    @Test
    public void testCalculateTeamEffortHourCapacity_MemberWithZeroHours() {
        int sprintDays = 10;
        int[] hoursPerDay = {8, 8, 0, 8, 8}; // One team member with 0 hours per day
        int hoursForCeremonies = 10;
        int expected = 310; // Expected effort-hour capacity adjusted for zero hours of one member
        int actual = EffortHourCalculator.calculateTeamEffortHourCapacity(sprintDays, hoursPerDay, hoursForCeremonies);
        assertEquals(expected, actual, "Effort-hour capacity should be adjusted for a member with zero hours.");
    }

    @Test
    public void testCalculateTeamEffortHourCapacity_ExcessiveCeremonyHours() {
        int sprintDays = 10;
        int[] hoursPerDay = {8, 8, 8, 8, 8};
        int hoursForCeremonies = 80; // Unreasonably high hours for ceremonies
        int expected = 0; // Expected effort-hour capacity should be 0 due to excessive ceremony hours
        int actual = EffortHourCalculator.calculateTeamEffortHourCapacity(sprintDays, hoursPerDay, hoursForCeremonies);
        assertEquals(expected, actual, "Effort-hour capacity should be 0 due to excessive ceremony hours.");
    }

    @Test
    public void testCalculateTeamEffortHourCapacity_SingleTeamMember() {
        int sprintDays = 10;
        int[] hoursPerDay = {8}; // Single team member
        int hoursForCeremonies = 10;
        int expected = 70; // Expected effort-hour capacity for a single team member
        int actual = EffortHourCalculator.calculateTeamEffortHourCapacity(sprintDays, hoursPerDay, hoursForCeremonies);
        assertEquals(expected, actual, "Effort-hour capacity should be correctly calculated for a single team member.");
    }
}

class EffortHourCalculator {
    
    public static int calculateTeamEffortHourCapacity(int sprintDays, int[] hoursPerDay, int hoursForCeremonies) {
        if (sprintDays <= 0 || hoursPerDay == null || hoursPerDay.length == 0) {
            throw new IllegalArgumentException("Invalid input for sprint days or hours per day.");
        }
        
        if (hoursForCeremonies < 0 || hoursForCeremonies > sprintDays * hoursPerDay[0]) {
            throw new IllegalArgumentException("Invalid input for hours for ceremonies.");
        }

        int totalCapacity = 0;
        for (int dailyHours : hoursPerDay) {
            if (dailyHours < 0) {
                throw new IllegalArgumentException("Daily hours cannot be negative.");
            }
            int effectiveDailyHours = Math.max(dailyHours - (hoursForCeremonies / sprintDays), 0);
            totalCapacity += effectiveDailyHours * sprintDays;
        }
        return totalCapacity;
    }
}
