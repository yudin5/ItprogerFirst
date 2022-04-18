package com.itproger;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    private EditText numberField1, numberField2;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultTextView);
        numberField1 = findViewById(R.id.number_field_1);
        numberField2 = findViewById(R.id.number_field_2);
        addButton = findViewById(R.id.add_button);

        addButton.setOnClickListener(view -> {
            String firstNumString = numberField1.getText().toString();
            float num1 = Float.parseFloat(firstNumString.isEmpty() ? "0" : firstNumString);
            String secondNumString = numberField2.getText().toString();
            float num2 = Float.parseFloat(secondNumString.isEmpty() ? "0" : secondNumString);
            float res = num1 + num2;
            resultTextView.setText(String.valueOf(res));
        });
    }

}