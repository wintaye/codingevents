package org.launchcode.codingevents.models;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Event extends AbstractEntity {

    @NotBlank(message="Name is required.")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters.")
    private String name;

    public Event(String name, EventCategory eventCategory) {
        this.name = name;
        this.eventCategory = eventCategory;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @Valid
    @NotNull
    private EventDetails eventDetails;

    @ManyToOne
    @NotNull(message = "Category is required")
    private EventCategory eventCategory;

    @ManyToMany
    private final List<Tag> tags = new ArrayList<>();

    public Event(){}

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public EventCategory getEventCategory() { return eventCategory; }

    public void setEventCategory(EventCategory eventCategory) { this.eventCategory = eventCategory; }

    @Override
    public String toString() { return name; }

    public EventDetails getEventDetails() { return eventDetails; }

    public void setEventDetails(EventDetails eventDetails) { this.eventDetails = eventDetails; }

    public List<Tag> getTags() { return tags; }

    public void addTag(Tag tag){ this.tags.add(tag); }
}
