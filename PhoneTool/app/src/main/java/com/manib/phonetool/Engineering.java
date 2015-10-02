package com.manib.phonetool;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class Engineering extends ActionBarActivity {

    private int[] mImages = new int[] {
            R.drawable.anand,
            R.drawable.ks,
            R.drawable.atulm,
            R.drawable.manib,
            R.drawable.sidg,
            R.drawable.suresh,
            R.drawable.mukund,
            R.drawable.murthy,
            R.drawable.vaishakh,
            R.drawable.vinitb,
    };

    private String [] names = {
            "Anand Jain",
            "Kumar Siddhartha",
            "Atul Manwar",
            "Mani Bhushan",
            "Siddardha Garimella",
            "Suresh Mopuru",
            "Mukund K",
            "Murthy Kaja",
            "Vaishakh NR",
            "Vinit Bothra",
    };

    private String[] mMobileNums = new String[]{
            "tel:9845270455",
            "tel:7259102000",
            "tel:7760336453",
            "tel:9739099370",
            "tel:9008846426",
            "tel:8892150510",
            "tel:9739314574",
            "tel:9611338758",
            "tel:7411993776",
            "tel:9591236124"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_engineering);

        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        ImagePagerAdapter adapter = new ImagePagerAdapter(Engineering.this, mImages, names, mMobileNums);
        viewPager.setAdapter(adapter);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_engineering, menu);
        return true;
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
            Context context = Engineering.this;

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
            topText.setText(names[position]);



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
