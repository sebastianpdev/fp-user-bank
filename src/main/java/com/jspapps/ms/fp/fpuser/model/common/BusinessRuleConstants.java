package com.jspapps.ms.fp.fpuser.model.common;

public class BusinessRuleConstants {

    public static final int CLIENTE_EDAD_MINIMA_PERMITIDA = 18;
    public static final String CLIENTE_EMAIL_REGEX = "^[\\w-\\.]+@[\\w-]+\\.[a-z]{2,4}$";

    public static final String CUENTA_AHORRO_INICIAL = "53";
    public static final String CUENTA_CORRIENTE_INICIAL = "33";
    public static final int MIN_SALDO_CUENTA_AHORRO = 0;
    public static final String MIN_SALDO_CUENTA_AHORRO_MESSAGE = "Saldo de la cuenta de ahorros no puede ser menor a " + MIN_SALDO_CUENTA_AHORRO;
}
