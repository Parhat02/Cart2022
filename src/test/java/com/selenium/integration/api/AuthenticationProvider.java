package com.selenium.integration.api;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;

public class AuthenticationProvider {
    public CredentialsProvider getCredential(String userName, String password, String host, int port){
        final BasicCredentialsProvider credentialsProvider=new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY,new UsernamePasswordCredentials(userName,password));
        return credentialsProvider;
    }
}
