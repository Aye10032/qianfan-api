package com.aye10032.qianfanapi.data;

import lombok.*;
import lombok.Data;

import java.util.List;

/**
 * @program: qianfan-api
 * @description: 请求体
 * @author: Aye10032
 * @create: 2023-11-02 09:27
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class RequestObject {

    private List<Message> messages;
    private Boolean stream;
    private Float temperature;
    private Float top_p;
    private Float penalty_score;
    private String system;
    private String user_id;


}
