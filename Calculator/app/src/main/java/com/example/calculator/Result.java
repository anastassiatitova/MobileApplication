package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Result extends AppCompatActivity {

    EditText editTextResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        initialize();
        myGetIntent();
    }

    public void initialize(){
        editTextResult = findViewById(R.id.editResult);
    }

    private void myGetIntent(){

        float result = getIntent().getFloatExtra("result", 0f);

        String strResult = String.valueOf(result);
        editTextResult.setText(strResult);
    }

    public void goBack(View view) {
        finish();
    }


}