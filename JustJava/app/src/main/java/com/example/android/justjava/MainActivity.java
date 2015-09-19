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

    private static int QTY = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increment(View view) {
        QTY += 1;
        displayQuantity();
    }

    public void decrement(View view) {
        if (QTY > 0) {
            QTY -= 1;
        }
        displayQuantity();
    }

    /**
     * This method is called when the order button is clicked.
     * @param view
     */
    public void submitOrder(View view) {
        double price = 20.0;
        displayQuantity();
        double totalPrice = QTY * price;
        displayTotalPrice(totalPrice);
    }

    /**
     * Displays given quantity on screen
     * @return void
     */
    private void displayQuantity() {
        TextView quantityTV = (TextView) findViewById(R.id.quantity_text_view);
        quantityTV.setText("" + QTY);
    }

    /**
     * This method displays the given price on the screen
     * @return
     */
    private void displayTotalPrice(double number) {
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
