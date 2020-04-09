package cn.sjxy.graduate.controller;

import cn.sjxy.graduate.component.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @Author dpc
 * @Date 2020/3/25 10:47
 */
@RestController
public class CodeUtilController {
    @Autowired
    JavaMailSender sender;

    @GetMapping("/getCode")
    public String getCode(String email, HttpSession session) {
        MessageSender messageSender = new MessageSender();
        messageSender.setTo(email);
        String text = messageSender.getText();
        session.setAttribute("code", text);
        sender.send(messageSender);
        return "ok";
    }
}
