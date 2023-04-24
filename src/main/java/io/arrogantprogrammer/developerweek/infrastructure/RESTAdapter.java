package io.arrogantprogrammer.developerweek.infrastructure;

import io.arrogantprogrammer.developerweek.domain.AttendeeService;
import io.arrogantprogrammer.developerweek.domain.RegisterAttendeeCommand;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.slf4j.Logger;
import org.slf4j.event.LoggingEvent;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.slf4j.LoggerFactory.getLogger;

@Path("/attendees")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RESTAdapter {

    private static final Logger LOGGER = getLogger(RESTAdapter.class);

    @Inject
    AttendeeService attendeeService;

    @POST
    public Response registerAttendee(RegisterAttendeeCommand registerAttendeeCommand) {

        LOGGER.debug("RegisterAttendeeCommand received: {}", registerAttendeeCommand);
        attendeeService.registerAttendee(registerAttendeeCommand);
        return Response.accepted().build();
    }
}
