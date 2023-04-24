package io.arrogantprogrammer.developerweek.infrastructure;

import io.arrogantprogrammer.developerweek.domain.AttendeeService;
import io.arrogantprogrammer.developerweek.domain.RegisterAttendeeCommand;
import io.smallrye.common.annotation.Blocking;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.slf4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import static org.slf4j.LoggerFactory.getLogger;

@ApplicationScoped
public class KafkaAdapter {

    private static final Logger LOGGER = getLogger(KafkaAdapter.class);

    @Inject
    AttendeeService attendeeService;

    @Incoming("reg")
    @Blocking
    public void onRegisterAttendeeCommand(RegisterAttendeeCommand registerAttendeeCommand) {
        LOGGER.debug("RegisterAttendeeCommand received: {}", registerAttendeeCommand);
        attendeeService.registerAttendee(registerAttendeeCommand);
    }
}
