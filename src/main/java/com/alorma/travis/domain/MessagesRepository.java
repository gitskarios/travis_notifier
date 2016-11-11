package com.alorma.travis.domain;

import com.alorma.travis.domain.response.MessageResponse;

public interface MessagesRepository {
    MessageResponse sendMessage(IssueEvent event) throws Exception;
}
