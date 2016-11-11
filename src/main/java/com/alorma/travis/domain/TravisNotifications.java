package com.alorma.travis.domain;

import java.util.List;

public class TravisNotifications {
    private List<String> webhooks;

    public List<String> getWebhooks() {
        return webhooks;
    }

    public void setWebhooks(List<String> webhooks) {
        this.webhooks = webhooks;
    }
}
