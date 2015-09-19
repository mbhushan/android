package com.manib.basketball;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends ActionBarActivity {
    private int aScore = 0;
    private final int THREE = 3;
    private final int TWO = 2;
    private final int ONE = 1;

    private void displayATeamScore(int score) {
        aScore += score;
        TextView aScoreTV = (TextView) findViewById(R.id.a_teamscore);
        aScoreTV.setText(String.valueOf(aScore));

    }

    public void incrementByThree(View view) {
        displayATeamScore(THREE);
    }

    public void incrementByTwo(View view) {
        displayATeamScore(TWO);
    }

    public void incrementByOne(View view) {
        displayATeamScore(ONE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
