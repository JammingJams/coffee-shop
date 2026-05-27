package com.pluralsight.Interface;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public interface DateTimeLogger {
    default String logDateAndTime() {
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMM-hhmmss");
        String formattedDate = time.format(format);
        return formattedDate;
    }
}
