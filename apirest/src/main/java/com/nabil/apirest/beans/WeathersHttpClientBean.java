package com.nabil.apirest.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import okhttp3.OkHttpClient;
import okhttp3.Request;

@Component
public class WeathersHttpClientBean {

	@Value("${weathers.api.key}")
	private String apiKey;
	@Value("${weatherss.api.host}")
	private String apiHost;
	
	
	@Bean(name="weathersClient")
	public OkHttpClient getClient() {
		return new OkHttpClient.Builder()
			    .addInterceptor((chain)->{
			    	Request request = chain.request();
			        Request newRequest;

			        newRequest = request.newBuilder()
			                .addHeader("x-rapidapi-key", apiKey)
			                .addHeader("x-rapidapi-host", apiHost)
			                .build();
			        return chain.proceed(newRequest);
			    }).build();
			   
	}
	
	
}
