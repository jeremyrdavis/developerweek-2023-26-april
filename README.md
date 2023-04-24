# developerweek-ddd-04 Project

## Domains
- Attendees
- Sessions
- Catering
- Swag
- Partners

## Entities and Aggregates

### Entities

#### Attendee (Aggregate)
- persistent
- all interactions go through the attendee (aggregate)

#### Address
- persistent
- never called directly; only exists as part of an Attendee

### Value Objects

#### AttendeeInfo

- not persistent
- can represent a persistent object

### RegisterAttendeeCommand

- causes _something_ to happen
- not persistent
- should be idempotent

### Adapters

#### RESTAdapter

#### KafkaAdapter

### Services
- expose domain functionality to the rest of the application
- orchestrate functionality
- 
#### AttendeeService

### Domain Events
- events that the wider system cares about

#### RegistrationEvent

### Repositories
- handle persistence