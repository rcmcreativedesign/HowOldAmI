package com.rcmcreativedesign.howoldami;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private long currentlySelectedLong = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CalendarView calendar = (CalendarView) findViewById(R.id.calendarView);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                Calendar c = Calendar.getInstance();
                c.set(year, month, day);
                currentlySelectedLong = c.getTimeInMillis();
            }
        });
    }

    public void submitButton_click(View view) {
        LocalDate selectedDate = currentlySelectedLong > 0 ?
                new Date(currentlySelectedLong).toInstant().atZone(ZoneId.systemDefault()).toLocalDate() :
                LocalDate.now();
        Age calculator = new Age();
        calculator.calculate(selectedDate.toString(), LocalDate.now().toString());
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(calculator.getDisplay());
    }


}