package com.example.karleinstein.iqtest;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Stats extends Activity {
    ImageButton btnBack;
    //FileOutputStream fileOutputStream;
    String zz1;
    TextView tvphanTram,tvYourIQ,tvComplete;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.stats);
        btnBack=findViewById(R.id.btnBack);
        tvComplete=findViewById(R.id.tvcomplete);
        tvphanTram=findViewById(R.id.tvphanTram);
        tvYourIQ=findViewById(R.id.tvyourIQ);
        AdView adView=findViewById(R.id.adView);
        AdRequest adRequest=new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Stats.this,MainActivity.class);
                startActivity(intent);
            }
        });
        yo();
        highscore();

    }

    private void highscore() {
        String dulieu;
        try {
            FileInputStream fileInputStream=openFileInput("levels.txt");
            InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer=new StringBuffer();
            while ((dulieu=bufferedReader.readLine())!=null)
            {
                stringBuffer.append(dulieu+"");
            }
            //TextView tvYourIQ=v.findViewById(R.id.tvYourIq);
            DecimalFormat decimalFormat=new DecimalFormat("#,##");
            tvComplete.setText(stringBuffer+"/27");
            double a=Double.parseDouble(String.valueOf(stringBuffer))/27*100;
            String b=decimalFormat.format(a);
            tvphanTram.setText(b+"%");
            bufferedReader.close();
            inputStreamReader.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void yo() {
        String dulieu;
        try {
            FileInputStream fileInputStream=openFileInput("Highscore.txt");
            InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer=new StringBuffer();
            while ((dulieu=bufferedReader.readLine())!=null)
            {
                stringBuffer.append(dulieu+"");
            }
            //TextView tvYourIQ=v.findViewById(R.id.tvYourIq);
            tvYourIQ.setText(stringBuffer);
            bufferedReader.close();
            inputStreamReader.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
