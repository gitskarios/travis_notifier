package com.alorma.travis.data;

import com.alorma.travis.domain.MessageRequest;
import com.alorma.travis.domain.response.MessageResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface MessageService {
    @POST("send")
    Call<MessageResponse> sendMessage(@Body MessageRequest messageRequest);
}