package com.itproger;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView mainText = findViewById(R.id.main_text);
        Button btnSecond = findViewById(R.id.btn_second);
        btnSecond.setOnClickListener(view -> {
//                showInfo(mainText.getText().toString(), btnSecond);
            showInfoAlert("Вы хотите закрыть приложение?");
        });

        // Поле с паролем
        EditText pass = findViewById(R.id.pass);
        pass.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String password = pass.getText().toString();
                if (!hasFocus) {
                    // Скрываем клавиатуру при клике вне поля
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
                if (!password.isEmpty()) {
                    Toast.makeText(getApplicationContext(), password, Toast.LENGTH_LONG).show();
                }
            }
        });

        // Поле с подтверждением пароля
        EditText confirmPassEditText = findViewById(R.id.pass_confirm);
        confirmPassEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String confirmPass = confirmPassEditText.getText().toString();
                if (!hasFocus) {
                    // Скрываем клавиатуру при клике вне поля
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
                if (!confirmPass.isEmpty()) {
                    String initialPass = pass.getText().toString();
                    Toast.makeText(getApplicationContext(),
                            confirmPass.equals(initialPass) ? "Пароли совпадают" : "Пароли не совпадают",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void btnClick(View v) {
        showInfo(((Button) v).getText().toString(), ((Button) v));
    }

    public void btnExitClick(View v) {
        createExitAlert("Выход из приложения", "Вы хотите выйти из приложения?");
    }

    private void createExitAlert(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(title)
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton("Да", (dialog, which) -> finish())
                .setNegativeButton("Нет", (dialog, which) -> dialog.cancel());
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void showInfoAlert(String text) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Большая подсказка")
                .setMessage(text)
                .setCancelable(false)
                .setPositiveButton("Конечно", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void showInfo(String text, Button btn) {
        btn.setText("Уже нажали");
        btn.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
}