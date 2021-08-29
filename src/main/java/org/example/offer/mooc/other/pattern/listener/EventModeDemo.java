package org.example.offer.mooc.other.pattern.listener;

public class EventModeDemo {

    // 监听自己感兴趣的时间,一旦事件发生,便做出响应
    //涉及三个对象:事件源,事件监听器,事件对象

    public static void main(String[] args) {
        EventSource eventSource = new EventSource();
        SingleClickEventListener singleClickEventListener = new SingleClickEventListener();
        DoubleClickEventListener doubleClickEventListener = new DoubleClickEventListener();

        Event event = new Event("doubleclick");
        event.setType("doubleclick");
        //向所有监听者发布消息,只有感兴趣的做出响应=====区别观察者模式
        eventSource.register(singleClickEventListener);
        eventSource.register(doubleClickEventListener);
        eventSource.publishEvent(event);
    }

    // spring eventListener用法  TODO

}
