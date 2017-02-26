package com.philunteer.philunteer;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CreateEventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);
    }

    public void onClickAddEventInfo(View view) {
        // Add a new student record
        ContentValues values = new ContentValues();
        values.put(EventInfoProvider.EVENT_NAME,
                ((EditText)findViewById(R.id.editText2)).getText().toString());

        values.put(EventInfoProvider.EVENT_DATE,
                ((EditText)findViewById(R.id.editText5)).getText().toString());

        values.put(EventInfoProvider.EVENT_TIME,
                ((EditText)findViewById(R.id.editText3)).getText().toString());

        values.put(EventInfoProvider.EVENT_DESCRIPTON,
                ((EditText)findViewById(R.id.editText6)).getText().toString());

        Uri uri = getContentResolver().insert(
                EventInfoProvider.CONTENT_URI, values);

        Toast.makeText(getBaseContext(),
                uri.toString(), Toast.LENGTH_LONG).show();
    }

    public void onClickRetrieveStudents(View view) {
        // Retrieve student records
        String URL = "content://com.philunteer.philunteer";

        Uri organizations = Uri.parse(URL);
        Cursor c = managedQuery(organizations, null, null, null, "organization");

        if (c.moveToFirst()) {
            do{
                Toast.makeText(this,
                        c.getString(c.getColumnIndex(EventInfoProvider.EVENT_NAME)) +
                                ", " +  c.getString(c.getColumnIndex( EventInfoProvider.EVENT_DATE)) +
                                ", " + c.getString(c.getColumnIndex( EventInfoProvider.EVENT_TIME)) +
                                ", " + c.getString(c.getColumnIndex( EventInfoProvider.EVENT_DESCRIPTON)),
                        Toast.LENGTH_SHORT).show();
            } while (c.moveToNext());
        }

}
}
