package com.rcmcreativedesign.howoldami;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class UtilsTest {
    @Test
    public void calculateAge() {
        LocalDate testDate = LocalDate.of(2001,1,1);
        // Get system ZoneId
        ZoneId localZone = ZoneId.systemDefault();
        LocalDate nowDate = LocalDate.now(localZone);

        Long age = ChronoUnit.YEARS.between(testDate, nowDate);

        Assert.assertTrue(age > 0);
    }

    @Test
    public void calculateAgeCalculates() {
        LocalDate compareDate = LocalDate.of(2023,3, 4);
        LocalDate testDate = LocalDate.of(2023,1,4);
        Age calculator = new Age();
        calculator.calculate(testDate.toString(), compareDate.toString());
        Assert.assertEquals((Integer)0, calculator.getYears());

        testDate = LocalDate.of(2022, 4, 1);
        calculator.calculate(testDate.toString(), compareDate.toString());
        Assert.assertEquals((Integer)0, calculator.getYears());
    }

    @Test
    public void calculateAgeDisplays() {
        LocalDate compareDate = LocalDate.of(2023,3, 4);
        LocalDate testDate = LocalDate.of(2023,1,4);
        Age calculator = new Age();
        calculator.calculate(testDate.toString(), compareDate.toString());
        Assert.assertEquals("You are 2 months old.", calculator.getDisplay());

        compareDate = LocalDate.of(2023, 4, 4);
        testDate = LocalDate.of(2022, 3, 3);
        calculator.calculate(testDate.toString(), compareDate.toString());
        Assert.assertEquals("You are 1 year, 1 month, 1 day old.", calculator.getDisplay());
    }


}
