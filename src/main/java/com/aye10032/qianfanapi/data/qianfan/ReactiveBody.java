package com.aye10032.qianfanapi.data.qianfan;

import lombok.*;

/**
 * @program: qianfan-api
 * @description: 响应式请求返回
 * @author: Aye10032
 * @create: 2023-11-02 09:02
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ReactiveBody {

    private String id;
    private String object;
    private Integer created;
    private Integer sentence_id;
    private Boolean is_end;
    private Boolean is_truncated;
    private String result;
    private String need_clear_history;
    private String ban_round;
    private Usage usage;

}
