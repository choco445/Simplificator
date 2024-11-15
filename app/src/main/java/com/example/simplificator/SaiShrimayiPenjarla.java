package com.example.simplificator;
// 11-4-2023
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SaiShrimayiPenjarla extends AppCompatActivity {

    static TextView input;
    static TextView output;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button button0;
    Button plus;
    Button minus;
    Button power;
    Button expoX;
    Button expoY;
    Button clear;


    static String textExpression = "";
    static String text = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.id_button11);
        button2 = findViewById(R.id.id_button12);
        button3 = findViewById(R.id.id_button13);
        button4 = findViewById(R.id.id_button15);
        button5 = findViewById(R.id.id_button16);
        button6 = findViewById(R.id.id_button17);
        button7 = findViewById(R.id.id_button18);
        button8 = findViewById(R.id.id_button19);
        button9 = findViewById(R.id.id_button20);
        button0 = findViewById(R.id.id_button21);
        plus = findViewById(R.id.id_button22);
        minus = findViewById(R.id.id_button23);
        power = findViewById(R.id.id_button28);
        input = findViewById(R.id.input);
        output = findViewById(R.id.output);
        expoX = findViewById(R.id.button);
        expoY = findViewById(R.id.button2);
        clear = findViewById(R.id.id_button3);

    }

    public void onClick0(View view) {
        textExpression += "0";
        input.setText(textExpression);
        text += "0";
    }

    public void onClick1(View view) {
        textExpression += "1";
        input.setText(textExpression);
        text += "1";

    }

    public void onClick2(View view) {
        textExpression += "2";
        input.setText(textExpression);
        text += "2";

    }

    public void onClick3(View view) {
        textExpression += "3";
        input.setText(textExpression);
        text += "3";

    }

    public void onClick4(View view) {
        textExpression += "4";
        input.setText(textExpression);
        text += "4";

    }

    public void onClick5(View view) {
        textExpression += "5";
        input.setText(textExpression);
        text += "5";

    }

    public void onClick6(View view) {
        textExpression += "6";
        input.setText(textExpression);
        text += "6";

    }

    public void onClick7(View view) {
        textExpression += "7";
        input.setText(textExpression);
        text += "7";

    }

    public void onClick8(View view) {
        textExpression += "8";
        input.setText(textExpression);
        text += "8";

    }

    public void onClick9(View view) {
        textExpression += "9";
        input.setText(textExpression);
        text += "9";

    }

    public void onClickPlus(View view) {

        if(textExpression.substring(textExpression.length()-1).equals("+") || textExpression.substring(textExpression.length()-1).equals("-"))
        {
            return;
        }

            textExpression += "+";
            text += " + ";
            input.setText(textExpression);


    }

    public void onClickMinus(View view) {
        if(textExpression.length()>0) {
            if (textExpression.substring(textExpression.length() - 1).equals("+") || textExpression.substring(textExpression.length() - 1).equals("-")) {
                return;
            }
        }
        textExpression += "-";
        input.setText(textExpression);
        if(textExpression.length()==1)
        {
            text+="- ";
        }
        else
        {
            text += " - ";
        }

    }

    public void onClickPower(View view) {
        textExpression += "^";
        input.setText(textExpression);
        text += "^";

    }

    public void onClickExpoX(View view) {
        textExpression += "x";
        input.setText(textExpression);
        text += "x";

    }

    public void onClickExpoY(View view) {
        textExpression += "y";
        input.setText(textExpression);
        text += "y";
    }

    public void onClickClear(View view) {
        input.setText("Input: ");
        output.setText("Output: ");
        textExpression = "";
        text = "";
    }
    public void onClickEvaluate(View view)
    {
        output.setText(Calculator.evaluate(text));
    }

}
