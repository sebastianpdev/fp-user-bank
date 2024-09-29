package com.jspapps.ms.fp.fpuser.model.common;

public enum ErrorCodeMessage {

    GENERAL_ERROR(901, "Consulte con el administrador del sistema"),

    USER_NOT_FOUND(902, "Usuario no encontrado"),
    USER_DATA_ERROR(903, "El usuario no se pudo guardar"),
    IDENTIFICATION_TYPE_INVALID(904, "Tipo de identificación no soportado"),
    AGE_INVALID(905, "El cliente debe ser mayor de edad"),
    USER_EMAIL_INVALID(906, "El email ingresado no es válido"),

    ACCOUNT_NOT_FOUND(907, "Cuenta no encontrada"),
    ACCOUNT_STATE_INVALID(908, "Esta cuenta se encuentra inactiva o cancelada"),
    ACCOUNT_TYPE_INVALID(909, "Este tipo de cuenta no está soportado");

    private final int code;
    private final String message;

    ErrorCodeMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String toStringCode() {
        return String.valueOf(code);
    }

}
