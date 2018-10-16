package com.jee.capteurHTTP.sender;

import com.jee.capteurHTTP.dto.Captor;
import com.jee.capteurHTTP.dto.Mesure;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import static org.springframework.http.HttpHeaders.USER_AGENT;

@Service
public class SendService {
    private static final String URL = "http://localhost:8082/addMesure";

    public void sendPost(Captor captor, Mesure mesure) throws IOException {

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(SendService.URL);

        // add header
        post.setHeader("User-Agent", USER_AGENT);

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("captorId", Integer.toString(captor.getId())));
        urlParameters.add(new BasicNameValuePair("captorCity", captor.getLocation().getCity()));
        urlParameters.add(new BasicNameValuePair("captorCountry", captor.getLocation().getCountry()));
        urlParameters.add(new BasicNameValuePair("captorLat", captor.getLocation().getLat()));
        urlParameters.add(new BasicNameValuePair("captorLon", captor.getLocation().getLon()));
        urlParameters.add(new BasicNameValuePair("mesureDate", mesure.getDate().toString()));
        urlParameters.add(new BasicNameValuePair("mesureValue", Float.toString(mesure.getValue())));
        urlParameters.add(new BasicNameValuePair("mesureType", mesure.getNature().toString()));

        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        HttpResponse response = client.execute(post);
        System.out.println("\nSending 'POST' request to URL : " + SendService.URL);
        urlParameters.forEach(nameValuePair -> {
            System.out.println("With parameters : " + nameValuePair.getName() + " ->" + nameValuePair.getValue());
        });
        System.out.println("Post parameters : " + captor + mesure);
        System.out.println("Response Code : " +
                response.getStatusLine().getStatusCode());

    }
}
