package com.manib.spinnerdemo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private String[] celebrities = {
            "Chris Hemsworth",
            "Jennifer Lawrence",
            "Jessica Alba",
            "Brad Pitt",
            "Tom Cruise",
            "Johnny Depp",
            "Megan Fox",
            "Paul Walker",
            "Vin Diesel",
            "Kevin Spacey",
            "Kevin Bacon",
            "Mani Bhushan"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.spinner_items);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item, celebrities);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener () {
                    public void onItemSelected( AdapterView<?> parent, View view, int position, long id) {
                        String selection = parent.getItemAtPosition(position).toString();
                        Toast toast = Toast.makeText(getApplicationContext(), selection, Toast.LENGTH_SHORT);
                        toast.show();

                    }

                    public void onNothingSelected(AdapterView<?> parent) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Nothing Selected!", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
        );

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
