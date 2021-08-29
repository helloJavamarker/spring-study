package org.example.offer.mooc.other.pattern.listener;

public class SingleClickEventListener implements EventListener{
    @Override
    public void processEvent(Event event) {
        if ("singleclick".equals(event.getType())) {
            System.out.println("单击事件被触发");
        }
    }
}
