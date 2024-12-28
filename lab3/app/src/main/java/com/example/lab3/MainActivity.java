package com.example.lab3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText display;
    private String currentInput = "";
    private String operator = "";
    private double firstOperand = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button button0 = findViewById(R.id.button0);

        Button buttonAdd = findViewById(R.id.buttonAdd);
        Button buttonSubtract = findViewById(R.id.buttonSubtract);
        Button buttonMultiply = findViewById(R.id.buttonMultiply);
        Button buttonDivide = findViewById(R.id.buttonDivide);
        Button buttonClear = findViewById(R.id.buttonClear);
        Button buttonEqual = findViewById(R.id.buttonEqual);

        button1.setOnClickListener(v -> appendToDisplay("1"));
        button2.setOnClickListener(v -> appendToDisplay("2"));
        button3.setOnClickListener(v -> appendToDisplay("3"));
        button4.setOnClickListener(v -> appendToDisplay("4"));
        button5.setOnClickListener(v -> appendToDisplay("5"));
        button6.setOnClickListener(v -> appendToDisplay("6"));
        button7.setOnClickListener(v -> appendToDisplay("7"));
        button8.setOnClickListener(v -> appendToDisplay("8"));
        button9.setOnClickListener(v -> appendToDisplay("9"));
        button0.setOnClickListener(v -> appendToDisplay("0"));

        buttonAdd.setOnClickListener(v -> setOperator("+"));
        buttonSubtract.setOnClickListener(v -> setOperator("-"));
        buttonMultiply.setOnClickListener(v -> setOperator("*"));
        buttonDivide.setOnClickListener(v -> setOperator("/"));

        buttonClear.setOnClickListener(v -> clearDisplay());

        buttonEqual.setOnClickListener(v -> calculateResult());
    }

    private void appendToDisplay(String value) {
        currentInput += value;
        display.setText(currentInput);
    }

    private void setOperator(String operator) {
        if (!currentInput.isEmpty()) {
            firstOperand = Double.parseDouble(currentInput);
            this.operator = operator;
            currentInput = "";
        }
    }

    private void clearDisplay() {
        currentInput = "";
        firstOperand = 0;
        operator = "";
        display.setText("");
    }

    private void calculateResult() {
        if (!currentInput.isEmpty()) {
            double secondOperand = Double.parseDouble(currentInput);
            double result = 0;

            switch (operator) {
                case "+":
                    result = firstOperand + secondOperand;
                    break;
                case "-":
                    result = firstOperand - secondOperand;
                    break;
                case "*":
                    result = firstOperand * secondOperand;
                    break;
                case "/":
                    if (secondOperand != 0) {
                        result = firstOperand / secondOperand;
                    } else {
                        result = 0;
                    }
                    break;
            }

            display.setText(String.valueOf(result));
            currentInput = String.valueOf(result);
        }
    }
}
