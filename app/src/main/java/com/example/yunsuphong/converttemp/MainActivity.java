package com.example.yunsuphong.converttemp;

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
                textView.setText(String.format(getString(R.string.stringFormat),
                        32f + celsius * 9f / 5f, degree, celsius, degree));
                int red = 255 * progress / 100;
                int blue = 255 * (100 - progress) / 100;
                tempBar.setBackgroundColor(Color.argb(255, red, 0, blue));
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
