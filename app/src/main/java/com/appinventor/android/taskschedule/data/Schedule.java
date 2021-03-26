package com.appinventor.android.taskschedule.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.appinventor.android.taskschedule.util.DateTypeConverter;

import java.util.Date;

@Entity(tableName = "schedule")
public class Schedule {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;

    @ColumnInfo(name = "start_time")
    @TypeConverters(DateTypeConverter.class)
    private Date startTime;

    @ColumnInfo(name = "end_time")
    @TypeConverters(DateTypeConverter.class)
    private Date endTime;

    @ColumnInfo(name = "done")
    private int isDone;


    public Schedule(String title, Date startTime, Date endTime, int isDone) {
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.isDone = isDone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() { return title; }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public int getIsDone() { return isDone; }
}
