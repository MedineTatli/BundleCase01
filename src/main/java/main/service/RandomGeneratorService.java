package main.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Random;

@Service
@Slf4j
@AllArgsConstructor
public class RandomGeneratorService {

    private MessageService messageService;

    @Transactional
    public void generateData() {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        Random random = new Random();
        Integer randomInt = random.nextInt(101);
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            String code = timeStamp.toString() + randomInt.toString();
            String messageDigest = md.digest(code.getBytes()).toString();
            String data = code + messageDigest.substring(messageDigest.length() - 2);
            messageService.sendMessage(data);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }


    }
}
