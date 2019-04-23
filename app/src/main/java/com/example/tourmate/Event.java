package com.example.tourmate;

import java.util.Date;

public class Event {
    private int eventId;
    private String eventName;
    private String location;
    private String destination;
    private Date createDate;
    private Date startDate;
    private float budget;

    public Event(int eventId, String eventName, String location, String destination, Date createDate, Date endDate, float budget) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.location = location;
        this.destination = destination;
        this.createDate = createDate;
        this.startDate = startDate;
        this.budget = budget;
    }

    public Event(String eventName, String location, String destination, Date createDate, Date startDate, float budget) {
        this.eventName = eventName;
        this.location = location;
        this.destination = destination;
        this.createDate = createDate;
        this.startDate = startDate;
        this.budget = budget;
    }

    public int getEventId() {
        return eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public String getLocation() {
        return location;
    }

    public String getDestination() {
        return destination;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public float getBudget() {
        return budget;
    }
}
