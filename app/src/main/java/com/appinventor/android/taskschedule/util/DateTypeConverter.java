package com.appinventor.android.taskschedule.util;

import android.util.Log;

import androidx.room.TypeConverter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import static android.content.ContentValues.TAG;


public class DateTypeConverter {

    static DateFormat dateFormat = new SimpleDateFormat("H:mm", Locale.getDefault());

    static {
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    }

    @TypeConverter
    public static Date timeToDate(String value) {
        if (value != null) {
            try {
                return dateFormat.parse(value);
            } catch (ParseException e) {
                Log.e(TAG, e.getMessage());
            }
            return null;
        } else {
            return null;
        }
    }

    @TypeConverter
    public static String dateToTime(Date value) {
        if (value != null) {
            return dateFormat.format(value);
        } else {
            return null;
        }
    }
}
