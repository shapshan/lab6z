package kz.iitu.registration.service;

import kz.iitu.registration.model.EventInfo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final List<EventInfo> events = List.of(
            new EventInfo(1, "Web Design Workshop", "Room 301"),
            new EventInfo(2, "JavaScript Quiz", "Computer Lab 2"),
            new EventInfo(3, "IT Career Talk", "Main Hall")
    );

    public String getWelcomeMessage() {
        return "Welcome to the Event Registration API";
    }

    public List<EventInfo> getEvents() {
        return events;
    }

    public Optional<EventInfo> getEventById(long id) {
        return events.stream()
                .filter(event -> event.id() == id)
                .findFirst();
    }
}
