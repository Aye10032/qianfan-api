package com.aye10032.qianfanapi;

import com.aye10032.qianfanapi.data.Data;
import com.aye10032.qianfanapi.data.Message;
import com.aye10032.qianfanapi.data.ReactiveBody;
import com.aye10032.qianfanapi.data.RequestObject;
import com.aye10032.qianfanapi.utils.AccessToken;
import com.aye10032.qianfanapi.utils.JsonUtil;
import lombok.Getter;
import lombok.Setter;
import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.aye10032.qianfanapi.data.Data.*;
import static com.aye10032.qianfanapi.utils.MessageUtil.newMessage;

/**
 * @program: qianfan-api
 * @description: 聊天机器人主类
 * @author: Aye10032
 * @create: 2023-10-19 13:46
 **/

@Getter
@Setter
public class ChatBot {

    private OkHttpClient HTTP_CLIENT;

    private String accessToken;

    private int type;

    public ChatBot(int type) {
        this.HTTP_CLIENT = new OkHttpClient().newBuilder().build();
        this.accessToken = AccessToken.GetToken(HTTP_CLIENT, "token.yaml");
        this.type = type;

        if (type == Data.REACTIVE) {

        } else if (type == Data.STREAM) {

        } else {

        }
    }

    public ReactiveBody newChat(String msg){
        List<Message> messages = newMessage(msg);

        RequestObject object = new RequestObject();
        object.setMessages(messages);
        object.setStream(useStream());

        return newChat(object);
    }

    public ReactiveBody newChat(String msg, float temperature, float top_p, float penalty_score, String system, String user_id){
        List<Message> messages = newMessage(msg);

        RequestObject object = new RequestObject(messages, useStream(), temperature, top_p, penalty_score, system, user_id);

        return newChat(object);
    }

    public ReactiveBody newChat(RequestObject object){
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(JsonUtil.entity2json(object), mediaType);
        Request request = new Request.Builder()
                .url("https://aip.baidubce.com/rpc/2.0/ai_custom/v1/wenxinworkshop/chat/eb-instant?access_token=" + getAccessToken())
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response = HTTP_CLIENT.newCall(request).execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new ReactiveBody();
    }

    private boolean useStream() {
        return getType() == STREAM;
    }
}
