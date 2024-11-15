package com.example.simplificator;

import java.util.*;

public class Calculator
{
    public static String text = "5y + 3y + 5 + 8";

    public static String display = "";


    public static void main(String[] args)
    {

        evaluate(text);

    }

    /***
     * Splits the string with space as delimiter and return an array of tokens
     * @param input
     * @return
     */
    public static String[] split(String input)
    {
        return input.split(" ");
    }

    public static int basics(String input)
    {
        String[] arr = split(input);
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
                sum += Integer.valueOf(arr[x + 1]);
                //System.out.println("Currrent Sum(Add): " + sum);
                x++;
            }
            if (arr[x].equals("-"))
            {
                sum -= Integer.valueOf(arr[x + 1]);
                //System.out.println("Currrent Sum(Diff): " + sum);
                x++;
            }
        }
        return sum;
    }

    public static String[] segregateExpression(String[] arr)
    {
//        1 + 2x^3 - 3x^3 + 2y^4 - 3y^5 + 2
        String expression = "";
        String constantExpression = "";
        for (int x = 0; x < arr.length; x++) {
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
        //System.out.println("Expression : " + expression);
        //System.out.println("ConstantExpression : " + constantExpression);
        return new String[]{expression, constantExpression};
    }

    public static String expoStuff(String expression)
    {

//        2x^3 - 3y^5 - 3x^3 + 2y^4
//        2x^3 ==> 2 , x , 3
        int[] x = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0 , 0};
        int[] y = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0 , 0};
        String[] tokens = expression.split(" ");

        int multiplier = 1 ;
        for (int i = 0; i < tokens.length; i++)
        {
            String token  = tokens[i];

            if ( token.equals("+") ) multiplier = 1;
            if ( token.equals("-") ) multiplier = -1;

            if (token.contains("x"))
            {
                int coeff = getCoefficient(token );
                int power = getExpotentional(token);
                x[power] = x[power] + multiplier * coeff ;
            }
            if (token.contains("y"))
            {
                int coeff = getCoefficient(token );
                int power = getExpotentional(token);
                y[power] = y[power] + multiplier * coeff ;
            }
        }

        // Loop over x from back and construct the expression
        String xExpression = constructExpression(x , "x");
        //  Loop over y from back and construct the expression
        String yExpression = constructExpression(y , "y");

        return xExpression + yExpression;
    }

    public static String constructExpression(int[] vArray , String variableName)
    {
        String statement = "";
        for( int i = vArray.length - 1 ; i >= 0 ; i-- )
        {
            if( vArray[i] != 0  )
            {
                //make condition to see if first term is positive and don't add positive sign if it is
                String sign;
                if(vArray[i] > 0)
                {
                    sign= "+";
                }
                else
                {
                    sign = "-";
                }
                statement = statement + sign + Math.abs(vArray[i]) + variableName ;
                if( i != 1 ) statement  =  statement  + "^" + i ;
            }
        }
        return statement;
    }

    public static int getCoefficient(String token)
    {
        if(token.startsWith("x") || token.startsWith("y"))
            return 1;
        if(token.contains("x"))
        {
            return Integer.valueOf(token.substring(0, token.indexOf("x")));
        }
        return Integer.valueOf(token.substring(0, token.indexOf("y")));
    }


    public static int getExpotentional(String token)
    {
        char[] tokenCharArray = token.toCharArray();
        if(!token.contains("^")) return 1 ;
        return Integer.parseInt(String.valueOf(tokenCharArray[tokenCharArray.length -1]));
    }


    public static String evaluate(String input)
    {
        String[] expressionSplits = split(input);
        for(int x=0; x<expressionSplits.length; x++)
        {   // 8+8+ // 8-8- // 8++8 // 8--8 // 8+-8 // 8-+8 //
            if(expressionSplits[expressionSplits.length-1].contains("+") || expressionSplits[expressionSplits.length-1].contains("-") ||
                    x<expressionSplits.length-1 && ( (expressionSplits[x].contains("+") && (expressionSplits[x+1].contains("+")) ||
                            (expressionSplits[x].contains("-") && (expressionSplits[x+1].contains("-")) ) ) || (expressionSplits[x].contains("+") && (expressionSplits[x+1].contains("-")) ||
                            (expressionSplits[x].contains("-") && (expressionSplits[x+1].contains("+")) ) ) ) )
            {
                return ("ERROR");

            }
        }

        String[] expressions = segregateExpression(expressionSplits);

        String constantExpression = expressions[1];
        int constantSum = 0;

        if(constantExpression.length() > 0 )
            constantSum = basics(constantExpression);

        String variableExpression = expressions[0];

        String computedExp = expoStuff(variableExpression);
        String computedConstants = "";
        if(constantSum>0)
        {
            computedConstants = "+" + String.valueOf(constantSum);
        }
        else if (constantSum < 0)
        {
            computedConstants = String.valueOf(constantSum);
        }
        String answer = (computedExp + computedConstants);
        System.out.println( "Final Expre :" + answer);

        return answer;

    }

}