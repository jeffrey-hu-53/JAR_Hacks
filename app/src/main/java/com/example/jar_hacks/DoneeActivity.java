package com.example.jar_hacks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class DoneeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donee_main);

        Button doneeMapButt = (Button) findViewById(R.id.doneeMapButt);

        //Coordinates so google maps knows where to zoom in
        float lat = (float)40.9047962;
        float lon = (float)-73.1327196;

        doneeMapButt.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Uri gmmIntentUri = Uri.parse("geo:" + lat + "," + lon + "?q=");
                        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                        mapIntent.setPackage("com.google.android.apps.maps");
                        startActivity(mapIntent);
                    }
                }, 1000);
            }
        });
    }
}


