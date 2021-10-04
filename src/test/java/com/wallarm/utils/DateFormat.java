package com.wallarm.utils;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class DateFormat extends java.util.GregorianCalendar {

    /**
     * Constructs a default <code>GregorianCalendar</code> using the current time
     * in the default time zone with the default
     * {@link Locale.Category#FORMAT FORMAT} locale.
     */
    public DateFormat() {
        super();
    }

    /**
     * Convert date to String.
     *
     * @return dd/mm/YYYY hh:mm
     */
    @Override
    public String toString() {
        return String.format("%s/%s/%s %s:%s", super.get(DAY_OF_MONTH), super.get(MONTH) + 1, super.get(YEAR), super.get(HOUR_OF_DAY), super.get(MINUTE));
    }

    /**
     * Convert date to String
     *
     * @param pattern dateTime format
     * @return
     */
    public String toDate(String pattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(super.getTime());
    }

    /**
     * Convert date to string by a specific format
     *
     * @param pattern dateTime format
     * @return formatted time
     */
    public String toTime(String pattern) {
        return new SimpleDateFormat(pattern).format(super.getTime());
    }

}
