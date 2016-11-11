package com.alorma.travis.view;

import com.alorma.travis.domain.MessagesRepository;
import com.alorma.travis.domain.TravisPayload;
import com.alorma.travis.domain.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessagesController {

    @Autowired
    @Qualifier("firebase")
    private MessagesRepository messagesRepository;

    @RequestMapping(value = "/notifications", method = RequestMethod.POST)
    public
    @ResponseBody
    ResponseEntity<MessageResponse> handleMessage(@RequestBody TravisPayload event) throws Exception {
        return messagesRepository.sendMessage(event);
    }

}
