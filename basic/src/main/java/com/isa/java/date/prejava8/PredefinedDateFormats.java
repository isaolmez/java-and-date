package com.isa.java.date.prejava8;

import com.google.common.base.Preconditions;
import java.text.DateFormat;
import java.util.Date;

public class PredefinedDateFormats {

    // Predefined Date formats
    public static String formatDateDefault(Date date) {
        Preconditions.checkArgument(date != null);

        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT);
        return dateFormat.format(date);
    }

    public static String formatDateShort(Date date) {
        Preconditions.checkArgument(date != null);

        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
        return dateFormat.format(date);
    }

    public static String formatDateMedium(Date date) {
        Preconditions.checkArgument(date != null);

        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
        return dateFormat.format(date);
    }

    public static String formatDateLong(Date date) {
        Preconditions.checkArgument(date != null);

        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);
        return dateFormat.format(date);
    }

    public static String formatDateFull(Date date) {
        Preconditions.checkArgument(date != null);

        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL);
        return dateFormat.format(date);
    }

    // Predefined Time Formats

    public static String formatTimeDefault(Date date) {
        Preconditions.checkArgument(date != null);

        DateFormat dateFormat = DateFormat.getTimeInstance(DateFormat.DEFAULT);
        return dateFormat.format(date);
    }

    public static String formatTimeShort(Date date) {
        Preconditions.checkArgument(date != null);

        DateFormat dateFormat = DateFormat.getTimeInstance(DateFormat.SHORT);
        return dateFormat.format(date);
    }

    public static String formatTimeMedium(Date date) {
        Preconditions.checkArgument(date != null);

        DateFormat dateFormat = DateFormat.getTimeInstance(DateFormat.MEDIUM);
        return dateFormat.format(date);
    }

    public static String formatTimeLong(Date date) {
        Preconditions.checkArgument(date != null);

        DateFormat dateFormat = DateFormat.getTimeInstance(DateFormat.LONG);
        return dateFormat.format(date);
    }

    public static String formatTimeFull(Date date) {
        Preconditions.checkArgument(date != null);

        DateFormat dateFormat = DateFormat.getTimeInstance(DateFormat.FULL);
        return dateFormat.format(date);
    }
}
