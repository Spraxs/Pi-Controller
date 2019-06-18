package com.spraxs.rasppi.sockets;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor @Getter
public enum Type {

    ON(1), OFF(0);

    private int code;
}
