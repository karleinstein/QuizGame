package com.example.karleinstein.iqtest.beginner;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.karleinstein.iqtest.ChooseLevel;
import com.example.karleinstein.iqtest.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by karleinstein on 1/20/2018.
 */

public class Level1 extends Activity  {
    ImageView imgView;
    TextView txtIncrease;
    FileOutputStream fileOutputStream;
    SharedPreferences prefs,yo;
    int jaz;
    int karl;
    String zz;
    private AdView adView;
    double counter = 2.0;
    double trash,ez;
    Button btnA,btnB,btnC,btnD;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.level1);
        ImageButton btnBack=findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Level1.this,ChooseLevel.class);
                startActivity(intent);
            }
        });
        adView=findViewById(R.id.adView);
        AdRequest adRequest=new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        prefs = getSharedPreferences("X", MODE_PRIVATE);
        yo = getSharedPreferences("X", MODE_PRIVATE);
        imgView = findViewById(R.id.imgView);
        txtIncrease = findViewById(R.id.txtIncrease);
         btnA = findViewById(R.id.btnA);
        btnB = findViewById(R.id.btnB);
        btnC = findViewById(R.id.btnC);
        btnD = findViewById(R.id.btnD);

        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter > 0.0) {
                    counter -= 0.5;
                    txtIncrease.setText(String.valueOf(counter));
                }
            }
        });
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter > 0.0) {
                    counter -= 0.5;
                    txtIncrease.setText(String.valueOf(counter));
                }
            }
        });
        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter > 0.0) {
                    counter -= 0.5;
                    txtIncrease.setText(String.valueOf(counter));
                }
            }
        });
        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trash = Double.parseDouble(txtIncrease.getText().toString());
                ez = trash+55 ;
                karl=1;
                SharedPreferences.Editor editor=yo.edit();
                editor.putFloat("lul", (float) ez);
                editor.commit();
                SharedPreferences.Editor edit=prefs.edit();
                edit.putInt("yo",karl);
                edit.commit();
                openDialog();
            }
        });
    }

    @Override
    protected void onResume() {
        int lol=prefs.getInt("yo",karl);
        if (lol==1)
        {
            showAlertDialog();
        }
        super.onResume();
    }
    public void showAlertDialog(){
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
            zz= String.valueOf(stringBuffer);
            bufferedReader.close();
            inputStreamReader.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("You passed this level");
        builder.setMessage("Your IQ:"+zz);
        builder.setCancelable(false);
        builder.setPositiveButton("Next", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent=new Intent(Level1.this,Level2.class);
               //Float lol= yo.getFloat("lul", (float) ez);
               //txtIncrease.setText(lol+"");
               //double s= Double.parseDouble(txtIncrease.getText().toString());
                //double s=lol;
                //intent.putExtra("Your",s);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                btnA.setEnabled(false);
                btnB.setEnabled(false);
                btnC.setEnabled(false);
                btnD.setEnabled(false);
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
    public void openDialog() {
        final Dialog dialog = new Dialog(this); // Context, this, etc.
        dialog.setContentView(R.layout.dialog);
        dialog.setTitle("WOW");
        TextView txtTrashz = dialog.findViewById(R.id.txtTrashz);
        Button btnNext=dialog.findViewById(R.id.btnNext);
        Button btnBack=dialog.findViewById(R.id.btnBack);
        jaz=1;
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Level1.this,ChooseLevel.class);
                intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
                Level1.this.startActivity(intent);
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Level1.this,Level2.class);
                //Float lol= yo.getFloat("lul", (float) ez);
                //double s=lol;
                //intent.putExtra("Your",s);
                startActivity(intent);
            }
        });
        double trash = Double.parseDouble(txtIncrease.getText().toString());
        double s = trash+55 ;
        txtTrashz.setText("Your IQ:"+s);
        Log.d("Duong dan bo nho may",getFilesDir().getAbsolutePath());
        loveja(String.valueOf(s));
        Log.d("level duong dan",getFilesDir().getAbsolutePath());
        level(String.valueOf(jaz));
        dialog.show();
    }
    private void level(String dulieu)
    {
        try {
            fileOutputStream=openFileOutput("levels.txt",Context.MODE_PRIVATE);
            fileOutputStream.write(dulieu.getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    private void loveja(String dulieu) {
        try {
            fileOutputStream=openFileOutput("Highscore.txt",Context.MODE_PRIVATE);
            fileOutputStream.write(dulieu.getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
