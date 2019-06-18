package com.spraxs.rasppi.led;

import com.pi4j.io.gpio.*;
import com.spraxs.rasppi.sockets.Type;
import lombok.Getter;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Author: Spraxs
 * Date: 5-6-2018
 */

public class LedController {

    private static @Getter LedController instance;

    public LedController() {
        instance = this;
    }

    private static GpioPinDigitalOutput pin;

    public String light(Type type) {


        try {
            Robot robot;
            robot = new Robot();
            robot.keyPress(KeyEvent.VK_SPACE);
        } catch (AWTException e) {
            e.printStackTrace();
        }

        if (pin == null) {
            GpioController gpioController = GpioFactory.getInstance();

            pin = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_07, "MyLED", PinState.LOW);
        }

        if (type == Type.ON) {

            if (pin.getState() == PinState.HIGH) return "Already " + type.name();

            pin.setState(PinState.HIGH);

            return type.name();
        }

        if (pin.getState() == PinState.LOW) return "Already " + type.name();

        pin.setState(PinState.LOW);

        return type.name();

    }
}
