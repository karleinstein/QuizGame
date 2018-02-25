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
 * Created by karleinstein on 1/23/2018.
 */

public class Level2 extends Activity {
    TextView txtIncrease2;
    double counterz=2.0;
    double trash,s;
    FileOutputStream fileOutputStream;
    SharedPreferences prefs,yo,ja1;
    int jaz;
    String fck;
    ImageButton btnBack;
    int karl;
    private AdView adView;
    String zz,zz1;
    double ez;
    Button btnA,btnB,btnC,btnD;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.level2);
        adView=findViewById(R.id.adView);
        AdRequest adRequest=new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        prefs = getSharedPreferences("X2", MODE_PRIVATE);
        //ja1 = getSharedPreferences("X2", MODE_PRIVATE);
        yo = getSharedPreferences("X2", MODE_PRIVATE);
        txtIncrease2=findViewById(R.id.txtIncrease2);
        btnBack=findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Level2.this,ChooseLevel.class);
                startActivity(intent);
            }
        });

        btnA=findViewById(R.id.btnA);
        btnB=findViewById(R.id.btnB);
        btnC=findViewById(R.id.btnC);
        btnD=findViewById(R.id.btnD);
        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counterz>0.0) {
                    counterz -= 0.5;
                    txtIncrease2.setText(String.valueOf(counterz));
                }
            }
        });
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counterz>0.0)
                {
                    counterz-=0.5;
                    txtIncrease2.setText(String.valueOf(counterz));
                }
            }
        });
        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counterz>0.0)
                {
                    counterz-=0.5;
                    txtIncrease2.setText(String.valueOf(counterz));
                }
            }
        });
        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trash = Double.parseDouble(txtIncrease2.getText().toString());
                ez = trash+55 ;
                karl=1;
                SharedPreferences.Editor editor=yo.edit();
                editor.putFloat("lul", (float) ez);
                editor.commit();
                SharedPreferences.Editor edit=prefs.edit();
                edit.putInt("yo",karl);
                edit.commit();
                openDialogz();
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
    private void showAlertDialog() {
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
            zz1= String.valueOf(stringBuffer);
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
        builder.setMessage("Your IQ:"+zz1);
        builder.setCancelable(false);
        builder.setPositiveButton("Next", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent=new Intent(Level2.this,Level3.class);
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

    public void openDialogz() {
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
            final Dialog dialog = new Dialog(this); // Context, this, etc.
            dialog.setContentView(R.layout.dialog);
            dialog.setTitle("WOW");
            TextView txtTrashz=dialog.findViewById(R.id.txtTrashz);
            Button btnNext=dialog.findViewById(R.id.btnNext);
            Button btnBack=dialog.findViewById(R.id.btnBack);
            jaz=2;
            btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Intent intentz=getIntent();
                    //double b=Double.parseDouble(txtIncrease2.getText().toString());
                    //double yeah =intentz.getDoubleExtra("Your",0);
                    //double f=yeah+b;
                    Intent intent=new Intent(Level2.this,Level3.class);
                    //intent.putExtra("Yourz",f);
                    startActivity(intent);
                }
            });
            btnBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(Level2.this,ChooseLevel.class);
                    startActivity(intent);
                }
            });
            //double a=Double.parseDouble(txtIncrease.getText().toString());
            double b=Double.parseDouble(txtIncrease2.getText().toString());
            double a=b+Double.parseDouble(zz);
            Log.d("Duong dan bo nho may",getFilesDir().getAbsolutePath());
            loveja(String.valueOf(a));

            //NumberFormat nm = NumberFormat.getNumberInstance();
            txtTrashz.setText("Your IQ:"+a);
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

