package com.manindra.corejava;

public class NotificationFactory {

    public Notification createNoification(String channel){
        if (channel==null || channel.isEmpty())
            return null;
        switch (channel){
            case "SMS" :
                return new SMSNotification();
            case "EMAIL" :
                return new EmailNotification();
            case "PUSH" :
                return new PushNotification();
            default:
                throw new IllegalArgumentException("Unknown Channel"+channel);
        }
    }
}
