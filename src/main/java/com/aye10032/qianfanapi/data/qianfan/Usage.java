package com.aye10032.qianfanapi.data.qianfan;

import lombok.*;

/**
 * @program: qianfan-api
 * @description: token统计信息
 * @author: Aye10032
 * @create: 2023-11-02 10:33
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Usage {

    private Integer prompt_tokens;
    private Integer completion_tokens;
    private Integer total_tokens;

}
