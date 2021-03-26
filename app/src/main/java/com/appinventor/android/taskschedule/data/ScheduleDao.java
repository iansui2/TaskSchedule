package com.appinventor.android.taskschedule.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.TypeConverters;
import androidx.room.Update;

import com.appinventor.android.taskschedule.util.DateTypeConverter;

import java.util.List;

@Dao
@TypeConverters(DateTypeConverter.class)
public interface ScheduleDao {

    @Insert
    void insert(Schedule schedule);

    @Update
    void update(Schedule schedule);

    @Delete
    void delete(Schedule schedule);

    @Query("DELETE FROM schedule")
    void deleteAllSchedules();

    @Query("SELECT * FROM schedule ORDER BY title ASC")
    LiveData<List<Schedule>> getAllSchedules();
}

