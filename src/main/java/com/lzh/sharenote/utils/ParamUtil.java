package com.lzh.sharenote.utils;

import org.apache.commons.lang3.time.DateUtils;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Date;

/**
 * Created by Lu Zhaohui on 2017/7/20.
 */
public class ParamUtil {

    public static String getString(HttpServletRequest request, String key) {
        return request.getParameter(key);
    }

    public static int getInt(HttpServletRequest request, String key) {
        String value = request.getParameter(key);
        int intVal = 0;
        try{
            intVal = Integer.parseInt(value);
        }catch(NumberFormatException e) {

        }
        return intVal;
    }

    public static long getLong(HttpServletRequest request, String key) {
        String value = request.getParameter(key);
        long longVal = 0;
        try{
            longVal = Long.parseLong(value);
        }catch(NumberFormatException e) {

        }
        return longVal;
    }

    public static Date getDate(HttpServletRequest request, String key) {
        String value = request.getParameter(key);
        Date date = null;
        try {
            date = DateUtils.parseDateStrictly(value, new String[]{"yyyyMMdd","yyyyMMddHHmmss"});
        } catch (ParseException e) {
        }
        return date;
    }
}
