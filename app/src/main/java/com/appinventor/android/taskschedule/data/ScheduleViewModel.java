package com.appinventor.android.taskschedule.data;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.appinventor.android.taskschedule.data.Schedule;
import com.appinventor.android.taskschedule.data.ScheduleRepository;

import java.util.List;

public class ScheduleViewModel extends AndroidViewModel {

    private ScheduleRepository repository;
    private LiveData<List<Schedule>> allSchedules;

    public ScheduleViewModel(Application application) {
        super(application);
        repository = new ScheduleRepository(application);
        allSchedules = repository.getAllSchedules();
    }

    public void insert(Schedule schedule) {
        repository.insert(schedule);
    }

    public void update(Schedule schedule) {
        repository.update(schedule);
    }

    public void delete(Schedule schedule) {
        repository.delete(schedule);
    }

    public void deleteAllSchedules() {
        repository.deleteAllSchedules();
    }

    public LiveData<List<Schedule>> getAllSchedules() {
        return allSchedules;
    }
}
