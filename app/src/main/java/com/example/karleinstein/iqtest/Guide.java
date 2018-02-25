package com.example.karleinstein.iqtest;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

/**
 * Created by karleinstein on 1/21/2018.
 */

public class Guide extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.congrats);
        TextView txtTrash=findViewById(R.id.txtTrash);
        TextView txtTrash2=findViewById(R.id.txtTrash2);
        Typeface typeface=Typeface.createFromAsset(getAssets(),"fonts/handwriting-draft.ttf");
        Typeface typeface1=Typeface.createFromAsset(getAssets(),"fonts/song.ttf");
        txtTrash.setTypeface(typeface);
        txtTrash2.setTypeface(typeface1);

    }
}
