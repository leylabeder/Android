package com.leylabeder.haydiyakala;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class TenthActivity extends AppCompatActivity {

    TextView timeText;
    TextView scorText;
    TextView bestText;
    Integer number=0;
    ImageView imageView00;
    ImageView imageView01;
    ImageView imageView02;
    ImageView imageView10;
    ImageView imageView11;
    ImageView imageView12;
    ImageView imageView20;
    ImageView imageView21;
    ImageView imageView22;
    ImageView line1ImageView;
    ImageView line2ImageView;
    ImageView[] imageArray;
    Handler handler;
    Runnable runnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenth);

        //initialize
        timeText=findViewById(R.id.timeText);
        scorText=findViewById(R.id.scorText);
        bestText=findViewById(R.id.bestText);
        imageView00=findViewById(R.id.imageView00);
        imageView01=findViewById(R.id.imageView01);
        imageView02=findViewById(R.id.imageView02);
        imageView10=findViewById(R.id.imageView10);
        imageView11=findViewById(R.id.imageView11);
        imageView12=findViewById(R.id.imageView12);
        imageView20=findViewById(R.id.imageView20);
        imageView21=findViewById(R.id.imageView21);
        imageView22=findViewById(R.id.imageView22);

        line1ImageView=findViewById(R.id.line1ImageView);
        line2ImageView=findViewById(R.id.line2ImageView);

        imageArray=new ImageView[]{imageView00,imageView01,imageView02,
                imageView10,imageView11,imageView12,
                imageView20,imageView21,imageView22};
        hidenImages();


        new CountDownTimer(60000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                timeText.setText("Zaman: "+millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                timeText.setText("Zaman Bitti");
                handler.removeCallbacks(runnable);

                for(ImageView image:imageArray){
                    image.setVisibility(View.INVISIBLE);
                }

                AlertDialog.Builder alert=new AlertDialog.Builder(TenthActivity.this);

                alert.setTitle("Yeniden Başlat");
                alert.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent=getIntent();
                        finish();
                        startActivity(intent);
                    }
                });
                alert.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(TenthActivity.this,"Oyun Bitti",Toast.LENGTH_LONG);
                    }
                });
                alert.show();
            }
        }.start();
    }
    public void increaseScor(View view){
        number++;
        scorText.setText("Skor: "+number);
        if(number>=30){
            AlertDialog.Builder alert=new AlertDialog.Builder(TenthActivity.this);

            alert.setTitle("Tebrikler, Level tamamlandı");
            alert.setMessage("Devam etmek ister misiniz?");
            alert.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    Intent intent=new Intent(TenthActivity.this, EleventhActivity.class);
                    startActivity(intent);


                }
            });
            alert.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent=new Intent(TenthActivity.this,MainActivity.class);
                    startActivity(intent);
                    //Toast.makeText(FirstActivity.this,"Game Over",Toast.LENGTH_LONG);
                }
            });
            alert.show();

        }
    }
    public void hidenImages(){

        handler=new Handler();
        runnable= new Runnable() {
            @Override
            public void run() {
                for(ImageView image:imageArray){
                    image.setVisibility(View.INVISIBLE);
                }
                Random random=new Random();
                int i=random.nextInt(9);
                imageArray[i].setVisibility(View.VISIBLE);

                handler.postDelayed(this,250);


            }
        };
        handler.post(runnable);
    }

    public void exitClick(View view){
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
    public void restartClick(View view){
        Intent intent=new Intent(TenthActivity.this,MainActivity.class);
        startActivity(intent);
    }
}
