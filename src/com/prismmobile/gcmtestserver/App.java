package com.prismmobile.gcmtestserver;


import java.nio.charset.StandardCharsets;

public class App {

    public static void main(String[] args) {


        System.out.println("Sending POST to GCM");

        String apiKey = "AIzaSyAzn45gYabECfFfsYq3LsMzbuSQUhTNIYM";
        Content content = createContent();

        POST2GCM.post(apiKey, content);
    }

    public static Content createContent() {

        Content c = new Content();

        c.addRegId("APA91bHQok-0v_SYCMM0zbAlc60GhPzAGMYNqbo1V3aQMJ-F9Ka5BfmsOqJmHJpUoJDtK43h70Du7AmnRGAp31ji8SAaazoxD2qzA6XMz4gNwFeGbfRCt-JkmtGxBQ1IU-2ybOJqrHOSvY70WXNQ2cLAOYERKasN1A");
        c.createData("Message Title", "Welcome to GCM!");

        return c;
    }
}
