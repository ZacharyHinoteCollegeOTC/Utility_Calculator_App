package com.example.utilitycalculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class TipCalculatorActivity extends AppCompatActivity {
    private EditText nPrice;
    private RadioGroup mHowBigTipRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);

        mHowBigTipRadioGroup = findViewById(R.id.Percentage_Radio_Group);
        nPrice = findViewById(R.id.editable_bill);
        Button btn = (Button)findViewById(R.id.home_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TipCalculatorActivity.this, MainActivity.class));
            }
        });

    }

    public void calculateTipClick(View view) {
        String originalBill = nPrice.getText().toString();
        double calculableBill = Double.parseDouble(originalBill);
        double tipPercentage = 0;
        int checkedId = mHowBigTipRadioGroup.getCheckedRadioButtonId();
        if (checkedId == R.id.radioButton) {
            tipPercentage = 0.10;
        }
        else if (checkedId == R.id.radioButton2) {
            tipPercentage = 0.15;
        }
        else if (checkedId == R.id.radioButton3) {
            tipPercentage = 0.20;
        }
        else if (checkedId == R.id.radioButton4) {
            tipPercentage = 0.25;
        }

        double totalTip = Math.round(calculableBill * tipPercentage * 100.0) / 100.0;
        Toast.makeText(TipCalculatorActivity.this, "Calculated Tip: " + totalTip, Toast.LENGTH_LONG).show();


    }

}