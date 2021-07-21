package com.company.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateUtils
{
    public static Date dateAfterDays(int days) {
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, days);
        return calendar.getTime();
    }

    public static long diffInDays(Date startDate, Date endDate) {
        long diff = startDate.getTime() - endDate.getTime();
        long days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        return diff < 0 ? -days : days;
    }
}
