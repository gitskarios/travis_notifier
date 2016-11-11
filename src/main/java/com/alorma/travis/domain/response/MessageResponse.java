package com.alorma.travis.domain.response;

import com.alorma.travis.domain.TravisPayload;

public class MessageResponse {
    private String topic;
    private TravisPayload payload;
    private int code;

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }

    public TravisPayload getPayload() {
        return payload;
    }

    public void setPayload(TravisPayload payload) {
        this.payload = payload;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
