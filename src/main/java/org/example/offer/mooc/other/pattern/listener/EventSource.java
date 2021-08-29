package org.example.offer.mooc.other.pattern.listener;

import java.util.ArrayList;
import java.util.List;

public class EventSource {
    private List<EventListener> listeners = new ArrayList<>();

    public void register(EventListener eventListener) {
        listeners.add(eventListener);
    }
    public void publishEvent(Event event) {
        for (EventListener listener : listeners) {
            listener.processEvent(event);
        }
    }
}
