package com.example.onmobdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DataActivity extends AppCompatActivity {

    LinearLayout mainlay;
    Button back;
    String msg = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        DbHelper db = new DbHelper(getApplicationContext());

        mainlay = findViewById(R.id.mainlay);
        back = findViewById(R.id.back);

        if(getIntent().getStringExtra("id").equals("1")) {
            TextView t = new TextView(getApplicationContext());
            t.setTextSize(20);

            for (Data d : db.fetch()) {
                msg += d.getName() + " : " + d.getPass() + "\n";
            }

            t.setText(msg);

            mainlay.addView(t);
        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });

    }
}