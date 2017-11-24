package com.isa.java.date.java8;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.TimeZone;
import org.junit.BeforeClass;
import org.junit.Test;

public class DateClassesTest {

    @BeforeClass
    public static void setUp() {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+03:00"));
    }

    @Test
    public void shouldCreateLocalDate1() {
        LocalDate date = LocalDate.of(2017, Month.JUNE, 20);

        assertThat(date.getYear()).isEqualTo(2017);
        assertThat(date.getMonth()).isEqualTo(Month.JUNE);
        assertThat(date.getDayOfMonth()).isEqualTo(20);
    }

    @Test
    public void shouldCreateLocalDate2() {
        LocalDate date = LocalDate.of(2017, Month.JUNE, 20)
                .with(TemporalAdjusters.firstDayOfMonth());

        assertThat(date.getYear()).isEqualTo(2017);
        assertThat(date.getMonth()).isEqualTo(Month.JUNE);
        assertThat(date.getDayOfMonth()).isEqualTo(1);
    }

    @Test
    public void shouldCreateLocalDate3() {
        LocalDate date = LocalDate.of(2017, Month.JUNE, 20)
                .with(TemporalAdjusters.lastDayOfMonth());

        assertThat(date.getYear()).isEqualTo(2017);
        assertThat(date.getMonth()).isEqualTo(Month.JUNE);
        assertThat(date.getDayOfMonth()).isEqualTo(30);
    }

    @Test
    public void shouldCreateLocalDate4() {
        LocalDate date = LocalDate.of(2017, Month.JUNE, 20)
                .with(TemporalAdjusters.next(DayOfWeek.FRIDAY));

        assertThat(date.getYear()).isEqualTo(2017);
        assertThat(date.getMonth()).isEqualTo(Month.JUNE);
        assertThat(date.getDayOfMonth()).isEqualTo(23);
    }
}
