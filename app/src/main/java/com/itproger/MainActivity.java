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
    private Button plusButton;
    private Button minusButton;
    private Button multButton;
    private Button divideButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultTextView);
        numberField1 = findViewById(R.id.number_field_1);
        numberField2 = findViewById(R.id.number_field_2);

//        plusButton.setOnClickListener(view -> {
//            String firstNumString = numberField1.getText().toString();
//            float num1 = Float.parseFloat(firstNumString.isEmpty() ? "0" : firstNumString);
//            String secondNumString = numberField2.getText().toString();
//            float num2 = Float.parseFloat(secondNumString.isEmpty() ? "0" : secondNumString);
//            float res = num1 + num2;
//            resultTextView.setText(String.valueOf(res));
//        });
    }

    public void onButtonClick(View v) {
        EditText el1 = findViewById(R.id.number_field_1);
        EditText el2 = findViewById(R.id.number_field_2);
        TextView resText = findViewById(R.id.resultTextView);

        int num1 = Integer.parseInt(el1.getText().toString());
        int num2 = Integer.parseInt(el2.getText().toString());

        int result;
        String textShow = "";

        switch (v.getId()) {
            case R.id.plus_button:
                result = num1 + num2;
                textShow = "Сумма = " + result;
                break;
            case R.id.minus_button:
                result = num1 - num2;
                textShow = "Разница = " + result;
                break;
            case R.id.mult_button:
                result = num1 * num2;
                textShow = "Произведение = " + result;
                break;
            case R.id.divide_button:
                if (num2 != 0) {
                    result = num1 / num2;
                    textShow = "Частное = " + result;
                } else
                    textShow = "Нельзя делить на 0!";
                break;
        }

        resText.setText(textShow);
    }

}