package com.rcmcreativedesign.howoldami;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;

import java.time.LocalDate;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitButton_click(View view) {
        CalendarView calendar = (CalendarView) view.findViewById(R.id.calendarView);
        LocalDate selectedDate = LocalDate.ofEpochDay(calendar.getDate());
        Age calculator = new Age();
        calculator.calculate(selectedDate.toString(), LocalDate.now().toString());
        TextView textView = (TextView) view.findViewById(R.id.textView);
        textView.setText(calculator.getDisplay());
    }
}