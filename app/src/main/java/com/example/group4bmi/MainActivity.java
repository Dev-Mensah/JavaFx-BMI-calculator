package com.example.group4bmi;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Declaring variables
    private EditText etheight, etweight;
    private TextView tvdisplay,tvstatus,tvunit, tvmessage;
    private Button mbutton;

    //OnCreate method starts here
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assigning objects from the layout to the variables
        etheight = findViewById(R.id.etHeight);
        etweight = findViewById(R.id.etWeight);
        tvdisplay = findViewById(R.id.tvdisplay);
        tvstatus = findViewById(R.id.tvstatus);
        tvmessage = findViewById(R.id.tvmessage);
        mbutton = findViewById(R.id.resetButton);
        tvunit = findViewById(R.id.tvunit);

        //setting notion if empty do nothing
        if (etheight.getText().toString().isEmpty()){
            ;
        }

        //when reset button is clicked
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Reset();
            }
        });

        //when weight textfield receives text auto calculate
        etweight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (etweight.getText().toString().isEmpty()) {
                   ;
                }else if (etheight.getText().toString().isEmpty()){
                    ;
                }else {
                    calculate();
                }
            }
        });


    } // Oncreate method ends here

    // method for calculations
    //BMI is calculated using pounds and inches.... weight * 703 / height^2
    private void calculate(){
            String height = etheight.getText().toString();
            String weight = etweight.getText().toString();
            double check = Double.parseDouble(weight)*703 / Math.pow(Double.parseDouble(height), 2);
            tvstatus.setText(String.format("%.1f", check ));

            // checking bmi status
        if (check > 30){
            tvmessage.setText("Your BMI Is Above Average");
        }else if (check <15){
            tvmessage.setText("Your BMI Is UnderAverage");
        }else {
            tvmessage.setText("Your BMI Is Average");
        }

            tvstatus.setVisibility(View.VISIBLE);
            tvdisplay.setVisibility(View.VISIBLE);
            tvunit.setVisibility(View.VISIBLE);
    }

    // method for resting
    private void Reset(){
        etweight.setText("");
        etheight.setText("");
        tvmessage.setVisibility(View.INVISIBLE);
        tvstatus.setVisibility(View.INVISIBLE);
        tvdisplay.setVisibility(View.INVISIBLE);
        tvunit.setVisibility(View.INVISIBLE);
        Toast.makeText(MainActivity.this, "Reset Successful ", Toast.LENGTH_SHORT).show();
    }

    private void message (int bmi){

    }
}