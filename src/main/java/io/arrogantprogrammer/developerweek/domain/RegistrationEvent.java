package io.arrogantprogrammer.developerweek.domain;

public class RegistrationEvent{

    String attendeeInfo;

    public RegistrationEvent(AttendeeInfo attendeeInfo){
        this.attendeeInfo = attendeeInfo.toString();
    }

    public RegistrationEvent() {

    }

    public String getAttendeeInfo() {
        return attendeeInfo;
    }
}
