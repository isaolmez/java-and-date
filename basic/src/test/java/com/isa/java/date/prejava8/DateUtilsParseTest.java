package com.isa.java.date.prejava8;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import org.junit.BeforeClass;
import org.junit.Test;

public class DateUtilsParseTest {

    private final int ZONE_CONSTANT = (60 * 60 * 1000);

    @BeforeClass
    public static void setUp() {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+03:00"));
    }

    @Test
    public void shouldParse() {
        final String dateString = "2017-04-25T15:30:30.250+03:00";
        final String dateFormat = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";

        Date date = DateUtils.parse(dateString, dateFormat);
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);

        assertThat(calendar.get(Calendar.YEAR)).isEqualTo(2017);
        assertThat(calendar.get(Calendar.MONTH)).isEqualTo(3);
        assertThat(calendar.get(Calendar.DAY_OF_MONTH)).isEqualTo(25);
        assertThat(calendar.get(Calendar.HOUR_OF_DAY)).isEqualTo(15);
        assertThat(calendar.get(Calendar.MINUTE)).isEqualTo(30);
        assertThat(calendar.get(Calendar.SECOND)).isEqualTo(30);
        assertThat(calendar.get(Calendar.MILLISECOND)).isEqualTo(250);
        assertThat(calendar.get(Calendar.ZONE_OFFSET) / ZONE_CONSTANT).isEqualTo(3);
    }

    @Test
    public void shouldParse2() {
        final String dateString = "2017-04-25T15:30:30Z";
        final String dateFormat = "yyyy-MM-dd'T'HH:mm:ssXXX";

        Date date = DateUtils.parse(dateString, dateFormat);
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);

        assertThat(calendar.get(Calendar.YEAR)).isEqualTo(2017);
        assertThat(calendar.get(Calendar.MONTH)).isEqualTo(3);
        assertThat(calendar.get(Calendar.DAY_OF_MONTH)).isEqualTo(25);
        assertThat(calendar.get(Calendar.HOUR_OF_DAY)).isEqualTo(18);
        assertThat(calendar.get(Calendar.MINUTE)).isEqualTo(30);
        assertThat(calendar.get(Calendar.SECOND)).isEqualTo(30);
        assertThat(calendar.get(Calendar.MILLISECOND)).isEqualTo(0);
        assertThat(calendar.get(Calendar.ZONE_OFFSET) / ZONE_CONSTANT).isEqualTo(3);
    }
}
