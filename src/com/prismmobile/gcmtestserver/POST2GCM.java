package com.prismmobile.gcmtestserver;






import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;


import java.net.URL;



public class POST2GCM {


    public static void post(String apiKey, Content content) {

        try {

            URL url = new URL("https://android.googleapis.com/gcm/send");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("charset", "UTF-8");
            connection.setRequestProperty("com.prismmobile.gcmtestserver.Content-Type", "application/json");
            connection.setRequestProperty("Authorization", "key=" + apiKey);

            connection.setDoOutput(true);

            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

            DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());

            mapper.writeValue(outputStream, content);

            outputStream.flush();
            outputStream.close();

            int responseCode = connection.getResponseCode();
            System.out.println("\nSending 'POST' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = reader.readLine()) != null) {
                response.append(inputLine);
            }

            reader.close();

            System.out.println(response.toString());



        }
        catch(IOException e) {
            e.printStackTrace();
        }


    }

}
