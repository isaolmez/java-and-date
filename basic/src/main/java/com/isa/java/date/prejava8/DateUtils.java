package com.isa.java.date.prejava8;

import com.google.common.base.Preconditions;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import org.apache.commons.lang3.StringUtils;

public class DateUtils {

    public static Date getCurrentDate() {
        return new Date();
    }

    public static String format(Date date, String dateFormatString) {
        Preconditions.checkArgument(date != null);
        Preconditions.checkArgument(StringUtils.isNotBlank(dateFormatString));

        DateFormat dateFormat = new SimpleDateFormat(dateFormatString);
        return dateFormat.format(date);
    }

    public static Date parse(String dateString, String dateFormatString) {
        Preconditions.checkArgument(StringUtils.isNotBlank(dateString));
        Preconditions.checkArgument(StringUtils.isNotBlank(dateFormatString));
        DateFormat dateFormat = new SimpleDateFormat(dateFormatString);
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException("Cannot parse " + dateString);
        }
    }

    public static Date parseOrDefault(String dateString, String dateFormatString, Date defaultValue) {
        Preconditions.checkArgument(StringUtils.isNotBlank(dateString));
        Preconditions.checkArgument(StringUtils.isNotBlank(dateFormatString));
        DateFormat dateFormat = new SimpleDateFormat(dateFormatString);
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            return defaultValue;
        }
    }

    public static Date parse(String dateString, String dateFormatString, TimeZone timeZone) {
        Preconditions.checkArgument(StringUtils.isNotBlank(dateString));
        Preconditions.checkArgument(StringUtils.isNotBlank(dateFormatString));
        DateFormat dateFormat = new SimpleDateFormat(dateFormatString);
        dateFormat.setTimeZone(timeZone);
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException("Cannot parse " + dateString);
        }
    }
}
