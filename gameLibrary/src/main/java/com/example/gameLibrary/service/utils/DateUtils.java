package com.example.gameLibrary.service.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtils {
    public static String getCurrentTime(){
        Date time = new Date(System.currentTimeMillis());
        String formatted = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(time);
        return formatted;
    }
}