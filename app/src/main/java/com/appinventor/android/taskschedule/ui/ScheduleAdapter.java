package com.appinventor.android.taskschedule.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.appinventor.android.taskschedule.R;
import com.appinventor.android.taskschedule.data.Schedule;
import com.appinventor.android.taskschedule.util.DateTypeConverter;

import java.util.ArrayList;
import java.util.List;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ScheduleHolder> {

    private List<Schedule> schedules = new ArrayList<>();

    @NonNull
    @Override
    public ScheduleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.schedule_item, parent, false);
        return new ScheduleHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleHolder holder, int position) {
        Schedule currentSchedule = schedules.get(position);
        String formattedStartTime = DateTypeConverter.dateToTime(currentSchedule.getStartTime());
        String formattedEndTime = DateTypeConverter.dateToTime(currentSchedule.getEndTime());
        String formattedIsDone = String.valueOf(currentSchedule.getIsDone());

        holder.textViewTitle.setText(currentSchedule.getTitle());
        holder.textViewStartTime.setText(formattedStartTime);
        holder.textViewEndTime.setText(formattedEndTime);
        holder.textViewIsDone.setText(formattedIsDone);
    }

    @Override
    public int getItemCount() {
        return schedules.size();
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
        notifyDataSetChanged();
    }

    class ScheduleHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitle;
        private TextView textViewStartTime;
        private TextView textViewEndTime;
        private TextView textViewIsDone;

        public ScheduleHolder(View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.text_view_title);
            textViewStartTime = itemView.findViewById(R.id.text_view_start_time);
            textViewEndTime = itemView.findViewById(R.id.text_view_end_time);
            textViewIsDone = itemView.findViewById(R.id.text_view_is_done);
        }
    }
}
