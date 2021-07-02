package com.loise.onlinetest.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.loise.onlinetest.R;

public class MainActivity extends AppCompatActivity {
    Button submit;
    EditText apiKey;
    Spinner city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submit = findViewById(R.id.bSubmit);
        apiKey = findViewById(R.id.etApiKey);
        city = findViewById(R.id.spinnerCity);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("city", city.getSelectedItem().toString());
                intent.putExtra("apikey", apiKey.getText().toString());
                startActivity(intent);
            }
        });
    }
}