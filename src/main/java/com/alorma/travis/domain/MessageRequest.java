package com.alorma.travis.domain;

public class MessageRequest {
    private String to;
    private TravisPayload data;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public TravisPayload getData() {
        return data;
    }

    public void setData(TravisPayload data) {
        this.data = data;
    }
}
