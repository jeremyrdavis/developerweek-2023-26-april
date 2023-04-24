package io.arrogantprogrammer.developerweek.domain;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.slf4j.Logger;

import javax.enterprise.context.ApplicationScoped;

import static org.slf4j.LoggerFactory.getLogger;

@ApplicationScoped
public class AttendeeRepository implements PanacheRepository<Attendee> {

    private static final Logger LOGGER = getLogger(AttendeeRepository.class);

    @Override
    public void persist(Attendee attendee) {
        LOGGER.debug("persisting: {}", attendee);
        attendee.address.persist();
        attendee.persist();
    }
}
