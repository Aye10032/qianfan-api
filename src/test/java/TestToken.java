import com.aye10032.qianfanapi.ChatBot;
import com.aye10032.qianfanapi.data.qianfan.ReactiveBody;
import com.aye10032.qianfanapi.utils.AccessToken;
import org.junit.jupiter.api.Test;

import static com.aye10032.qianfanapi.data.Data.REACTIVE;

/**
 * @program: qianfan-api
 * @description:
 * @author: Aye10032
 * @create: 2023-10-19 15:07
 **/

public class TestToken {

    @Test
    void test(){
//        String token = AccessToken.GetToken("token.yaml");
//        System.out.println(token);
        ChatBot bot = new ChatBot(REACTIVE);
        ReactiveBody body = bot.newChat("你好");
        System.out.println(body.getResult());
    }

}
