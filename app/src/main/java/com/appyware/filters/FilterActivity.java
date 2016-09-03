package com.appyware.filters;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.SeekBar;

/**
 * Created by
 * --Vatsal Bajpai on
 * --03/09/16 at
 * --7:09 AM
 */
public class FilterActivity extends AppCompatActivity {

    ImageView ivPhoto;
    Drawable[] layers = new Drawable[2];
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        // Get reference to imageview
        ivPhoto = (ImageView) findViewById(R.id.iv_photo);
        seekBar = (SeekBar) findViewById(R.id.seekBar);

        // get data from incoming intent
        String imagepath = getIntent().getExtras().getString("path");
        String name = getIntent().getExtras().getString("name");

        setNormalPhoto(imagepath);
        //setFilterPhoto(imagepath);

        // Set title of the activity
        getSupportActionBar().setTitle(name);
    }

    private void setNormalPhoto(String imagepath) {
        // Set image in imageview
        ivPhoto.setImageBitmap(BitmapFactory.decodeFile(imagepath));
    }

    private void setFilterPhoto(String imagepath) {
        final Bitmap bitmap = BitmapFactory.decodeFile(imagepath);
        layers[0] = new BitmapDrawable(getResources(), bitmap);
        layers[1] = getResources().getDrawable(R.drawable.red_scape);
        LayerDrawable layerDrawable = new LayerDrawable(layers);
        layers[1].setAlpha(0);
        ivPhoto.setImageDrawable(layerDrawable);

        seekBar.setMax(200);
           /* To check seek bar value when moved */
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                layers[1].setAlpha(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
