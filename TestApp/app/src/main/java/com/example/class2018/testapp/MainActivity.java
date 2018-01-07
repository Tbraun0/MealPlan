package com.example.class2018.testapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.res.*;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;

import org.joda.time.*;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View v1=new View(this);
        //Create the calender for the home page
        LocalDate currentdate = LocalDate.now();


        int thisMonthInt = currentdate.getMonthOfYear();

        String thisMonth = getMonthFromInt(thisMonthInt);
        LocalDate endOfMonth = currentdate.dayOfMonth().withMaximumValue();

        int daysInMonth = endOfMonth.getDayOfMonth();
        //Cycle through the monthlength and fill in the panels

        Resources res = getResources();
        for (int i=1;i<=daysInMonth;i++) {
            String idname = "textView" + Integer.toString(i);
            int id = res.getIdentifier(idname, "id", v1.getContext().getPackageName());
            TextView tv = (TextView)findViewById(id);
            tv.setText(Integer.toString(i));
        }

    }

    //WARNING: This function is retarded, and I'm too lazy to parse JODA's Datetime
    public String getMonthFromInt(int monthInInt) {
        switch (monthInInt) {
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
            default:
                return "JODA time be BROKEN";
        }
    }
}
