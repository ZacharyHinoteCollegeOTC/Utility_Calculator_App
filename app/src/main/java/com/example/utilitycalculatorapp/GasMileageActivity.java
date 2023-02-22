package com.example.utilitycalculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GasMileageActivity extends AppCompatActivity {

    private EditText tank;
    private EditText distance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gas_mileage);

        tank = findViewById(R.id.editTextGasTank);
        distance = findViewById(R.id.editTextTravelDistance);

        Button btn = (Button)findViewById(R.id.return_home);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GasMileageActivity.this, MainActivity.class));
            }
        });

    }

    public void calculateGasClick(View view) {
        String gasTank = tank.getText().toString();
        String maxDistance = distance.getText().toString();
        double calculableGasTank = Double.parseDouble(gasTank);
        double calculableMaxDistance = Double.parseDouble(maxDistance);
        double milesPerGallon = calculableGasTank/calculableMaxDistance;
        double roundedMPG = Math.round(milesPerGallon * 100.0) / 100.0;
        Toast.makeText(GasMileageActivity.this, "Miles Per Gallon: " + roundedMPG, Toast.LENGTH_LONG).show();

    }

}