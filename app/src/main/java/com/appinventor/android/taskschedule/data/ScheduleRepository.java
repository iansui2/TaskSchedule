package com.appinventor.android.taskschedule.data;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.appinventor.android.taskschedule.data.Schedule;
import com.appinventor.android.taskschedule.data.ScheduleDao;
import com.appinventor.android.taskschedule.data.ScheduleDatabase;

import java.util.List;

public class ScheduleRepository {
    private static ScheduleDao scheduleDao;
    private LiveData<List<Schedule>> allSchedule;

    public ScheduleRepository(Application application) {
        ScheduleDatabase database = ScheduleDatabase.getInstance(application);
        scheduleDao = database.scheduleDao();
        allSchedule = scheduleDao.getAllSchedules();
    }

    public void insert(Schedule schedule) {
        new InsertScheduleAsyncTask(scheduleDao).execute(schedule);
    }

    public void update(Schedule schedule) {
        new UpdateScheduleAsyncTask(scheduleDao).execute(schedule);
    }

    public void delete(Schedule schedule) {
        new DeleteScheduleAsyncTask(scheduleDao).execute(schedule);
    }

    public void deleteAllSchedules() {
        new DeleteAllScheduleAsyncTask(scheduleDao).execute();
    }

    public LiveData<List<Schedule>> getAllSchedules() {
        return allSchedule;
    }

    private static class InsertScheduleAsyncTask extends AsyncTask<Schedule, Void, Void> {

        private InsertScheduleAsyncTask(ScheduleDao scheduleDao) {
            scheduleDao = scheduleDao;
        }

        @Override
        protected Void doInBackground(Schedule... schedules) {
            scheduleDao.insert(schedules[0]);
            return null;
        }
    }

    private static class UpdateScheduleAsyncTask extends AsyncTask<Schedule, Void, Void> {

        private UpdateScheduleAsyncTask(ScheduleDao scheduleDao) {
            scheduleDao = scheduleDao;
        }

        @Override
        protected Void doInBackground(Schedule... schedules) {
            scheduleDao.update(schedules[0]);
            return null;
        }
    }

    private static class DeleteScheduleAsyncTask extends AsyncTask<Schedule, Void, Void> {

        private DeleteScheduleAsyncTask(ScheduleDao scheduleDao) {
            scheduleDao = scheduleDao;
        }

        @Override
        protected Void doInBackground(Schedule... schedules) {
            scheduleDao.delete(schedules[0]);
            return null;
        }
    }

    private static class DeleteAllScheduleAsyncTask extends AsyncTask<Void, Void, Void> {

        private DeleteAllScheduleAsyncTask(ScheduleDao scheduleDao) {
            scheduleDao = scheduleDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            scheduleDao.deleteAllSchedules();
            return null;
        }
    }
}
