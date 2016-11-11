package com.alorma.travis.view;

import com.alorma.travis.domain.IssueEvent;
import com.alorma.travis.domain.MessagesRepository;
import com.alorma.travis.domain.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessagesController {

    @Autowired
    @Qualifier("firebase")
    private MessagesRepository messagesRepository;

    @RequestMapping(value = "/message", method = RequestMethod.POST)
    public
    @ResponseBody
    ResponseEntity<MessageResponse> handleMessage(@RequestBody IssueEvent event) throws Exception {
        MessageResponse messageResponse = messagesRepository.sendMessage(event);
        if (messageResponse.getError() != null) {
            return new ResponseEntity<>(messageResponse, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(messageResponse, HttpStatus.OK);
    }

}
