package com.appinventor.android.taskschedule.data;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.appinventor.android.taskschedule.util.DateTypeConverter;

@Database(entities = {Schedule.class}, version = 5, exportSchema = false)
@TypeConverters(DateTypeConverter.class)
public abstract class ScheduleDatabase extends RoomDatabase {

    private static ScheduleDatabase instance;

    public abstract ScheduleDao scheduleDao();

    public static synchronized ScheduleDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    ScheduleDatabase.class, "schedule_database.db")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private ScheduleDao scheduleDao;

        private PopulateDbAsyncTask(ScheduleDatabase db) {
            scheduleDao = db.scheduleDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            scheduleDao.insert(new Schedule("Reading", DateTypeConverter.timeToDate("1:00"),
                    DateTypeConverter.timeToDate("3:00"),
                    1));
            scheduleDao.insert(new Schedule("Programming", DateTypeConverter.timeToDate("3:15"),
                                        DateTypeConverter.timeToDate("6:00"),
                                        1));
            scheduleDao.insert(new Schedule("Watching", DateTypeConverter.timeToDate("7:00"),
                    DateTypeConverter.timeToDate("8:00"),
                    1));
            return null;
        }
    }
}
