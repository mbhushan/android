package com.example.android.justjava;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.NumberFormat;


public class MainActivity extends ActionBarActivity {

    private static int QTY = 0;
    private static String TOTAL = "Total";
    private static double PRICE_PER_COFFEE = 20.0;
    private String name = "Mani Bhushan";
    private String topping = "No";

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

    private double calculatePrice() {
        double price = QTY * PRICE_PER_COFFEE;
        return price;
    }

    private String createOrderSummary() {
        StringBuffer sb = new StringBuffer();
        CheckBox checkBox = (CheckBox) findViewById(R.id.topping_checkbox);
        boolean flag = checkBox.isChecked();

        if (flag) {
            topping = "Yes";
        } else {
            topping = "No";
        }

        sb.append("Name: " + name);
        sb.append("\nAdd whipped cream: " + topping);
        sb.append("\nQuantity: " + QTY);
        double totalPrice = calculatePrice();

        sb.append("\nTotal: " + NumberFormat.getCurrencyInstance().format(totalPrice));
        sb.append("\nThank You!");

        return sb.toString();
    }


    /**
     * This method is called when the order button is clicked.
     * @param view
     */
    public void submitOrder(View view) {
        String orderSummary = createOrderSummary();
        displayOrderSummary(orderSummary);
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
    private void displayOrderSummary(String orderSummary) {
        TextView priceTV = (TextView) findViewById(R.id.order_summary_text_view);
        priceTV.setText(orderSummary);
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
