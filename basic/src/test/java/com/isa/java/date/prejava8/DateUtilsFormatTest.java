package com.isa.java.date.prejava8;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import org.assertj.core.api.Assertions;
import org.junit.BeforeClass;
import org.junit.Test;

public class DateUtilsFormatTest {

    private static Date date;

    @BeforeClass
    public static void setUpTest() {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+03:00"));
        Calendar calendar = new GregorianCalendar();
        calendar.set(2017, 3, 25, 15, 30, 30);
        calendar.set(Calendar.MILLISECOND, 250);
        date = calendar.getTime();
    }

    @Test
    public void shouldFormat1() {
        final String formatString = "y";
        final String expected = "2017";

        String actual = DateUtils.format(date, formatString);

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldFormat2() {
        final String formatString = "yy";
        final String expected = "17";

        String actual = DateUtils.format(date, formatString);

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldFormat3() {
        final String formatString = "yyy";
        final String expected = "2017";

        String actual = DateUtils.format(date, formatString);

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldFormat4() {
        final String formatString = "yyyy";
        final String expected = "2017";

        String actual = DateUtils.format(date, formatString);

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldFormat5() {
        final String formatString = "yyyy-M";
        final String expected = "2017-4";

        String actual = DateUtils.format(date, formatString);

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldFormat6() {
        final String formatString = "yyyy-MM";
        final String expected = "2017-04";

        String actual = DateUtils.format(date, formatString);

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldFormat7() {
        final String formatString = "yyyy-MM-d";
        final String expected = "2017-04-25";

        String actual = DateUtils.format(date, formatString);

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldFormat8() {
        final String formatString = "yyyy-MM-dd";
        final String expected = "2017-04-25";

        String actual = DateUtils.format(date, formatString);

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldFormat9() {
        final String formatString = "yyyy-MM-dd HH";
        final String expected = "2017-04-25 15";

        String actual = DateUtils.format(date, formatString);

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldFormat10() {
        final String formatString = "yyyy-MM-dd'T'HH";
        final String expected = "2017-04-25T15";

        String actual = DateUtils.format(date, formatString);

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldFormat11() {
        final String formatString = "yyyy-MM-dd'T'HH:mm:ss.SSS";
        final String expected = "2017-04-25T15:30:30.250";

        String actual = DateUtils.format(date, formatString);

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldFormat12() {
        final String formatString = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
        final String expected = "2017-04-25T15:30:30.250+03:00";

        String actual = DateUtils.format(date, formatString);

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    /**
     * Overrides the timezone
     */
    @Test
    public void shouldFormat13() {
        final String formatString = "yyyy-MM-dd'T'HH:mm:ss'Z'";
        final String expected = "2017-04-25T15:30:30Z";

        String actual = DateUtils.format(date, formatString);

        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
