package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AdvancedCalculatorActivity extends AppCompatActivity {

    TextView inputBox, operBox;
    String oper, value1, value2;
    Double  num1, num2, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_calculator);

        inputBox = (TextView) findViewById(R.id.inputTextView);
        operBox = (TextView) findViewById(R.id.signTextView);

        initValues();

        if(savedInstanceState != null){
            restoreFromSavedInstanceState(savedInstanceState);
        }
    }

    private void initValues() {
        oper    = null;
        value1  = "";
        value2  = "";
        num1    = 0.0;
        num2    = 0.0;
        result  = 0.0;
    }

    // Number buttons //
    public void btnClick_num0(View view) {
        inputBox.append("0");
    }
    public void btnClick_num1(View view) {
        inputBox.append("1");
    }
    public void btnClick_num2(View view) {
        inputBox.append("2");
    }
    public void btnClick_num3(View view) {
        inputBox.append("3");
    }
    public void btnClick_num4(View view) { inputBox.append("4"); }
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

    // Operation Buttons //
    public void btnClick_divide(View view) {
        if(oper != null){
            operate();
        }
        oper = "/";
        operBox.setText("/");
        value1 = inputBox.getText().toString();
        inputBox.setText(null);
    }
    public void btnClick_multiply(View view) {
        if(oper != null){
            operate();
        }
        oper = "x";
        operBox.setText("X");
        value1 = inputBox.getText().toString();
        inputBox.setText(null);
    }
    public void btnClick_minus(View view) {
        if(oper != null){
            operate();
        }
        oper = "-";
        operBox.setText("-");
        value1 = inputBox.getText().toString();
        inputBox.setText(null);
    }
    public void btnClick_plus(View view) {
        if(oper != null){
            operate();
        }
        oper = "+";
        operBox.setText("+");
        value1 = inputBox.getText().toString();
        inputBox.setText(null);
    }

    // Special Buttons
    public void btnClick_percent(View view) {
        String temp = inputBox.getText().toString();
        if(temp.length() == 0){
            inputBox.setText("0");
        }else{
            Double num = Double.parseDouble(temp)/100;
            inputBox.setText(num + "");
        }
    }
    public void btnClick_changeSign(View view) {
        String temp = inputBox.getText().toString();
        if(temp.length() > 0){
            if(temp.charAt(0) == '-'){
                temp = temp.substring(1);
            }else {
                temp = "-" + temp;
            }
            inputBox.setText(temp);
        }
    }

    // Advanced Mode Operations

    public void btnClick_sin(View view) {
        double value;
        String temp = inputBox.getText().toString();

        if(temp.length() == 0){
            value = Math.sin(0);
        }else{
            value = Double.parseDouble(temp);
            value = Math.sin(value);
        }

        inputBox.setText(value + "");
    }

    public void btnClick_cos(View view) {
        double value;
        String temp = inputBox.getText().toString();

        if(temp.length() == 0){
            value = Math.cos(0);
        }else{
            value = Double.parseDouble(temp);
            value = Math.cos(value);
        }

        inputBox.setText(value + "");
    }

    public void btnClick_tan(View view) {
        double value;
        String temp = inputBox.getText().toString();

        if(temp.length() == 0){
            value = Math.tan(0);
        }else{
            value = Double.parseDouble(temp);
            value = Math.tan(value);
        }

        inputBox.setText(value + "");
    }

    public void btnClick_sqrt(View view) {
        double value;
        String temp = inputBox.getText().toString();

        if(temp.length() == 0){
            value = 0;
        }else{
            value = Double.parseDouble(temp);
            value = Math.sqrt(value);
        }

        inputBox.setText(value + "");
    }

    public void btnClick_ln(View view) {
        double value;
        String temp = inputBox.getText().toString();

        if(temp.length() == 0){
            value = Math.log(0);
        }else{
            value = Double.parseDouble(temp);
            value = Math.log(value);
        }

        inputBox.setText(value + "");
    }

    public void btnClick_power2(View view) {
        double value;
        String temp = inputBox.getText().toString();

        if(temp.length() == 0){
            value = 0;
        }else{
            value = Double.parseDouble(temp);
            value = Math.pow(value,2);
        }

        inputBox.setText(value + "");
    }

    public void btnClick_log(View view) {
        if(oper != null){
            operate();
        }
        oper = "log";
        operBox.setText("log");
        value1 = inputBox.getText().toString();
        inputBox.setText(null);
    }

    public void btnClick_powerY(View view) {
        if(oper != null){
            operate();
        }
        oper = "power";
        operBox.setText("pow");
        value1 = inputBox.getText().toString();
        inputBox.setText(null);
    }

    //Other Buttons
    public void btnClick_clear(View view) {
        inputBox.setText("");
    }
    public void btnClick_dot(View view) {
        if (inputBox.getText().toString().lastIndexOf(".") == -1) {
            if (inputBox.getText().equals("0") || inputBox.getText().length() == 0) {
                inputBox.setText("0.");
            } else {
                inputBox.setText(inputBox.getText() + ".");
            }
        }

    }
    public void btnClick_result(View view) {
        operate();
    }

    private void operate() {
        if(inputBox.getText().equals("")){
            operBox.setText("Error");
        }else if(oper != null){
            value2 = inputBox.getText().toString();
            num1 = Double.parseDouble(value1);
            num2 = Double.parseDouble(value2);
            inputBox.setText(null);

            switch(oper){
                default:{
                    break;
                }
                case "+":
                {
                    result = num1 + num2;
                    inputBox.setText(result + "");
                    oper = null;
                    operBox.setText(null);
                    break;
                }
                case "-":
                {
                    result = num1 - num2;
                    inputBox.setText(result + "");
                    oper = null;
                    operBox.setText(null);
                    break;
                }
                case "x":
                {
                    result = num1 * num2;
                    inputBox.setText(result + "");
                    oper = null;
                    operBox.setText(null);
                    break;
                }
                case "/":
                {
                    result = num1 / num2;
                    inputBox.setText(result + "");
                    oper = null;
                    operBox.setText(null);
                    break;
                }
                case "log":
                {
                    result = customLog(num1,num2);

                    inputBox.setText(result + "");
                    oper = null;
                    operBox.setText(null);
                    break;
                }
                case "power":
                {
                    result = Math.pow(num1,num2);

                    inputBox.setText(result + "");
                    oper = null;
                    operBox.setText(null);
                    break;
                }
            }
        }else{
            inputBox.setText("Error");
        }
    }

    private static double customLog(double base, double logNumber) {
        return Math.log(logNumber) / Math.log(base);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("inputBox"   , inputBox.getText().toString());
        outState.putString("operBox"    , operBox.getText().toString());
        outState.putString("oper"       , oper);
        outState.putString("value1"     , value1);
        outState.putString("value2"     , value2);
        outState.putDouble("num1"       , num1);
        outState.putDouble("num2"       , num2);
        outState.putDouble("result"     , result);
    }

    protected void restoreFromSavedInstanceState(Bundle savedInSt) {
        inputBox.setText(savedInSt.getString("inputBox"));
        operBox.setText(savedInSt.getString("operBox"));
        oper    = savedInSt.getString("oper");
        value1  = savedInSt.getString("value1");
        value1  = savedInSt.getString("value2");
        num1    = savedInSt.getDouble("num1");
        num2    = savedInSt.getDouble("num2");
        result  = savedInSt.getDouble("result");
    }
}
