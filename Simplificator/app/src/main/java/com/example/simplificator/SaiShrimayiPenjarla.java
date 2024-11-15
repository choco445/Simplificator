package com.example.simplificator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static TextView input;
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
    static String[] expressionSplits = split(textExpression);
    String[] expressions = segregateExpression(expressionSplits);

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
        textExpression += "+";
        input.setText(textExpression);
        text += " + ";

    }

    public void onClickMinus(View view) {
        textExpression += "-";
        input.setText(textExpression);
        text += " - ";

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
        textExpression = "";
        text = "";
    }
    public static String[] split(String input)
    {
        return input.split(" ");
    }
    public static int basics(String input)
    {
        String[] arr = split(input);

        for(int x=0; x<arr.length; x++)
        {
            System.out.println("Array"+arr[x]);
        }
        int sum;
        int num;
        if (arr[0].equals("-"))
        {
            sum = (-1) * Integer.valueOf(arr[1]);
            num = 2;
        }
        else if (arr[0].equals("+"))
        {
            sum = Integer.valueOf(arr[1]);
            num = 2;
        }
        else
        {
            sum = Integer.valueOf(arr[0]);
            num = 1;
        }

        for (int x = num; x < arr.length; x++)
        {
            if (arr[x].equals("+"))
            {
                sum += Integer.parseInt(arr[x + 1]);
            }
            if (arr[x].equals("-"))
            {
                sum -= Integer.parseInt(arr[x + 1]);
            }
        }
        return sum;
    }
    public static String[] segregateExpression(String[] arr)
    {
        String expression = "";
        String constantExpression = "";
        for (int x = 0; x < arr.length; x++)
        {
            if(arr[arr.length-1].contains("+") || arr[arr.length-1].contains("-") ||
                    x<arr.length-1 && ( (arr[x].contains("+") && (arr[x+1].contains("+")) ||
                            (arr[x].contains("-") && (arr[x+1].contains("-")) ) ) || (arr[x].contains("+") && (arr[x+1].contains("-")) ||
                            (arr[x].contains("-") && (arr[x+1].contains("+")) ) ) ) )
            {
                input.setText("ERROR");
            }
            if (arr[x].contains("x") || arr[x].contains("y"))
            {
                if ((x - 1) < 0)
                {
                    expression += arr[x];
                    expression += " ";
                }
                else
                {
                    if (!expression.isEmpty())
                    {
                        expression += arr[x - 1];
                        expression += " ";
                    }
                    expression += arr[x];
                    expression += " ";
                }
            }
            else if (arr[x].contains("+") || arr[x].contains("-"))
            {
                continue;
            }
            else
            {
                if ((x - 1) < 0)
                {
                    constantExpression += arr[x];
                    constantExpression += " ";
                }
                else
                {
                    if (!constantExpression.isEmpty())
                    {
                        constantExpression += arr[x - 1];
                        constantExpression += " ";
                    }
                    constantExpression += arr[x];
                    constantExpression += " ";
                }
            }
        }
        System.out.println("Expression : " + expression);
        System.out.println("ConstantExpression : " + constantExpression);
        return new String[]{expression, constantExpression};
    }
    public static String expoStuff(String expression)
    {
        int[] arrX = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0 , 0};
        int[] arrY = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0 , 0};
        String[] tokens = expression.split(" ");

        int multiplier = 1 ;
        for (int i = 0; i < tokens.length; i++)
        {
            String token  = tokens[i];
            String beforeExpo;
            String afterExpo;
            if(token.contains("^"))
            {
                beforeExpo = token.substring(0, token.indexOf("^"));
                afterExpo = token.substring(token.indexOf("^")+1);
            }
            else
            {
                beforeExpo = token;
                afterExpo = token;

            }
            int coeffNum;
            int powerNum;

            if ( token.equals("+") ) multiplier = 1;
            if ( token.equals("-") ) multiplier = -1;

            if (token.contains("x"))
            {
                if((beforeExpo.replace("x","")) == "")
                {
                    coeffNum = 1;
                }
                else
                {
                    coeffNum = Integer.valueOf(beforeExpo.replace("x",""));
                }
                if((afterExpo) == "")
                {
                    powerNum = 1;
                }
                else
                {
                    powerNum = Integer.valueOf(afterExpo);
                }

                arrX[powerNum] += arrX[powerNum] + multiplier * coeffNum ;
            }
            else if (token.contains("y"))
            {
                if((beforeExpo.replace("y","")) == "")
                {
                    coeffNum = 1;
                }
                else
                {
                    coeffNum = Integer.valueOf(beforeExpo.replace("y",""));
                }
                if((afterExpo) == "")
                {
                    powerNum = 1;
                }
                else
                {
                    powerNum = Integer.valueOf(afterExpo);
                }
                arrY[powerNum] += arrY[powerNum] + multiplier * coeffNum;
            }
        }

        for(int x=0; x<arrX.length; x++)
        {
            if(arrX[x]==(0))
            {
                System.out.print("");
            }
            else
            {
                System.out.print(arrX[x]+"x"+"^"+x+" ");
            }
        }

        for(int y=0; y<arrY.length; y++)
        {
            if(arrY[y]==(0))
            {
                System.out.print("");
            }
            else
            {
                System.out.print(arrY[y]+"y"+"^"+y+" ");
            }
        }
        return "";
    }

    public void onClickEvaluate(View view)
    {
        String[] expressionSplits = split(textExpression); //this separates the turns in the equation by the spaces
        String[] expressions = segregateExpression(expressionSplits);//this makes a new array, calling a method to fill it with 2 strings: 1 contains all the constants, 2 has others (variables)
        String constantExpression = expressions[1];//this declares a string containing only constants
        System.out.println("constantExpression:"+constantExpression);
        int constant = basics(constantExpression);//this calls a method to find the sum of all the constants

        String variableExpression = expressions[0];//this declares a string containing only terms with variables

        String computedExp = expoStuff(variableExpression);//this is the sum of all the terms with variables
        String answer = String.valueOf(constant) + computedExp;
        input.setText(answer);

    }

}
