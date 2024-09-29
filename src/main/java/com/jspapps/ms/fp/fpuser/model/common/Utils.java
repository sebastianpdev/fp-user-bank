package com.jspapps.ms.fp.fpuser.model.common;

public class Utils {

    public static String generarNumeroAleatorio() {
        return String.format("%08d", (int) (Math.random() * 100000000));
    }
}
