package com.manib.autocomplete;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;


public class MainActivity extends ActionBarActivity {

    private String [] names = {"Lasandra","Micheline","Anton","Ngoc ","Lurlene ","Melisa ","Audrie",
            "Dulce ","Milford ","Dacia ","Olympia ","Alberto ","Madeline ","Valorie ","Hassan ",
            "Rosita ","Margeret ","Donovan ","Rosalyn ","Camelia ","Trinity ","Emil ","Glennis ",
            "Reanna ","Fawn ","Kera ","Elliot ","Klara ","Melaine ","Vesta ","Martine ","Venus ",
            "Adella ","Forrest ","Felix ","Norberto ","Kazuko ","Gabriela ","Alesia ","Porter ",
            "Natacha ","Gary ","Lauralee ","Roseanne ","Douglass ","Jacquelynn ","Katie ","Joyce ",
            "Jeanice","Criselda"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AutoCompleteTextView actv = (AutoCompleteTextView) findViewById(R.id.autocomplete_id);
        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, R.layout.abc_simple_dropdown_hint, names);
        actv.setThreshold(1);
        actv.setAdapter(adp);
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
