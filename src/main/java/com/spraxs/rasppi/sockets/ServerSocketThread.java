package com.spraxs.rasppi.sockets;

import com.spraxs.rasppi.framwork.InputKey;
import com.spraxs.rasppi.led.KeyboardController;
import com.spraxs.rasppi.led.LedController;
import com.sun.corba.se.spi.activation.ServerManager;
import lombok.Getter;

import java.awt.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Author: Spraxs
 * Date: 5-6-2018
 */

public class ServerSocketThread {

    private static @Getter ServerSocketThread instance;

    private @Getter ServerSocket serverSocket;

    private LedController ledController;

    public ServerSocketThread() {
        instance = this;
        this.ledController = LedController.getInstance();

        new Thread(() -> {

            try {
                this.serverSocket = new ServerSocket(5647);
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                this.run();
            } catch (IOException | AWTException e) {
                e.printStackTrace();
            }
        }).start();

    }

    private void run() throws IOException, AWTException {

        while (true) {

            System.out.println("Waiting for incoming socket...");

            String message;

            Socket socket = this.serverSocket.accept();

            Scanner scanner = new Scanner(socket.getInputStream());

            message = scanner.next();

            System.out.println("Received incoming socket!");
            System.out.println("Data: " + message);

            if (message == null) continue;

            int keyId = Integer.valueOf(message);

            for (InputKey inputKey : InputKey.values()) {
                if (inputKey.getId() != keyId) continue;

                KeyboardController.getInstance().manageInput(inputKey);
            }
        }
    }
}
