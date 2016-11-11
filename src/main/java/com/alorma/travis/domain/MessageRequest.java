package com.alorma.travis.domain;

public class MessageRequest {
    private String to;
    private IssueEvent data;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public IssueEvent getData() {
        return data;
    }

    public void setData(IssueEvent data) {
        this.data = data;
    }
}
