package org.example.offer.mooc.other.pattern.listener;

public class DoubleClickEventListener implements EventListener{
    @Override
    public void processEvent(Event event) {
        if ("doubleclick".equals(event.getType())) {
            System.out.println("双击事件被触发");
        }
    }
}
