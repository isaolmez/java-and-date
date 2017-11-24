package com.isa.java.date.prejava8;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import org.junit.After;
import org.junit.Test;

public class DateUtilsParseWithZoneTest {

    TimeZone initialDefaultTimeZone = TimeZone.getDefault();

    @After
    public void tearDown() {
        TimeZone.setDefault(initialDefaultTimeZone);
    }

    @Test
    public void stringWithZone_FormatterWithoutZone() {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+04:00"));

        final String dateString = "2017-04-25T15:30:30Z";
        final String dateFormat = "yyyy-MM-dd'T'HH:mm:ssXXX";

        Date date = DateUtils.parse(dateString, dateFormat);
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);

        assertThat(calendar.get(Calendar.YEAR)).isEqualTo(2017);
        assertThat(calendar.get(Calendar.MONTH)).isEqualTo(3);
        assertThat(calendar.get(Calendar.DAY_OF_MONTH)).isEqualTo(25);
        assertThat(calendar.get(Calendar.HOUR_OF_DAY)).isEqualTo(19);// <---
        assertThat(calendar.get(Calendar.MINUTE)).isEqualTo(30);
        assertThat(calendar.get(Calendar.SECOND)).isEqualTo(30);
    }

    @Test
    public void stringWithoutZone_FormatterWithoutZone() {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+04:00"));
        final String dateString = "2017-04-25T15:30:30";
        final String dateFormat = "yyyy-MM-dd'T'HH:mm:ss";

        Date date = DateUtils.parse(dateString, dateFormat);
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);

        assertThat(calendar.get(Calendar.YEAR)).isEqualTo(2017);
        assertThat(calendar.get(Calendar.MONTH)).isEqualTo(3);
        assertThat(calendar.get(Calendar.DAY_OF_MONTH)).isEqualTo(25);
        assertThat(calendar.get(Calendar.HOUR_OF_DAY)).isEqualTo(15); // <---
        assertThat(calendar.get(Calendar.MINUTE)).isEqualTo(30);
        assertThat(calendar.get(Calendar.SECOND)).isEqualTo(30);
    }

    @Test
    public void stringWithoutZone_FormatterWithZone() {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+04:00"));
        TimeZone utc = TimeZone.getTimeZone("UTC");
        final String dateString = "2017-04-25T15:30:30";
        final String dateFormat = "yyyy-MM-dd'T'HH:mm:ss";

        Date date = DateUtils.parse(dateString, dateFormat, utc);
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);

        assertThat(calendar.get(Calendar.YEAR)).isEqualTo(2017);
        assertThat(calendar.get(Calendar.MONTH)).isEqualTo(3);
        assertThat(calendar.get(Calendar.DAY_OF_MONTH)).isEqualTo(25);
        assertThat(calendar.get(Calendar.HOUR_OF_DAY)).isEqualTo(19); // <---
        assertThat(calendar.get(Calendar.MINUTE)).isEqualTo(30);
        assertThat(calendar.get(Calendar.SECOND)).isEqualTo(30);
    }

    @Test
    public void stringWithoutZone_FormatterWithZoneButNotUTC() {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+04:00"));
        TimeZone utc = TimeZone.getTimeZone("GMT+02:00");
        final String dateString = "2017-04-25T15:30:30";
        final String dateFormat = "yyyy-MM-dd'T'HH:mm:ss";

        Date date = DateUtils.parse(dateString, dateFormat, utc);
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);

        assertThat(calendar.get(Calendar.YEAR)).isEqualTo(2017);
        assertThat(calendar.get(Calendar.MONTH)).isEqualTo(3);
        assertThat(calendar.get(Calendar.DAY_OF_MONTH)).isEqualTo(25);
        assertThat(calendar.get(Calendar.HOUR_OF_DAY)).isEqualTo(17); // <---
        assertThat(calendar.get(Calendar.MINUTE)).isEqualTo(30);
        assertThat(calendar.get(Calendar.SECOND)).isEqualTo(30);
    }

    @Test
    public void stringWithZone_FormatterWithZone() {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+04:00"));
        TimeZone utc = TimeZone.getTimeZone("UTC");
        final String dateString = "2017-04-25T15:30:30+08:00";
        final String dateFormat = "yyyy-MM-dd'T'HH:mm:ssXXX";

        Date date = DateUtils.parse(dateString, dateFormat, utc);
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);

        assertThat(calendar.get(Calendar.YEAR)).isEqualTo(2017);
        assertThat(calendar.get(Calendar.MONTH)).isEqualTo(3);
        assertThat(calendar.get(Calendar.DAY_OF_MONTH)).isEqualTo(25);
        assertThat(calendar.get(Calendar.HOUR_OF_DAY)).isEqualTo(11); // <---
        assertThat(calendar.get(Calendar.MINUTE)).isEqualTo(30);
        assertThat(calendar.get(Calendar.SECOND)).isEqualTo(30);
    }

    @Test
    public void stringWithZone_FormatterWithZone_CalendarWithZone() {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+04:00"));
        TimeZone utc = TimeZone.getTimeZone("UTC");
        final String dateString = "2017-04-25T15:30:30+08:00";
        final String dateFormat = "yyyy-MM-dd'T'HH:mm:ssXXX";

        Date date = DateUtils.parse(dateString, dateFormat, utc);
        Calendar calendar = GregorianCalendar.getInstance(utc);
        calendar.setTime(date);

        assertThat(calendar.get(Calendar.YEAR)).isEqualTo(2017);
        assertThat(calendar.get(Calendar.MONTH)).isEqualTo(3);
        assertThat(calendar.get(Calendar.DAY_OF_MONTH)).isEqualTo(25);
        assertThat(calendar.get(Calendar.HOUR_OF_DAY)).isEqualTo(7); // <---
        assertThat(calendar.get(Calendar.MINUTE)).isEqualTo(30);
        assertThat(calendar.get(Calendar.SECOND)).isEqualTo(30);
    }

    @Test
    public void stringWithZone_FormatterWithZone_GMTVersion() {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+04:00"));
        TimeZone gmt = TimeZone.getTimeZone("GMT");
        final String dateString = "2017-04-25T15:30:30Z";
        final String dateFormat = "yyyy-MM-dd'T'HH:mm:ssXXX";

        Date date = DateUtils.parse(dateString, dateFormat, gmt);
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);

        assertThat(calendar.get(Calendar.YEAR)).isEqualTo(2017);
        assertThat(calendar.get(Calendar.MONTH)).isEqualTo(3);
        assertThat(calendar.get(Calendar.DAY_OF_MONTH)).isEqualTo(25);
        assertThat(calendar.get(Calendar.HOUR_OF_DAY)).isEqualTo(19);
        assertThat(calendar.get(Calendar.MINUTE)).isEqualTo(30);
        assertThat(calendar.get(Calendar.SECOND)).isEqualTo(30);
    }

    @Test
    public void shouldInclude_GMT_UTC() {
        String[] availableIDs = TimeZone.getAvailableIDs();

        assertThat(availableIDs).contains("GMT", "UTC");
    }
}
