package be.ordina.threesixty.timeline.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

/**
 * Created by stevedezitter on 22/04/15.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "timelineEventType", visible=true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = FollowUpMeeting.class, name = "FOLLOW_UP_MEETING"),
        @JsonSubTypes.Type(value = Course.class, name = "COURSE"),
        @JsonSubTypes.Type(value = Satisfaction.class, name = "SATISFACTION"),
        @JsonSubTypes.Type(value = Conference.class, name = "CONFERENCE"),
        @JsonSubTypes.Type(value = Training.class, name = "TRAINING"),
        @JsonSubTypes.Type(value = Workshop.class, name = "WORKSHOP")
})
@Document
public class TimelineEvent {

    @Id
    private String id;

    //Id of the owning person of the event
    private String owner;

    private LocalDate eventDate;

    private String description;

    private TimelineEventType timelineEventType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TimelineEventType getTimelineEventType() {
        return timelineEventType;
    }

    public void setTimelineEventType(TimelineEventType timelineEventType) {
        this.timelineEventType = timelineEventType;
    }
}
