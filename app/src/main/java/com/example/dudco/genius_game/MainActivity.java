package com.example.dudco.genius_game;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int[] check = new int[12];
    int cnt = 0;
    String num;
    TextView maintext;
    ImageView btn;
    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        random = new Random();
        maintext = (TextView) findViewById(R.id.text);
        maintext.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/Daum_SemiBold.ttf"));
        maintext.setText("");
        btn = (ImageView) findViewById(R.id.btn_pick);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                maintext.setText("" + check[cnt++]);
                if (cnt == Integer.valueOf(num)) {
                    btn.setEnabled(false);
                }
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1234) {
            if (resultCode == RESULT_OK) {
                num = data.getStringExtra("num");
                cnt = 0;
                btn.setEnabled(true);
                Log.d("dudco", num + "");
                setRandom(Integer.valueOf(num));
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.asdf, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.setting){
            startActivityForResult(new Intent(MainActivity.this, DialogActivity.class), 1234);
            return true;
        }
        return false;
    }

    private void setRandom(int num) {
        for (int i = 0; i < num; i++) {
            check[i] = random.nextInt(num) + 1;
            for (int j = 0; j < i; j++) {
                if (check[i] == check[j]) {
                    i--;
                    break;
                }
            }
        }
    }


}

