package com.alorma.travis.data;

import com.alorma.travis.domain.MessagesRepository;
import okhttp3.*;
import org.apache.catalina.filters.RequestDumperFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.servlet.Filter;
import java.io.IOException;

@Configuration
public class MessagesConfiguration {

    private static final String ENDPOINT = "https://fcm.googleapis.com/fcm/";
    private static final String CONTENT_TYPE = "application/json";
    @Value("${fcm.api_key}") String apiKey;

    @Bean
    public OkHttpClient provideOkHttpClient() {
        return new OkHttpClient.Builder().addInterceptor(this::addInterceptors).build();
    }

    private Response addInterceptors(Interceptor.Chain chain) throws IOException {
        Request original = chain.request();
        Request.Builder builder = original.newBuilder();

        builder.addHeader("Content-Type", CONTENT_TYPE);
        builder.addHeader("Authorization", "key=" + apiKey);

        HttpUrl url = original.url();
        HttpUrl.Builder newBuilder = url.newBuilder();

        builder.url(newBuilder.build());

        builder.method(original.method(), original.body());

        return chain.proceed(builder.build());
    }

    @Bean
    public Retrofit provideRetrofit(OkHttpClient okClient) {
        return new Retrofit.Builder().baseUrl(ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create()).client(okClient).build();
    }

    @Bean
    public MessageService provideIssueService(Retrofit retrofit) {
        return retrofit.create(MessageService.class);
    }


    @Bean(name = {"firebase"})
    public MessagesRepository provideGithubRepository(MessageService issueService) {
        return new FirebaseMessageNotificationRepository(issueService);
    }

    @Bean
    public FilterRegistrationBean requestDumperFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        Filter requestDumperFilter = new RequestDumperFilter();
        registration.setFilter(requestDumperFilter);
        registration.addUrlPatterns("/*");
        return registration;
    }

}
