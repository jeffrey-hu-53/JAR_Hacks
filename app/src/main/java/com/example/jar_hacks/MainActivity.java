package com.example.jar_hacks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mDatabase = FirebaseDatabase.getInstance().getReference().child("JAR");
//        mDatabase.push().setValue("hello");


        Button donatorButt = (Button) findViewById(R.id.donatorButt);

        donatorButt.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, DonatorActivity.class));
            }
        });

        Button doneeButt = (Button) findViewById(R.id.doneeButt);

        doneeButt.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, DoneeActivity.class));
            }
        });

        Button infoButt = (Button) findViewById(R.id.infoButt);

        infoButt.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, InfoActivity.class));
            }
        });
    }


}