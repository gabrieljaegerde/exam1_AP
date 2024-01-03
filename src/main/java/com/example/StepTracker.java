package com.example;

public class StepTracker {
    private int minSteps;
    private int totalSteps;
    private int activeDays;
    private int totalDays;

    // Constructor
    public StepTracker(int minSteps) {
        this.minSteps = minSteps;
        this.totalSteps = 0;
        this.activeDays = 0;
        this.totalDays = 0;
    }

    // Method to add daily steps
    public void addDailySteps(int steps) {
        totalDays++;
        totalSteps += steps;
        if (steps >= minSteps) {
            activeDays++;
        }
    }

    // Method to get the number of active days
    public int activeDays() {
        return activeDays;
    }

    // Method to calculate the average steps
    public double averageSteps() {
        if (totalDays == 0) {
            return 0.0;
        }
        return (double) totalSteps / totalDays;
    }
}
