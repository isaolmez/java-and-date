package com.isa.java.date.java8;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import org.junit.BeforeClass;
import org.junit.Test;

public class DateFormatterTest {

    @BeforeClass
    public static void setUp() {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+03:00"));
    }

    @Test
    public void shouldParse1() {
        final String dateString = "2020-06-08T00:00:00+08:00";
        final String dateFormat = "yyyy-MM-dd'T'HH:mm:ssXXX";
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);

        LocalDate localDate = LocalDate.from(formatter.parse(dateString));

        assertThat(localDate.getYear()).isEqualTo(2020);
        assertThat(localDate.getMonth()).isEqualTo(Month.JUNE);
        assertThat(localDate.getDayOfMonth()).isEqualTo(8);
    }

    @Test
    public void shouldParse2() {
        final String dateString = "2020-06-08T00:00:00+08:00";
        final String dateFormat = "yyyy-MM-dd'T'HH:mm:ssXXX";
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);

        LocalDate localDate = LocalDate.from(formatter.parse(dateString));
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);

        assertThat(localDate.getYear()).isEqualTo(2020);
        assertThat(localDate.getMonth()).isEqualTo(Month.JUNE);
        assertThat(localDate.getDayOfMonth()).isEqualTo(8);
        assertThat(calendar.get(Calendar.YEAR)).isEqualTo(2020);
        assertThat(calendar.get(Calendar.MONTH)).isEqualTo(5);
        assertThat(calendar.get(Calendar.DAY_OF_MONTH)).isEqualTo(8);
        assertThat(calendar.get(Calendar.HOUR_OF_DAY)).isEqualTo(0);
        assertThat(calendar.get(Calendar.MINUTE)).isEqualTo(0);
        assertThat(calendar.get(Calendar.SECOND)).isEqualTo(0);
    }

    @Test
    public void shouldParse3() {
        final String dateString = "2020-06-08T00:00:00-0800";
        final String dateFormat = "yyyy-MM-dd'T'HH:mm:ssZZZ";
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);

        LocalDate localDate = LocalDate.from(formatter.parse(dateString));
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);

        assertThat(localDate.getYear()).isEqualTo(2020);
        assertThat(localDate.getMonth()).isEqualTo(Month.JUNE);
        assertThat(localDate.getDayOfMonth()).isEqualTo(8);
        assertThat(calendar.get(Calendar.YEAR)).isEqualTo(2020);
        assertThat(calendar.get(Calendar.MONTH)).isEqualTo(5);
        assertThat(calendar.get(Calendar.DAY_OF_MONTH)).isEqualTo(8);
        assertThat(calendar.get(Calendar.HOUR_OF_DAY)).isEqualTo(0);
        assertThat(calendar.get(Calendar.MINUTE)).isEqualTo(0);
        assertThat(calendar.get(Calendar.SECOND)).isEqualTo(0);
    }

    @Test
    public void shouldParse4() {
        final String dateString = "2020-06-08T00:00:00-0800";
        final String dateFormat = "yyyy-MM-dd'T'HH:mm:ssZ";
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);

        LocalDate localDate = LocalDate.from(formatter.parse(dateString));
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);

        assertThat(localDate.getYear()).isEqualTo(2020);
        assertThat(localDate.getMonth()).isEqualTo(Month.JUNE);
        assertThat(localDate.getDayOfMonth()).isEqualTo(8);
        assertThat(calendar.get(Calendar.YEAR)).isEqualTo(2020);
        assertThat(calendar.get(Calendar.MONTH)).isEqualTo(5);
        assertThat(calendar.get(Calendar.DAY_OF_MONTH)).isEqualTo(8);
        assertThat(calendar.get(Calendar.HOUR_OF_DAY)).isEqualTo(0);
        assertThat(calendar.get(Calendar.MINUTE)).isEqualTo(0);
        assertThat(calendar.get(Calendar.SECOND)).isEqualTo(0);
    }

    @Test
    public void shouldParse5() {
        final String dateString = "2020-06-08T00:00:00Z";
        final String dateFormat = "yyyy-MM-dd'T'HH:mm:ss'Z'";
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);

        LocalDate localDate = LocalDate.from(formatter.parse(dateString));
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);

        assertThat(localDate.getYear()).isEqualTo(2020);
        assertThat(localDate.getMonth()).isEqualTo(Month.JUNE);
        assertThat(localDate.getDayOfMonth()).isEqualTo(8);
        assertThat(calendar.get(Calendar.YEAR)).isEqualTo(2020);
        assertThat(calendar.get(Calendar.MONTH)).isEqualTo(5);
        assertThat(calendar.get(Calendar.DAY_OF_MONTH)).isEqualTo(8);
        assertThat(calendar.get(Calendar.HOUR_OF_DAY)).isEqualTo(0);
        assertThat(calendar.get(Calendar.MINUTE)).isEqualTo(0);
        assertThat(calendar.get(Calendar.SECOND)).isEqualTo(0);
    }

}
