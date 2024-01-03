package com.example;

import java.util.List;

public class FuelDepot {
    /** The robot used to move the filling mechanism */
    private FuelRobot filler;

    /** The list of fuel tanks */
    private List<FuelTank> tanks;

    /**
     * Constructs a FuelDepot object.
     *
     * @param filler The robot used to move the filling mechanism.
     * @param tanks  The list of fuel tanks.
     */
    public FuelDepot(FuelRobot filler, List<FuelTank> tanks) {
        this.filler = filler;
        this.tanks = tanks;
    }

    /**
     * Determines and returns the index of the next tank to be filled.
     *
     * @param threshold fuel tanks with a fuel level ≤ threshold may be filled.
     * @return index of the location of the next tank to be filled.
     */
    public int nextTankToFill(int threshold) {
        int minLevelIndex = -1;
        int minLevel = Integer.MAX_VALUE;

        for (int i = 0; i < tanks.size(); i++) {
            int currentLevel = tanks.get(i).getFuelLevel();
            if (currentLevel <= threshold && currentLevel < minLevel) {
                minLevel = currentLevel;
                minLevelIndex = i;
            }
        }

        if (minLevelIndex == -1) {
            // No tanks with a fuel level less than or equal to the threshold
            return filler.getCurrentIndex();
        } else {
            return minLevelIndex;
        }
    }

    /**
     * Moves the robot to location locIndex.
     *
     * @param locIndex the index of the location of the tank to move to.
     */
    public void moveToLocation(int locIndex) {
        int currentLoc = filler.getCurrentIndex();
        boolean isRight = filler.isFacingRight();

        if (locIndex > currentLoc && !isRight) {
            // If the robot is not facing right and needs to move right
            filler.changeDirection();
        } else if (locIndex < currentLoc && isRight) {
            // If the robot is facing right but needs to move left
            filler.changeDirection();
        }

        // Move the robot to the desired location
        filler.moveForward(Math.abs(locIndex - currentLoc));
    }

}


