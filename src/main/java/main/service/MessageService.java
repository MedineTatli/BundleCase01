package main.service;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class MessageService {


    public void sendMessage(String data) {
        Socket serverSocket;
        DataOutputStream dataOutputStream;
        try {
            serverSocket = new Socket("localhost", 1500);
            dataOutputStream = new DataOutputStream(serverSocket.getOutputStream());
            dataOutputStream.writeUTF(data.toString());
            serverSocket.close();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

}
