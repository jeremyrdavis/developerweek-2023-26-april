package io.arrogantprogrammer.developerweek.domain;

public class CateringEvent {

    String mealPreference;

    public CateringEvent() {
    }

    public CateringEvent(MealPreference mealPreference) {
        this.mealPreference = mealPreference.toString();
    }

    public String getMealPreference() {
        return mealPreference;
    }
}
