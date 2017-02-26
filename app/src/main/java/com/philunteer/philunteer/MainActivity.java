package com.philunteer.philunteer;

import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button volunteerButton;
    private Button organizationButton;
    public static String prefIsVolunteer = "is a volunteer";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        volunteerButton = (Button) findViewById(R.id.volunteerButton);
        volunteerButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                VolunteerSignIn();

            }

        });


        organizationButton = (Button) findViewById(R.id.organizationButton);
        organizationButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                OrganizationSignIn();

            }

        });
    }



    private void VolunteerSignIn() {
        PreferenceManager.getDefaultSharedPreferences(getApplicationContext())
                .edit().putBoolean(prefIsVolunteer, true).apply();

        Intent intent = new Intent(this, VolunteerActivity.class);

        startActivity(intent);

    }

    private void OrganizationSignIn() {
        PreferenceManager.getDefaultSharedPreferences(getApplicationContext())
                .edit().putBoolean(prefIsVolunteer, false).apply();

        Intent intent = new Intent(this, OrganizationActivity.class);

        startActivity(intent);

    }


}
