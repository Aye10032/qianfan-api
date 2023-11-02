package com.aye10032.qianfanapi.utils;

import com.aye10032.qianfanapi.data.Message;

import java.util.ArrayList;
import java.util.List;

import static com.aye10032.qianfanapi.data.Data.USER;

/**
 * @program: qianfan-api
 * @description: 消息队列相关
 * @author: Aye10032
 * @create: 2023-11-02 10:05
 **/

public class MessageUtil {

    public static List<Message> newMessage(String msg) {
        Message message = Message.builder()
                .role(USER)
                .content(msg)
                .build();

        List<Message> messages = new ArrayList<>();
        messages.add(message);

        return messages;
    }

}
