package com.example.beerman;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

public class ABVCalculator extends AppCompatActivity  {
    int og;
    int fg;

    EditText ogInput;
    EditText fgInput;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abv_calculator);

    }
}
