package feten.tn.eventservicefeten.Services;

import feten.tn.eventservicefeten.Entities.Event;
import feten.tn.eventservicefeten.Entities.Schedule;
import feten.tn.eventservicefeten.Repositories.EventRepository;
import feten.tn.eventservicefeten.Repositories.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    public Event createEvent(Event event) {
        event.setAvailablePlaces(event.getMaxPlaces());
        return eventRepository.save(event);
    }

    public Schedule addSchedule(Long eventId, Schedule schedule) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));
        schedule.setEvent(event);
        return scheduleRepository.save(schedule);
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}