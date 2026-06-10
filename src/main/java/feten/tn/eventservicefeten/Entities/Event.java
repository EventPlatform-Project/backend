package feten.tn.eventservicefeten.Entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String category;
    private Integer maxPlaces;
    private Integer availablePlaces;
    private Long organizerId;
    private String status = "ACTIVE";

    //Un événement peut avoir plusieurs créneaux
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Schedule> schedules;

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public Integer getMaxPlaces() { return maxPlaces; }
    public void setMaxPlaces(Integer maxPlaces) { this.maxPlaces = maxPlaces; }

    public Integer getAvailablePlaces() { return availablePlaces; }
    public void setAvailablePlaces(Integer availablePlaces) { this.availablePlaces = availablePlaces; }

    public Long getOrganizerId() { return organizerId; }
    public void setOrganizerId(Long organizerId) { this.organizerId = organizerId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public List<Schedule> getSchedules() { return schedules; }
    public void setSchedules(List<Schedule> schedules) { this.schedules = schedules; }
}