package com.example.assignment01a;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText editTemperature;
    TextView convertedTemperature;
    final String TAG = "Assignment01a";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //temperatureConversion
        editTemperature = findViewById(R.id.temperature);
        convertedTemperature = findViewById(R.id.convertedTemperature);
        findViewById(R.id.reset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTemperature.setText("");
                convertedTemperature.setText("");
            }
        });
        findViewById(R.id.celciusToFarenheat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 celciusToFahrenheit();
            }
        });
        findViewById(R.id.farenheatToCelcius).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fahrenheitToCelcius();
            }
        });



    }
    private void celciusToFahrenheit()
    {
        String enteredTemp=editTemperature.getText().toString();
        try{
            double celcius=Double.parseDouble(enteredTemp);
            double result= (celcius * 9/5) +32;
            convertedTemperature.setText(String.format("%.2f F",result));
        }
        catch (NumberFormatException exception) {
        Toast.makeText(MainActivity.this, "Enter a valid number !!", Toast.LENGTH_SHORT).show();
        }
    }


    private void fahrenheitToCelcius()
    {
        String enteredTemp=editTemperature.getText().toString();
        try{
            double fahrenheit=Double.parseDouble(enteredTemp);
            double result= (fahrenheit - 32)* 5/9;
            convertedTemperature.setText(String.format("%.2f C",result));
        }
        catch (NumberFormatException exception) {
            Toast.makeText(MainActivity.this, "Enter a valid number !!", Toast.LENGTH_SHORT).show();
        }
    }
}