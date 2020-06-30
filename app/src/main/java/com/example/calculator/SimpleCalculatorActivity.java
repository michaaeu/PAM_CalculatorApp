package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SimpleCalculatorActivity extends AppCompatActivity {

    TextView inputBox, operBox;
    String oper, value1, value2;
    Double  num1, num2, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_calculator);

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
        setOperation("/");
    }
    public void btnClick_multiply(View view) {
        if(oper != null){
            operate();
        }
        setOperation("x");
    }
    public void btnClick_minus(View view) {
        if(oper != null){
            operate();
        }
        setOperation("-");
    }
    public void btnClick_plus(View view) {
        if(oper != null){
            operate();
        }
        setOperation("+");
    }

    private void setOperation(String oper){
        this.oper = oper;
        this.operBox.setText(oper);
        this.value1 = inputBox.getText().toString();
        this.inputBox.setText(null);
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
                    break;
                }
                case "-":
                {
                    result = num1 - num2;
                    break;
                }
                case "x":
                {
                    result = num1 * num2;
                    break;
                }
                case "/":
                {
                    result = num1 / num2;
                    break;
                }
            }
            setResult(result);
        }else{
            inputBox.setText("Error");
        }
    }
    private void setResult(double result){
        inputBox.setText(result + "");
        oper = null;
        operBox.setText(null);
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
