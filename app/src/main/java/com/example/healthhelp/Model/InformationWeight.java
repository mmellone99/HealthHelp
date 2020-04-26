package com.example.healthhelp.Model;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class InformationWeight {
    String exerciseWeightName;
    String weightType;
    int weightLifted;
    int numberSets;
    int numberReps;

    public InformationWeight(String exerciseWeightName, String weightType, int weightLifted, int numberSets, int numberReps) {
        this.exerciseWeightName = exerciseWeightName;
        this.weightType = weightType;
        this.weightLifted = weightLifted;
        this.numberSets = numberSets;
        this.numberReps = numberReps;
    }
    public InformationWeight(){}

    public String getExerciseWeightName() {
        return exerciseWeightName;
    }

    public void setExerciseWeightName(String exerciseWeightName) {
        this.exerciseWeightName = exerciseWeightName;
    }

    public String getWeightType() {
        return weightType;
    }

    public void setWeightType(String weightType) {
        this.weightType = weightType;
    }

    public int getWeightLifted() {
        return weightLifted;
    }

    public void setWeightLifted(int weightLifted) {
        this.weightLifted = weightLifted;
    }

    public int getNumberSets() {
        return numberSets;
    }

    public void setNumberSets(int numberSets) {
        this.numberSets = numberSets;
    }

    public int getNumberReps() {
        return numberReps;
    }

    public void setNumberReps(int numberReps) {
        this.numberReps = numberReps;
    }



}
