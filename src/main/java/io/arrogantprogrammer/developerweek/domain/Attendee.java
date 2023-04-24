package io.arrogantprogrammer.developerweek.domain;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

@Entity
public class Attendee extends PanacheEntity {

    String email;

    String firstName;

    String lastName;

    TShirtSize tShirtSize;

    MealPreference mealPreference;

    boolean student;

    boolean impactedByRecentLayoffs;

    @OneToOne
    @JoinColumn(name = "address_id")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    Address address;

    public static RegistrationResult registerAttendee(RegisterAttendeeCommand registerAttendeeCommand) {
        Attendee attendee = new Attendee();
        attendee.email = registerAttendeeCommand.email();
        attendee.firstName =registerAttendeeCommand.firstName();
        attendee.lastName = registerAttendeeCommand.lastName();
        attendee.tShirtSize = registerAttendeeCommand.tShirtSize();
        attendee.mealPreference = registerAttendeeCommand.mealPreference();
        attendee.address = new Address();
        attendee.address.streetAddress = registerAttendeeCommand.streetAddress();
        attendee.address.streetAdress2 = registerAttendeeCommand.streetAddress2();
        attendee.address.city = registerAttendeeCommand.city();
        attendee.address.stateOrProvince = registerAttendeeCommand.stateOrProvince();
        attendee.address.postCode = registerAttendeeCommand.postCode();
        attendee.address.countryCode = registerAttendeeCommand.countryCode();

        RegistrationEvent registrationEvent = new RegistrationEvent(attendee.getAttendeeInfo());
        SwagEvent swagEvent = new SwagEvent(attendee.tShirtSize);
        CateringEvent cateringEvent = new CateringEvent(attendee.mealPreference);
        return new RegistrationResult(attendee, registrationEvent, cateringEvent, swagEvent);
    }

    public AttendeeInfo getAttendeeInfo() {
        return new AttendeeInfo(
                this.email,
                this.firstName,
                this.lastName
        );
    }

    public void updateAddress(final Address updatedAddress) {

        this.address.city = updatedAddress.city;
        this.address.streetAddress = updatedAddress.streetAddress;
        this.address.streetAdress2 = updatedAddress.streetAdress2;
        this.address.postCode = updatedAddress.postCode;
        this.address.countryCode = updatedAddress.countryCode;
    }
    public Double calculatePriceforAttendee(final Double basePrice) {
        if (student) {
            return (basePrice - (basePrice * 0.10));
        } else if (impactedByRecentLayoffs) {
            return (basePrice - (basePrice * 0.50 ));
        } else {
            return basePrice;
        }
    }

    public Attendee() {
    }

    @Override
    public String toString() {
        return "Attendee{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", tShirtSize=" + tShirtSize +
                ", mealPreference=" + mealPreference +
                ", student=" + student +
                ", impactedByRecentLayoffs=" + impactedByRecentLayoffs +
                ", address=" + address +
                ", id=" + id +
                '}';
    }
}
