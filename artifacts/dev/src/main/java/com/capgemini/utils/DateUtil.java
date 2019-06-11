package com.capgemini.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateUtil {

    private final static Logger logger = LoggerFactory.getLogger(DateUtil.class);

    public static TimeZone getDefaultTimeZone(){
        return TimeZone.getTimeZone("Asia/Shanghai");
    }

    public static Timestamp yyyyMMdd2timestamp(String dateStr){
        if(dateStr == null || "".equals(dateStr.trim())){
            return null;
        }

        try {
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setTimeZone(getDefaultTimeZone());
            return new Timestamp(sdf.parse(dateStr).getTime());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return null;
    }

    public static String timestamp2yyyyMMdd(Timestamp date){
        if(date == null){
            return null;
        }

        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(getDefaultTimeZone());

        try {
            return sdf.format(date);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return null;
    }

    public static Date yyyyMMdd2Date(String dateStr){
        if(dateStr == null || "".equals(dateStr.trim())){
            return null;
        }

        try {
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setTimeZone(getDefaultTimeZone());

            return  sdf.parse(dateStr);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return null;
    }

    public static String date2yyyyMMdd(Date date){
        if(date == null){
            return null;
        }

        String tsStr = "";
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(getDefaultTimeZone());

        try {
            tsStr = sdf.format(date);
            return tsStr;
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return null;
    }

}
