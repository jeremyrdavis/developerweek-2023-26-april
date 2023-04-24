package io.arrogantprogrammer.developerweek.domain;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.slf4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import static org.slf4j.LoggerFactory.getLogger;

@ApplicationScoped
public class AttendeeService {

    private static final Logger LOGGER = getLogger(AttendeeService.class);

    @Inject
    AttendeeRepository attendeeRepository;

//    @Channel("swag")
//    Emitter<SwagEvent> swagEventEmitter;
//
//    @Channel("catering")
//    Emitter<CateringEvent> cateringEventEmitter;
//
//    @Channel("registration")
//    Emitter<RegistrationEvent> registrationEventEmitter;

    @Transactional
    public void registerAttendee(RegisterAttendeeCommand registerAttendeeCommand) {
        LOGGER.debug("RegisterAttendeeCommand received: {}", registerAttendeeCommand);

        RegistrationResult registrationResult = Attendee.registerAttendee(registerAttendeeCommand);
        Attendee attendee = registrationResult.attendee();
        attendeeRepository.persist(attendee);
//        registrationEventEmitter.send(registrationResult.registrationEvent());
//        cateringEventEmitter.send(registrationResult.cateringEvent());
//        registrationEventEmitter.send(registrationResult.registrationEvent());
    }
}
