package com.example.utilitycalculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

public class LoanCalculatorActivity extends AppCompatActivity {

    private EditText nDollars;
    private EditText nYears;
    private SeekBar nMonths;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_calculator);
        nMonths = findViewById(R.id.seekBar);
        nDollars = findViewById(R.id.dollaredLoanAmount);
        nYears = findViewById(R.id.LoanTimeYears);


        Button homeBtn = (Button)findViewById(R.id.home_from_loan);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoanCalculatorActivity.this, MainActivity.class));
            }
        });

    }

    public void CalculateLoanClick(View view) {
        String years = nYears.getText().toString();
        int numberedYears = Integer.parseInt(years);
        String dollars = nDollars.getText().toString();
        double numberedDollars = Double.parseDouble(dollars);
        int months = nMonths.getProgress();

        double monthlyPayment = numberedDollars/ (numberedYears * 12 + months);

        Toast.makeText(LoanCalculatorActivity.this, "Monthly Payment: " + monthlyPayment, Toast.LENGTH_LONG).show();
    }

}