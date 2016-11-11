package com.alorma.travis.data;

import com.alorma.travis.domain.MessageRequest;
import com.alorma.travis.domain.MessagesRepository;
import com.alorma.travis.domain.Repository;
import com.alorma.travis.domain.TravisPayload;
import com.alorma.travis.domain.response.MessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import retrofit2.Call;
import retrofit2.Response;

public class FirebaseMessageNotificationRepository implements MessagesRepository {

    private MessageService messageService;

    public FirebaseMessageNotificationRepository(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public ResponseEntity sendMessage(TravisPayload event) throws Exception {
        if (event == null) {
            throw new UnsupportedOperationException("Event not handled");
        } else {
            String topicName = getTopicName(event);
            if (topicName == null) {
                throw new UnsupportedOperationException("Event not handled");
            } else {
                return sendMessage(topicName, event);
            }
        }
    }

    private ResponseEntity sendMessage(String topicName, TravisPayload payload) throws Exception {
        MessageRequest request = new MessageRequest();
        String topic = "/topics/" + topicName;
        request.setTo(topic);
        request.setData(payload);
        Call<MessageResponse> call = messageService.sendMessage(request);
        Response<MessageResponse> response = call.execute();

        if (response.isSuccessful()) {
            MessageResponse messageResponse = response.body();
            messageResponse.setCode(response.code());
            messageResponse.setTopic(topic);
            messageResponse.setPayload(payload);
            return new ResponseEntity<>(messageResponse, HttpStatus.OK);
        } else {
            String error = response.errorBody().string();
            switch (response.code()) {
                case 401:
                    return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
                default:
                    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
            }
        }
    }

    private String getTopicName(TravisPayload payload) {
        Repository repository = payload.getRepository();
        return repository.getOwner_name() + "-" + repository.getName();
    }
}
