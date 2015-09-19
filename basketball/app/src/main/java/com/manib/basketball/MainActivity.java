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
    private int bScore = 0;
    private final int THREE = 3;
    private final int TWO = 2;
    private final int ONE = 1;

    public void resetScores(View view) {
        aScore = 0;
        bScore = 0;
        displayATeamScore(aScore);
        displayBTeamScore(bScore);
    }

    private void displayATeamScore(int score) {
        TextView aScoreTV = (TextView) findViewById(R.id.a_teamscore);
        aScoreTV.setText(String.valueOf(score));

    }

    private void displayBTeamScore(int score) {
        TextView bScoreTV = (TextView) findViewById(R.id.b_teamscore);
        bScoreTV.setText(String.valueOf(score));

    }

    public void aIncrementByThree(View view) {
        aScore += THREE;
        displayATeamScore(aScore);
    }

    public void aIncrementByTwo(View view) {
        aScore += TWO;
        displayATeamScore(aScore);
    }

    public void aIncrementByOne(View view) {
        aScore += ONE;
        displayATeamScore(aScore);
    }

    public void bIncrementByThree(View view) {
        bScore += THREE;
        displayBTeamScore(bScore);
    }

    public void bIncrementByTwo(View view) {
        bScore += TWO;
        displayBTeamScore(bScore);
    }

    public void bIncrementByOne(View view) {
        bScore += ONE;
        displayBTeamScore(bScore);
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
