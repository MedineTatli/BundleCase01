package main.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageConsumeService {

    public void processMessage(byte[] message) {
        String messageContent = new String(message);
        log.info("Receive message: {}", messageContent);
        String responseContent = String.format("Message \"%s\" is processed", messageContent);
    }

}
