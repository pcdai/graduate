package cn.sjxy.graduate.component;

import cn.sjxy.graduate.utils.RandomCode;
import org.springframework.mail.SimpleMailMessage;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author :
 * @date : 2019/12/17
 */
public class MessageSender extends SimpleMailMessage implements Serializable {

        private final String from="1789333527@qq.com";
        private String[] to;
        private String subject="验证码";
        private String text=RandomCode.randomCode();

    @Override
    public String getFrom() {
        return from;
    }


    @Override
    public void setTo(String[] to) {

        this.to = to;
    }

    @Override
    public String getSubject() {
        return subject;
    }

    @Override
    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "MessageSender{" +
                "from='" + from + '\'' +
                ", to=" + Arrays.toString(to) +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
