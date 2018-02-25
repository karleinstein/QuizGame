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
 * Created by karleinstein on 1/24/2018.
 */

public class Level3 extends Activity {
    TextView txtIncrease3;
    double counter3 = 2;
    double trash,s;
    ImageButton btnBack;
    Button btn6,btn7,btn8,btn9;
    FileOutputStream fileOutputStream;
    SharedPreferences prefs,yo;
    int jaz;
    int karl;
    String zz,zz1;
    double ez;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.level3);
        prefs = getSharedPreferences("X3", MODE_PRIVATE);
        yo = getSharedPreferences("X3", MODE_PRIVATE);
        btn6 = findViewById(R.id.btnA);
        btn8 = findViewById(R.id.btnB);
        btnBack=findViewById(R.id.btnBack);
        btn9 = findViewById(R.id.btnC);
        btn7 = findViewById(R.id.btnD);
        AdView adView=findViewById(R.id.adView);
        AdRequest adRequest=new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte=new Intent(Level3.this,ChooseLevel.class);
                startActivity(inte);
            }
        });
        txtIncrease3 = findViewById(R.id.txtIncrease3);
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter3 > 0.0) {
                    counter3 -= 0.5;
                    txtIncrease3.setText(String.valueOf(counter3));
                }
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter3 > 0.0) {
                    counter3 -= 0.5;
                    txtIncrease3.setText(String.valueOf(counter3));
                }
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter3 > 0.0) {
                    counter3 -= 0.5;
                    txtIncrease3.setText(String.valueOf(counter3));
                }
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trash = Double.parseDouble(txtIncrease3.getText().toString());
                ez = trash+55 ;
                karl=1;
                SharedPreferences.Editor editor=yo.edit();
                editor.putFloat("lul", (float) ez);
                editor.commit();
                SharedPreferences.Editor edit=prefs.edit();
                edit.putInt("yo",karl);
                edit.commit();
                openDialog3();

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
                //Intent intent=new Intent(Level3.this,Level4.class);
                ///Float lol= yo.getFloat("lul", (float) ez);
                //txtIncrease.setText(lol+"");
                //double s= Double.parseDouble(txtIncrease.getText().toString());
                //double s=lol;
                //intent.putExtra("Your",s);
                //startActivity(intent);
                Intent intent =new Intent(Level3.this,Level4.class);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("Close",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                btn6.setEnabled(false);
                btn8.setEnabled(false);
                btn9.setEnabled(false);
                btn7.setEnabled(false);
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

    public void openDialog3() {
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
        final Dialog dialog = new Dialog(Level3.this); // Context, this, etc.
        dialog.setContentView(R.layout.dialog);
        dialog.setTitle("WOW");
        TextView txtTrashz = dialog.findViewById(R.id.txtTrashz);
        Button btnNext=dialog.findViewById(R.id.btnNext);
        Button btnBack=dialog.findViewById(R.id.btnBack);
        Double a = Double.parseDouble(txtIncrease3.getText().toString());
        double b=a+Double.parseDouble(zz);
        Log.d("Duong dan bo nho may",getFilesDir().getAbsolutePath());
        loveja(String.valueOf(b));
        txtTrashz.setText("Your IQ:" + b);
        jaz=3;
        Log.d("level duong dan",getFilesDir().getAbsolutePath());
        level(String.valueOf(jaz));
        dialog.show();
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Level3.this,ChooseLevel.class);
                Level3.this.startActivity(intent);
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Level3.this,Level4.class);
                startActivity(intent);
            }
        });
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
