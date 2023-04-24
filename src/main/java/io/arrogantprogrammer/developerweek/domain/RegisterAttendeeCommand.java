package io.arrogantprogrammer.developerweek.domain;

import java.net.URL;

public record RegisterAttendeeCommand(
        String email,
        String firstName,
        String lastName,
        MealPreference mealPreference,
        boolean student,
        boolean impactedByLayoffs,
        TShirtSize tShirtSize,
        String streetAddress,
        String streetAddress2,
        String city,
        String stateOrProvince,
        String postCode,
        String countryCode,
        URL referringUrl
) {
}
