package com.example.onmobdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText name, pass;
    Button submit, show;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        pass = findViewById(R.id.pass);
        submit = findViewById(R.id.submit);
        show = findViewById(R.id.show);

        DbHelper db = new DbHelper(getApplicationContext());

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.save(new Data(name.getText().toString(), pass.getText().toString()));
                name.setText("");
                pass.setText("");
                Toast.makeText(getApplicationContext(), "saved", Toast.LENGTH_SHORT).show();
            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(), DataActivity.class);
                i.putExtra("id", "1");
                startActivity(i);
                finish();
            }
        });
    }
}