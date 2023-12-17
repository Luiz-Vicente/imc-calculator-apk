package com.example.imccalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editTextWeight = findViewById(R.id.editWeight);
        final EditText editTextHeight = findViewById(R.id.editHeight);
        Button btnCalculate = findViewById(R.id.btnCalculate);
        final TextView textViewResult = findViewById(R.id.textViewResult);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obter o peso e a altura do usuário
                String weightString = editTextWeight.getText().toString();
                String heightString = editTextHeight.getText().toString();

                if (!weightString.isEmpty() && !heightString.isEmpty()) {
                    // Converter os valores para números
                    float weight = Float.parseFloat(weightString);
                    float height = Float.parseFloat(heightString);

                    // Calcular o IMC
                    float bmi = calculateBMI(weight, height);

                    // Exibir o resultado
                    String result = String.format("SEU IMC É: %.2f", bmi);
                    textViewResult.setText(result);
                } else {
                    textViewResult.setText("Por favor, preencha os campos.");
                }
                textViewResult.setVisibility(View.VISIBLE);
            }
        });
    }

    private float calculateBMI(float weight, float height) {
        // Fórmula do IMC: peso / (altura * altura)
        return weight / (height * height);
    }
}