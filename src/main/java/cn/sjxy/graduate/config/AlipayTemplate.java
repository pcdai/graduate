package cn.sjxy.graduate.config;

import cn.sjxy.graduate.entity.PayVo;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "alipay")
@Component
@Data
public class AlipayTemplate {

    //在支付宝创建的应用的id
    private String app_id = "2016102300746680";

    // 商户私钥，您的PKCS8格式RSA2私钥
    private String merchant_private_key = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCqdcKaJ/2ab46lpYJVIyB887kZddhr2i5BrK+80lXxuKYbm36fhSm23x7SdGc40sMls0TYwnRNp5l9lmEjMBpLUE+EHxkdIPTQuoe7stT2+bZLU3oZLpvQB3nlmXPT8leaXNlfgpnQePwWd6Ce4JgdbfYB6hb6PMAKosbGQgDj7CLpuG26i3LQk6Ti0l8eW8i2Nbqm44F1sTo8ZT7si8xy0rvynj4OEt4o7WEUL7jVbjocTakx2x9NqJCg3k/QZ7W5PUuDjqAF4dtajhPc/4l76lmFtGn3zaIpi3TqKrayHYLl9tHJAB9aVheahNJPWF2cV+tjY/G+6QCGr9bj2f0VAgMBAAECggEBAJC1L+NWl8CHe/27qA1GqMnqzfSDSpskuagfRYFyvmtaagl909zwWx1YBP58uzROGETlD0lEqx9RbMhk5UnOCERvhVGQZO2JkMuxzpDVnF2eV9dSopDGNJhCAIWd4+rGDQCKWi7u3E1SqA8at0ypNfml4/Z0F9WPxShCT6T3W3IhHTnYbWkUm3xUrLHt9SOvbF+riR/wUDqxzfmZNYMN9ACcoxLSX32HUx5VQTHj/3NRtUY39ynaMk7PVraKLx+qqqCSOt5kbeWNbzFSMO2yxka7A+dR74k3LTENvDPvoc3RIfJ0ncUiUnllIRymuDxo4rPTeEzrYEJoi3FxoqWWmgECgYEA4YYrpQ4+xyIVu5plrsUhkRe0oKOYLAzxm+14GJdfo3dLt2wDVGTcowGM3a8Bxjj3ipsAmvF5r3v+/H7l9LKCzVreO//KGvuHkuykIMGkRRb0C0Dvg0iGIVTQfBqLV00CS8MBfT7qJKZo0mXrhf16ayJ8pNC+lLGaQ3T/I3omYaECgYEAwX6wsjYqKHJ4pIIvzumKibYQRe4x865r+z1aXwUcl+/DcaKchZK52EEWal4uEgOL8OZNyRgfMfjujgzfnIoN3hCtrCQxINnbjwUD8i/l85s7ys6PwHE47vxmGVzGIFTgr/zry5O/jLIDtpxslmMNayzNQA44kGUKy79W+W4vzvUCgYAMIxNgO6cHQn9W7FVClZtb2qG+7272F/A8ywfmkubzvizV/zsipJb3MtMo7w0yZMh1rifXLt20owCzCAVKKP0/Hf/NzNNMpnLCZnfix2kWyshxfpolP5bwXkcmFqufFCbmeuUun18sf8QuZovJVz3qXB3HJPDMwc4iiT5d42oDYQKBgQCvH+3mbZV8ZBaCtf11JPQpLWnPEQWOyjea/W10gJjffraCe610S1b+vfH+tVy3GxSmJJsUPUvGm8m1MTuVX3Groaa+HUeFtwe7isuGgAl8kOvt40RB5Xek/TWfENOU4Z02SxBSgVeljFxGA49YETBM5xChP/272meJ/pRGTo7gnQKBgQCpyrvI++STchfTwqwF4oPf0SuuF36fXPcr1nefYafCLVTwQdmniZL5RSYlphupE6hA+/6no8tnHxy/u7G2vbPcvkEYMECR5IvDIg+gtkJaZCPpdLAHBDgx82Nm77paxF30EIucQiLg/YQ0BDnr/Oewi/Q4u4APLVK/WP8tLXQJYg==";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    private String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqnXCmif9mm+OpaWCVSMgfPO5GXXYa9ouQayvvNJV8bimG5t+n4Uptt8e0nRnONLDJbNE2MJ0TaeZfZZhIzAaS1BPhB8ZHSD00LqHu7LU9vm2S1N6GS6b0Ad55Zlz0/JXmlzZX4KZ0Hj8FnegnuCYHW32AeoW+jzACqLGxkIA4+wi6bhtuoty0JOk4tJfHlvItjW6puOBdbE6PGU+7IvMctK78p4+DhLeKO1hFC+41W46HE2pMdsfTaiQoN5P0Ge1uT1Lg46gBeHbWo4T3P+Je+pZhbRp982iKYt06iq2sh2C5fbRyQAfWlYXmoTST1hdnFfrY2PxvukAhq/W49n9FQIDAQAB";
    // 服务器[异步通知]页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    // 支付宝会悄悄的给我们发送一个请求，告诉我们支付成功的信息
    private String notify_url = "http://localhost:8080/member/scenic_order.html";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    //同步通知，支付成功，一般跳转到成功页
    private String return_url = "http://localhost:8080/member/scenic_order.html";

    // 签名方式
    private String sign_type = "RSA2";

    // 字符编码格式
    private String charset = "utf-8";

    // 支付宝网关； https://openapi.alipaydev.com/gateway.do
    private String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    public String pay(PayVo vo) throws AlipayApiException {

        //AlipayClient alipayClient = new DefaultAlipayClient(AlipayTemplate.gatewayUrl, AlipayTemplate.app_id, AlipayTemplate.merchant_private_key, "json", AlipayTemplate.charset, AlipayTemplate.alipay_public_key, AlipayTemplate.sign_type);
        //1、根据支付宝的配置生成一个支付客户端
        AlipayClient alipayClient = new DefaultAlipayClient(gatewayUrl,
                app_id, merchant_private_key, "json",
                charset, alipay_public_key, sign_type);

        //2、创建一个支付请求 //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(return_url);
        alipayRequest.setNotifyUrl(notify_url);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = vo.getOut_trade_no();
        //付款金额，必填
        String total_amount = vo.getTotal_amount();
        //订单名称，必填
        String subject = vo.getSubject();
        //商品描述，可空
        String body = vo.getBody();

        alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"body\":\"" + body + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        String result = alipayClient.pageExecute(alipayRequest).getBody();

        //会收到支付宝的响应，响应的是一个页面，只要浏览器显示这个页面，就会自动来到支付宝的收银台页面
        System.out.println("支付宝的响应：" + result);

        return result;

    }
}
