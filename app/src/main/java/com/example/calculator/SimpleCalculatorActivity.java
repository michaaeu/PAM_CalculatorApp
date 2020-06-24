package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SimpleCalculatorActivity extends AppCompatActivity {

    TextView inputBox, signBox;
    String sign;
    double value1, value2, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_calculator);

        inputBox = (TextView) findViewById(R.id.inputTextView);
        signBox = (TextView) findViewById(R.id.signTextView);
    }

    public void btnClick_num0(View view) {
        inputBox.append("0");
    }
    public void btnClick_num1(View view) {
        inputBox.append( "1");
    }
    public void btnClick_num2(View view) {
        inputBox.append("2");
    }
    public void btnClick_num3(View view) {
        inputBox.append("3");
    }
    public void btnClick_num4(View view) {
        inputBox.append("4");
    }
    public void btnClick_num5(View view) {
        inputBox.append("5");
    }
    public void btnClick_num6(View view) {
        inputBox.append("6");
    }
    public void btnClick_num7(View view) {
        inputBox.append("7");
    }
    public void btnClick_num8(View view) {
        inputBox.append("8");
    }
    public void btnClick_num9(View view) {
        inputBox.append("9");
    }


    public void btnClick_divide(View view) {
        sign = "/";
        signBox.setText("/");
        value1 = Double.parseDouble((String) inputBox.getText());
    }
    public void btnClick_multiply(View view) {
        sign = "X";
        signBox.setText("X");
        value1 = Double.parseDouble((String) inputBox.getText());
    }
    public void btnClick_minus(View view) {
        sign = "-";
        signBox.setText("-");
        value1 = Double.parseDouble((String) inputBox.getText());
    }
    public void btnClick_plus(View view) {
        sign = "+";
        signBox.setText("+");
        value1 = Double.parseDouble((String) inputBox.getText());
    }


    public void btnClick_clear(View view) {
        inputBox.setText("");
    }
    public void btnClick_changeSign(View view) {
    }
    public void btnClick_percent(View view) {
    }
    public void btnClick_dot(View view) {
    }
    public void btnClick_result(View view) {

        switch(sign){
            case "+":
                {
                    
                }
            case "-":
                {

                }
        }
    }
}
