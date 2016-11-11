package com.alorma.travis.data;

import com.alorma.travis.domain.IssueEvent;
import com.alorma.travis.domain.MessageRequest;
import com.alorma.travis.domain.MessagesRepository;
import com.alorma.travis.domain.response.MessageResponse;
import retrofit2.Call;
import retrofit2.Response;

public class FirebaseMessageNotificationRepository implements MessagesRepository {

    private MessageService messageService;

    public FirebaseMessageNotificationRepository(MessageService  messageService) {

        this.messageService = messageService;
    }

    @Override
    public MessageResponse sendMessage(IssueEvent event) throws Exception {
        if (event.getIssue() == null || event.getRepository() == null) {
            throw new UnsupportedOperationException("Event not handled");
        } else {
            String issueRepositoryName = getIssueName(event);
            if (issueRepositoryName == null) {
                throw new UnsupportedOperationException("Event not handled");
            } else {
                issueRepositoryName = issueRepositoryName.replace("/", "-");
                return sendMessage(issueRepositoryName, event);
            }
        }
    }

    private MessageResponse sendMessage(String issueRepositoryName, IssueEvent event) throws Exception {
        MessageRequest request = new MessageRequest();
        String topic = "/topics/" + issueRepositoryName;
        request.setTo(topic);
        request.setData(event);
        Call<MessageResponse> call = messageService.sendMessage(request);
        Response<MessageResponse> response = call.execute();

        MessageResponse messageResponse = response.body();
        messageResponse.setCode(response.code());
        messageResponse.setTopic(topic);
        return messageResponse;
    }

    private String getIssueName(IssueEvent event) {
        return event.getRepository().getFull_name();
    }
}
