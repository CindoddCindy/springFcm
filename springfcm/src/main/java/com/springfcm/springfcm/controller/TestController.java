package com.springfcm.springfcm.controller;

import com.google.firebase.messaging.FirebaseMessagingException;
import com.springfcm.springfcm.pojo.Note;
import com.springfcm.springfcm.service.FirebaseMessagingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    private final FirebaseMessagingService firebaseService;

    public TestController(FirebaseMessagingService firebaseService) {
        this.firebaseService = firebaseService;
    }

    @RequestMapping("/send-notification")
    @ResponseBody
    public String sendNotification(@RequestBody Note note,
                                   @RequestParam String topic) throws FirebaseMessagingException {
        return firebaseService.sendNotification(note, topic);
    }
}
