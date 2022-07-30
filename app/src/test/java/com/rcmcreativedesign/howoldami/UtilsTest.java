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
}
