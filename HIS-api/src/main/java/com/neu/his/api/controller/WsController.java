package com.neu.his.api.controller;

import com.neu.his.bo.ChatMsg;
import com.neu.his.mbg.model.SmsStaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.io.Console;
import java.util.Date;

@Controller
public class WsController {

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/ws/chat")
    public void handleMsg(Authentication authentication, ChatMsg chatMsg) {
        SmsStaff staff = (SmsStaff) authentication.getPrincipal();
        chatMsg.setFrom(staff.getUsername());
        chatMsg.setFromNickname(staff.getName());
        chatMsg.setDate(new Date());
        System.out.println(chatMsg);
        simpMessagingTemplate.convertAndSendToUser(chatMsg.getTo(), "/queue/chat", chatMsg);
    }
}