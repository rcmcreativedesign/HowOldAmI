package com.rcmcreativedesign.howoldami;

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

    public void calculate(String userDate) {

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
            sb.append(",");

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
