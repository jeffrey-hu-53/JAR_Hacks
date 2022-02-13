package com.example.jar_hacks;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import android.graphics.Bitmap;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;


public class DonatorActivity extends AppCompatActivity {
    DatabaseReference mDatabase;
    Bitmap pic;
    ImageView imageView;
    Button button;
    private FusedLocationProviderClient client;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.donator_main);

        imageView = findViewById(R.id.imageview);
        button = findViewById(R.id.pictureButt);

        //Request for camera runtime permission
        if (ContextCompat.checkSelfPermission(DonatorActivity.this, Manifest.permission.CAMERA)
        != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(DonatorActivity.this, new String[]{
                    Manifest.permission.CAMERA
            }, 100);
        }

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 100);
                System.out.println("onClick take a picture");
            }
        });

        requestPermission();
        client = LocationServices.getFusedLocationProviderClient(this);
        Button button = findViewById(R.id.submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(DonatorActivity.this, ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ) {
                    return;
                }
                client.getLastLocation().addOnSuccessListener(DonatorActivity.this, new OnSuccessListener(){
                    @Override
                    public void onSuccess(Object o) {
                        Location location = (Location)o;
                        System.out.println(location.toString());
                        System.out.println(location.getLatitude());
                        double lat = location.getLatitude();
                        double longitude = location.getLongitude();
                        String desc = "desc";
                        // I BROKE YOUR DATABASE HERE
//                        String imageB64 = getImageData(pic);
                        int imageB64 = 1;
                        // Send to data base
                        Picture field = new Picture(lat,longitude,desc, imageB64);

                        mDatabase = FirebaseDatabase.getInstance().getReference("picture");
                        mDatabase.push().setValue(field);
                        System.out.println("sent to database");

                    }
                });
                startActivity(new Intent(DonatorActivity.this, MainActivity.class));
            }
        });
    }

    public String getImageData(Bitmap bmp) {

//        ByteArrayOutputStream bao = new ByteArrayOutputStream();
//        bmp.compress(Bitmap.CompressFormat.PNG, 100, bao); // bmp is bitmap from user image file
//        bmp.recycle();
//        byte[] byteArray = bao.toByteArray();
//        String imageB64 = Base64.encodeToString(byteArray, Base64.URL_SAFE);
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
//        byte[] byteArray = byteArrayOutputStream .toByteArray();
//        String imageB64 = Base64.encodeToString(byteArray, Base64.DEFAULT);
        String imageB64 = ImageUtil.convert(bmp);
        return imageB64;
    }
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap((bitmap));
            //Saving picture as a bitmap

            pic = bitmap;
            try{
               if(pic == null){
                   System.out.println("ITS NULL IDIOT");
               }
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        System.out.println("After taking picture");
    }

    private void requestPermission(){
        ActivityCompat.requestPermissions(this, new String[]{ACCESS_FINE_LOCATION}, 1);
    }

}