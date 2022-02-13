package com.example.jar_hacks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.net.URL;
import java.util.ArrayList;

public class DoneeActivity extends AppCompatActivity {

    private ListView listView;
    private PictureAdapter pAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.donee_main);

        listView = (ListView)findViewById(R.id.listView);

        ArrayList<Picture> arrayList = new ArrayList<>();

        arrayList.add(new Picture(40.9047962, -73.1327196, "behind walgreens", R.drawable.demo));
        arrayList.add(new Picture(40.8047962, -73.1327196, "right of cvs", R.drawable.garbage2));
        arrayList.add(new Picture(40.7047962, -73.1327196, "left of shoprite", R.drawable.garbage3));
        arrayList.add(new Picture(40.6047962, -73.1327196, "in front of staples", R.drawable.garbage4));

//        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);

        pAdapter = new PictureAdapter(this, arrayList);
        listView.setAdapter(pAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(DoneeActivity.this, "clicked item: " + i + " " + arrayList.get(i), Toast.LENGTH_SHORT).show();
                float lat = (float)arrayList.get(i).getLat();
                float lon = (float)arrayList.get(i).getLon();

                Uri gmmIntentUri = Uri.parse("geo:" + lat + "," + lon + "?q=");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

//        Button doneeMapButt = (Button) findViewById(R.id.doneeMapButt);
//
//        //Coordinates so google maps knows where to zoom in
//        float lat = (float)40.9047962;
//        float lon = (float)-73.1327196;
//
//        doneeMapButt.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v){
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        Uri gmmIntentUri = Uri.parse("geo:" + lat + "," + lon + "?q=");
//                        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
//                        mapIntent.setPackage("com.google.android.apps.maps");
//                        startActivity(mapIntent);
//                    }
//                }, 1000);
//            }
//        });
    }
}


