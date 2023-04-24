package io.arrogantprogrammer.developerweek.domain;

import java.util.List;
import java.util.Map;

public record RegistrationResult(Attendee attendee,
                                 RegistrationEvent registrationEvent,
                                 CateringEvent cateringEvent,
                                 SwagEvent swagEvent) {


}
