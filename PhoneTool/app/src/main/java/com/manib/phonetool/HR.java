package com.manib.phonetool;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;


public class HR extends ActionBarActivity {

    public static ViewPager viewPager;
    private static String[] names = {

            "Anuradha Bansal",
            "Ajith P",
            "Sneha Sindhe",
            "Prajwal Kumar",
            "Rinki Goel",

    };

    private int[] mImages = new int[]{
            R.drawable.anu,
            R.drawable.ajith,
            R.drawable.sneha,
            R.drawable.prajwal,
            R.drawable.rinki,
    };

    private String[] mMobileNums = new String[]{
            "tel:9632251047",
            "tel:9844145874",
            "tel:9964972031",
            "tel:9481510427",
            "tel:9739099370",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hr);

        viewPager = (ViewPager) findViewById(R.id.view_pager);

        ImagePagerAdapter adapter = new ImagePagerAdapter(HR.this, mImages, names, mMobileNums);
        viewPager.setAdapter(adapter);
    }

    private class ImagePagerAdapter extends PagerAdapter {

        private Button click;
        private Context context;
        private int[] mImages;
        private String[] names;
        private String[] mMobileNums;


        public ImagePagerAdapter(Context context, int[] mImages, String[] names, String[] mMobileNums) {
            this.context = context;
            this.mImages = mImages;
            this.names = names;
            this.mMobileNums = mMobileNums;

        }


        @Override
        public int getCount() {
            return mImages.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((RelativeLayout) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, final int position) {

            Context context = HR.this;

            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View convertView = inflater.inflate(R.layout.hres, container, false);
            ImageView imageView = (ImageView) convertView
                    .findViewById(R.id.imageHR);

            int padding = context.getResources().getDimensionPixelSize(
                    R.dimen.padding_medium);
            imageView.setPadding(padding, padding, padding, padding);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setImageResource(mImages[position]);

            TextView topText = (TextView) convertView
                    .findViewById(R.id.topText);
            topText.setText(HR.names[position]);



            Button click = (Button) convertView.findViewById(R.id.btn_contact);
            click.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse(mMobileNums[position]));
                    startActivity(callIntent);

                }
            });
            ((ViewPager) container).addView(convertView, 0);
            return convertView;

        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager) container).removeView((RelativeLayout) object);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hr, menu);
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
