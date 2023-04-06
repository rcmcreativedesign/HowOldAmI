package com.rcmcreativedesign.howoldami;

import java.time.LocalDate;

public class Age {
    private Integer _years;
    private Integer _months;
    private Integer _days;

    public Integer getYears() {
        return _years;
    }

    public Integer getMonths() {
        return _months;
    }

    public Integer getDays() {
        return _days;
    }

    public void calculate(String userDate, String compareDate) {
        if (!validateUserDate(userDate) || !validateUserDate(compareDate))
            return;
        try {
            LocalDate date = LocalDate.parse(userDate);
            LocalDate compare = LocalDate.parse(compareDate);
            if (date.isAfter(compare))
                return;
            _years = compare.getYear() - date.getYear();
            _months = compare.getMonthValue() - date.getMonthValue();
            if (_months < 0) {
                _years--;
                _months += 12;
            }
            _days = compare.getDayOfMonth() - date.getDayOfMonth();
            if (_days < 0) {
                _months--;
                _days += date.plusMonths(1).lengthOfMonth();
            }
        }
        catch (Exception e)
        {}
    }

    private boolean validateUserDate(String userDate) {
        try {
            LocalDate date = LocalDate.parse(userDate);
            if (date != null)
                return true;
        }
        catch (Exception e)
        {
            return false;
        }
        return false;
    }

    public String getDisplay() {
        StringBuilder sb = new StringBuilder();

        if (_years > 0) {
            if (_years == 1)
                sb.append(1).append(" year");
            else
                sb.append(_years).append(" years");
        }

        if (_months > 0 && sb.length() > 0)
            sb.append(", ");

        if (_months > 0) {
            if (_months == 1)
                sb.append(1).append(" month");
            else
                sb.append(_months).append(" months");
        }

        if (_days > 0 && sb.length() > 0)
            sb.append(", ");

        if (_days > 0) {
            if (_days == 1)
                sb.append(1).append(" day");
            else
                sb.append(_days).append(" days");
        }

        if (sb.length() > 0)
            sb.append(" old.").insert(0, "You are ");

        return sb.toString();
    }
}
