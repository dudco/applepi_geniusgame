package com.example.dudco.genius_game;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = LayoutInflater.from(this).inflate(R.layout.custom_dialog, null);

        DisplayMetrics dm = getApplicationContext().getResources().getDisplayMetrics();
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        Log.d("dudco", width + "   " + height);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams((int)((float)width/1.5), (int)((float)width/4.3));
        view.setLayoutParams(params);

        setContentView(view);

        final EditText text = (EditText) findViewById(R.id.eidt_dialog);
        final Intent intent = getIntent();
        findViewById(R.id.dialog_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("dudco", text.getText().toString());
                intent.putExtra("num", text.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
