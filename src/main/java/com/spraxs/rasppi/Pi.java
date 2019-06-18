package com.spraxs.rasppi;

import com.spraxs.rasppi.framwork.InputKey;
import lombok.Getter;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Author: Spraxs
 * Date: 5-6-2018
 */

public class Pi {

    private static @Getter Pi instance;

    public Pi() {
        instance = this;
    }


    public static void main(String[] args) throws IOException {
        new Pi();


        while (true) {
            Pi.getInstance().sendSocket(InputKey.A);
        }
    }

    private void sendSocket(InputKey inputKey) throws IOException {
        Socket socket = new Socket(Configuration.SERVER_IP, Configuration.SERVER_PORT); // IP van Raspberry

        PrintStream printStream = new PrintStream(socket.getOutputStream());

        printStream.println(inputKey.getId());

        System.out.println("Socket verzonden!");
    }
}
