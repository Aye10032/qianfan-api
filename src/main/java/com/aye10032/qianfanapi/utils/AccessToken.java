package com.aye10032.qianfanapi.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import okhttp3.*;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

/**
 * @program: qianfan-api
 * @description: get token
 * @author: Aye10032
 * @create: 2023-10-19 14:03
 **/

public class AccessToken {

    public static String GetToken(String filePath){
        Yaml yaml = new Yaml();
        try {
            Map<String, Object> config = yaml.load(new FileInputStream(filePath));

            String client_id = config.get("client_id").toString();
            String client_secret = config.get("client_secret").toString();

            return GetToken(client_id, client_secret);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static String GetToken(String clientID, String clientSecret){
        OkHttpClient HTTP_CLIENT = new OkHttpClient().newBuilder().build();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create("", mediaType);
        StringBuilder builder = new StringBuilder();
        builder.append("https://aip.baidubce.com/oauth/2.0/token?client_id=")
                .append(clientID)
                .append("&client_secret=")
                .append(clientSecret)
                .append("&grant_type=client_credentials");

        Request request = new Request.Builder()
                .url(builder.toString())
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();
        Response response = null;

        try {
            response = HTTP_CLIENT.newCall(request).execute();
            assert response.body() != null;

            Gson gson = new Gson();
            JsonObject object = gson.fromJson(response.body().string(), JsonObject.class);


            return object.get("access_token").getAsString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
