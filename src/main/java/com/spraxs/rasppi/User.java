package com.spraxs.rasppi;

import com.spraxs.rasppi.led.KeyboardController;
import com.spraxs.rasppi.sockets.ServerSocketThread;

import java.io.IOException;

/**
 * Author: Spraxs
 * Date: 5-6-2018
 */

public class User {

    public static void main(String[] args) throws IOException {

        new KeyboardController();

        new ServerSocketThread();
    }
}
