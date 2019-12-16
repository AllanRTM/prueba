package com.example.Coca_cola_Service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class prueba extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba);




       Intent intent = getIntent();
        Intent intent1=getIntent();
        String message = intent.getStringExtra(Summary.EXTRA_MESSAGE);
        String message1 = intent1.getStringExtra(Summary.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.direccion);
        TextView textView1=findViewById(R.id.tvTotal);
        textView.setText(message);
        textView1.setText(message1);
    }
}
