package com.jspapps.ms.fp.fpuser.model.common;

import java.time.LocalDate;
import java.time.Period;

public class DateUtil {

    public static int getAge(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
}
