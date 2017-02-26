package com.philunteer.philunteer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OrganizationActivity extends AppCompatActivity {
    Button findEventButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organization_sign_in);

        findEventButton = (Button) findViewById(R.id.findEventButton);
        findEventButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                FindAnEvent();
            }

        });
    }

    private void FindAnEvent() {

        Intent intent = new Intent(this, FindAnEventActivity.class);

        startActivity(intent);

    }

}
