package com.alorma.travis.domain;

public class TravisEvent {
    private TravisPayload payload;

    public TravisPayload getPayload() {
        return payload;
    }

    public void setPayload(TravisPayload payload) {
        this.payload = payload;
    }
}
