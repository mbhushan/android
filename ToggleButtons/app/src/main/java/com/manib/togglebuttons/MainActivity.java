package com.manib.togglebuttons;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayStates(View view) {
        ToggleButton btn1View = (ToggleButton) findViewById(R.id.toggle_btn_1);
        ToggleButton btn2View = (ToggleButton) findViewById(R.id.toggle_btn_2);
        Button btnView = (Button) findViewById(R.id.display_btn);

        StringBuffer sb = new StringBuffer();
        sb.append("Toggle Button One: " + btn1View.getText().toString());
        sb.append("\nToggle Button Two: " + btn2View.getText().toString());

        Toast toast = Toast.makeText(getApplicationContext(), sb.toString(), Toast.LENGTH_SHORT);
        toast.show();
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