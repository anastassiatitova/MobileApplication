package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    EditText num1, num2;
    RadioGroup rgOperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }

    public void initialize(){
        num1 = findViewById(R.id.editNumber1);
        num2 = findViewById(R.id.editNumber2);

        rgOperation = findViewById(R.id.rgOperation);
    }

    public void operate(View view){
        int btnId = view.getId();

        switch (btnId){
            case R.id.btnShowResult:
                getUserInput();
                break;
            case R.id.btnFinish:
                finish();
                break;
        }
    }

    public void getUserInput(){
        float operand1 = Float.parseFloat(num1.getText().toString());
        float operand2 = Float.parseFloat(num2.getText().toString());

        int checkRadioButtonId =rgOperation.getCheckedRadioButtonId();

        float result = calculateResult(operand1, operand2, checkRadioButtonId);

        goToResultActivity(result);

    }

    public float calculateResult(float num1, float num2, int checkRadioButtonId){
        float result = 0;

        switch (checkRadioButtonId){
            case R.id.rbAdd:
                result = num1 + num2;
                break;
            case R.id.rbMultiply:
                result = num1 * num2;
                break;
            case  R.id.rbDivide:
                if(num2 != 0.0){
                    result = num1 / num2;
                }
                break;
            case R.id.rbSubstruct:
                result = num1 - num2;
                break;
          }
        return  result;
    }

    public void goToResultActivity(float result){
        Intent intent = new Intent(this, Result.class);
        intent.putExtra("result", result);
        System.out.println("---------------------" + result);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}