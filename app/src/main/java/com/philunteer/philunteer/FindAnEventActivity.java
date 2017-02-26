package com.philunteer.philunteer;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.CalendarView;
import android.content.Context;
import android.content.DialogInterface;

public class FindAnEventActivity extends AppCompatActivity {
    private CalendarView calendarID;
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_an_event);

        calendarID = (CalendarView) findViewById(R.id.calendarView);
        calendarID.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                if (PreferenceManager.getDefaultSharedPreferences(getApplicationContext())
                        .getBoolean(MainActivity.prefIsVolunteer, true)) {
                    AlertDialog.Builder seeEventBuilder = new AlertDialog.Builder(context);
                    seeEventBuilder.setTitle("Event Description");
                    seeEventBuilder.setMessage("Organization Name: FemmeHacks" + "\n" + "\n"
                            + "Event Date: 02/25/2017 " + "\n" + "\n"
                            + "Event Time: 7:30 am - 11:00 pm" + "\n" + "\n"
                            + "Event Description: FemmeHacks is Penn's premier all-female* " +
                            "hackathon for women-identifying individuals hosted by" +
                            " Women in Computer Science (WICS). Our goal " +
                            " is to inspire, teach, and empower women* in the Philly tech community " +
                            "and beyond. Hacking, food, swag, and friends! What else can you wish for?" +
                            "\n" + "\n" + "Equality for all, y'all.");
                    seeEventBuilder.setCancelable(true);

                    seeEventBuilder.setPositiveButton(
                            "Sign-Up",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.dismiss();
                                }
                            });

                    seeEventBuilder.setNegativeButton(
                            "Cancel",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.dismiss();
                                }
                            });

                    AlertDialog seeEventAlert = seeEventBuilder.create();
                    seeEventAlert.show();
                }
                else {
                    AlertDialog.Builder createEventBuilder = new AlertDialog.Builder(context);
                    createEventBuilder.setTitle("Create New Event");
                    createEventBuilder.setCancelable(true);
                    createEventBuilder.setMessage("Do you want to create a new event?");

                    createEventBuilder.setPositiveButton(
                            "Yes",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    CreateEvent();
                                }
                            });

                    createEventBuilder.setNegativeButton(
                            "No",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

                    AlertDialog createEventAlert = createEventBuilder.create();
                    createEventAlert.show();
                }
            }
        });


    }

    private void CreateEvent() {

        Intent intent = new Intent(this, CreateEventActivity.class);

        startActivity(intent);

    }
}
