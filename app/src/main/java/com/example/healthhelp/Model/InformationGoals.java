package com.example.healthhelp.Model;

public class InformationGoals {
    int weightTarget;
    int water;
    int steps;
    int calories;
    int sleep;

    public InformationGoals(int weightTarget, int water, int steps, int calories, int sleep) {
        this.weightTarget = weightTarget;
        this.water = water;
        this.steps = steps;
        this.calories = calories;
        this.sleep = sleep;
    }
    public InformationGoals(){}

    public int getWeightTarget() {
        return weightTarget;
    }

    public void setWeightTarget(int weightTarget) {
        this.weightTarget = weightTarget;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
    public int getSleep() {
        return sleep;
    }

    public void setSleep(int sleep) {
        this.sleep = sleep;
    }

}




