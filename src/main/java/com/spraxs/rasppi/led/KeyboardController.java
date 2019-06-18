package com.spraxs.rasppi.led;

import com.spraxs.rasppi.framwork.InputKey;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Spraxs
 * Date: 18-6-2019
 */


public class KeyboardController {

    private @Getter static KeyboardController instance;

    public KeyboardController() {
        instance = this;
    }

    public void manageInput(InputKey inputKey) throws AWTException {

        Robot robot = new Robot();

        switch (inputKey) {
            case A:
                robot.keyPress(KeyEvent.VK_A);
                break;

            case W:
                robot.keyPress(KeyEvent.VK_W);
                break;

            case S:
                robot.keyPress(KeyEvent.VK_S);
                break;

            case D:
                robot.keyPress(KeyEvent.VK_D);
                break;

            case SPACE:
                robot.keyPress(KeyEvent.VK_SPACE);
                break;
        }
    }

}
