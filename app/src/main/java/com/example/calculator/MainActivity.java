package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void btnClick_simple(View view) {
        startActivity(new Intent(MainActivity.this, SimpleCalculatorActivity.class));
    }

    public void btnClick_about(View view) {
    }

    public void btnClick_exit(View view) {
        finish();
    }

    public void btnClick_advanced(View view) {
    }
}
