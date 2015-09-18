package com.example.android.justjava;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.NumberFormat;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     * @param view
     */
    public void submitOrder(View view) {
        int numOfCoffee = 2;
        double coffeePrice = 20.0;
        display(numOfCoffee);
        double totalPrice = numOfCoffee * coffeePrice;
        displayPrice(totalPrice);
    }

    /**
     * Displays given quantity on screen
     * @param number
     * @return void
     */
    private void display(int number) {
        TextView quantityTV = (TextView) findViewById(R.id.quantity_text_view);
        quantityTV.setText("" + number);
    }

    /**
     * This method displays the given price on the screen
     * @return
     */
    private void displayPrice(double number) {
        TextView priceTV = (TextView) findViewById(R.id.total_price_text_view);
        priceTV.setText(NumberFormat.getCurrencyInstance().format(number));
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
