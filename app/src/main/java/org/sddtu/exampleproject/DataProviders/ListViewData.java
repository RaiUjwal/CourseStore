package org.sddtu.exampleproject.DataProviders;

/**
 * Created by mohitkumar on 15/01/17.
 */

public class ListViewData {

    String event,time,venue;

    public ListViewData(String event,String time,String venue) {
        this.event = event;
        this.time = time;
        this.venue = venue;
    }

    public String getEvent() {
        return event;
    }

    public String getTime() {
        return time;
    }

    public String getVenue() {
        return venue;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }
}
