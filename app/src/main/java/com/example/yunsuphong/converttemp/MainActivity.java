package com.example.yunsuphong.converttemp;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar tempBar = (SeekBar)findViewById(R.id.tempBar);
        final TextView textView = (TextView)findViewById(R.id.textView);

        tempBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar tempBar, int progress, boolean fromUser) {
                int celsius = progress;
                String degree = "\u00B0";	//Unicode degree symbol
                //String stringFormat = getString(R.string.stringFormat);
                Resources res = getResources();
                textView.setText(String.format(res.getString(R.string.stringFormat),
                        32f + celsius * 9f / 5f, degree, celsius, degree));

                float[] hsvColor = {0, 1, 1};
                // generate only hue component in range [0, 360),
                // leaving saturation and brightness maximum possible
                hsvColor[0] = 360f * progress / 100;
                tempBar.setBackgroundColor(Color.HSVToColor(hsvColor));
            }

            @Override
            public void onStartTrackingTouch(SeekBar tempBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar tempBar) {
            }
        });
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
