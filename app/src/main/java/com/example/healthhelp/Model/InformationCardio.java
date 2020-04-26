package com.example.healthhelp.Model;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class InformationCardio {
    String cardioExerciseName;
    String dateCardioCompleted;
    int cardioDuration;

    public InformationCardio(String cardioExerciseName, int cardioDuration, String dateCardioCompleted) {
        this.cardioExerciseName = cardioExerciseName;
        this.cardioDuration = cardioDuration;
    }
    public InformationCardio(){}

    public String getCardioExerciseName() {
        return cardioExerciseName;
    }

    public void setCardioExerciseName(String cardioExerciseName) {
        this.cardioExerciseName = cardioExerciseName;
    }

    public int getCardioDuration() {
        return cardioDuration;
    }

    public void setCardioDuration(int cardioDuration) {
        this.cardioDuration = cardioDuration;
    }

    public String getDateCardioCompleted() {
        return dateCardioCompleted;
    }

    public void setDateCardioCompleted(String dateCardioCompleted) {
        this.dateCardioCompleted = dateCardioCompleted;
    }



}
