package com.alorma.travis.domain;

public class TravisConfig {
    private TravisNotifications notifications;

    public TravisNotifications getNotifications() {
        return notifications;
    }

    public void setNotifications(TravisNotifications notifications) {
        this.notifications = notifications;
    }
}
