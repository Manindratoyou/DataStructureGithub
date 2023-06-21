package com.manindra.corejava;

public class NotificationService {

    public static void main(String[] args) {

        NotificationFactory notificationFactory=new NotificationFactory();
        Notification notification=notificationFactory.createNoification("EMAIL");
        notification.notifyUser();

    }
}
