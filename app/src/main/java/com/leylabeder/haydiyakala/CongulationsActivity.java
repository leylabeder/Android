package com.leylabeder.haydiyakala;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CongulationsActivity extends AppCompatActivity {

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congulations);

        imageView=findViewById(R.id.imageView);
    }
    public void easyClick(View view){
        Intent intent=new Intent(CongulationsActivity.this, MainActivity.class);
        startActivity(intent);
    }
    public void exitClick(View view){
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
    public void instagramClick(View vi){

        Uri link= Uri.parse("https://www.instagram.com/juniorsoftwaredeveloper/");
        Intent intent=new Intent(Intent.ACTION_VIEW,link);
        startActivity(intent);
    }
}
