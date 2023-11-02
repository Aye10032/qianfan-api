package com.aye10032.qianfanapi.data;

import lombok.*;
import lombok.Data;

/**
 * @program: qianfan-api
 * @description: 对话记录
 * @author: Aye10032
 * @create: 2023-11-02 09:30
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Message {

    private String role;
    private String content;

}
