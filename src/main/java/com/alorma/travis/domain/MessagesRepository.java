package com.alorma.travis.domain;

import com.alorma.travis.domain.response.MessageResponse;
import org.springframework.http.ResponseEntity;

public interface MessagesRepository {
    ResponseEntity sendMessage(TravisPayload event) throws Exception;
}
