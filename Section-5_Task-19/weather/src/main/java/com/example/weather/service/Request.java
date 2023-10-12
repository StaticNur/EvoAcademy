package com.example.weather.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class Request {
    private final String API_KEY = "9bb1159de971c047caddaa4b08f9b404";
    private final String latitude = "54.1838";
    private final String longitude = "45.1749";
    private final String url = "https://api.openweathermap.org/data/2.5/weather?lat=" + latitude + "&lon=" + longitude + "&appid=" + API_KEY + "&units=metric";

    public String getWeather() throws IOException {
        String response = sendGET();
        if (response==null){
            return response;
        }
        return parser(response);
    }

    private String sendGET() throws IOException {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");

        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            String response1 = new String(response);
            return response1;
        } else {
            System.out.println("GET request did not work.");
        }
        return null;
    }

    private String parser(String response) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode json = objectMapper.readTree(response);
        JsonNode mainNode = json.get("main");
        JsonNode weatherNode = json.get("weather");
        JsonNode tempNode = mainNode.get("temp");
        String dto = "City: " + json.get("name")
                + "\nTemperature: " + tempNode.asText() + "°C"
                + "\nDescription: " + weatherNode.get(0).get("description");
        return dto;
    }
}
