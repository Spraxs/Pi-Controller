package com.spraxs.rasppi.framwork;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by Spraxs
 * Date: 18-6-2019
 */

@AllArgsConstructor @Getter
public enum InputKey {

    W(0), A(1), S(2), D(3), SPACE(4);


    private int id;
}
