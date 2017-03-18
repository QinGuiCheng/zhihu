package com.yiyi.zhihu.util;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Administrator on 2017/1/5.
 */

public class DateUtils {

    public static final String PATTERN_DATE = "MM月dd日";
    public static final String PATTERN_WEEKDAY = "EEEE";
    public static final String PATTERN_SPLIT = " ";
    public static final String PATTERN = PATTERN_DATE + PATTERN_SPLIT + PATTERN_WEEKDAY;

    public static String date2str(Date date) {
        return date2str(date, PATTERN);
    }

    public static String date2str(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
        return sdf.format(date);
    }

    public static Date str2date(String str) {
        return str2date(str, PATTERN);
    }

    public static Date str2date(String str, String format) {
        Date date = null;
        try {
            if (str != null)
            {
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                date = sdf.parse(str);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
