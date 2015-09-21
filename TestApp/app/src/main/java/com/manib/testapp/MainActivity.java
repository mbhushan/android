package com.manib.testapp;

import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private String message = "I'm so full";
    private String drawableName = "after_cookie";


    public void eatCookie(View view) {
        int resId = getResources().getIdentifier(drawableName, "drawable", getPackageName());

        ImageView imgView = (ImageView) findViewById(R.id.cookie_img);
        TextView usermsg = (TextView) findViewById(R.id.user_msg);
        Button btn = (Button) findViewById(R.id.btn_eat);

        usermsg.setText(message);
        imgView.setImageResource(resId);
        //btn.setClickable(false);
        //ImageView imageView = (ImageView) findViewById(R.id.android_cookie_image_view);
        //imageView.setImageResource(R.drawable.after_cookie);
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
