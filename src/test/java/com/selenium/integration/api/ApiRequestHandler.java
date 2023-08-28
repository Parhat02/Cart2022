package com.selenium.integration.api;

import org.apache.commons.lang3.time.StopWatch;
import org.apache.http.HttpEntity;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ApiRequestHandler {
    //define a user agent
    private final String USER_AGENT="Mozilla/5.0";

    public ApiResponseHandler getAllCustomer(String userName, String password, String url, int port, String endPoint) {
        ApiResponseHandler responseHandler = new ApiResponseHandler();
        AuthenticationProvider authenticationProvider = new AuthenticationProvider();
        StopWatch stopwatch = new StopWatch();
        System.out.println(stopwatch);
        CloseableHttpClient httpClient = HttpClientBuilder.create().setDefaultCredentialsProvider((CredentialsProvider) authenticationProvider.getCredential(userName, password, url, port)).build();
        // create get request
        HttpGet httpGet=new HttpGet(url+":"+port+"/"+endPoint);
        //get response
        try {
            CloseableHttpResponse response= httpClient.execute(httpGet);
            int statusCode=response.getStatusLine().getStatusCode();
            if (statusCode!=0){
                responseHandler.setResponseCode(statusCode);
                responseHandler.setResponseTime(stopwatch.getTime(TimeUnit.MILLISECONDS));
            }
            //response body
            HttpEntity entity=response.getEntity();
            if (entity!=null){
                String responseContent= EntityUtils.toString(entity);
                System.out.println(responseContent);
                responseHandler.setResponseContent(responseContent);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return responseHandler;
    }
}
