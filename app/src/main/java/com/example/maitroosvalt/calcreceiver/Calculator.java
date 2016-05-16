package com.example.maitroosvalt.calcreceiver;

/**
 * Created by Mait Roosvalt on 08.03.2016.
 */

public class Calculator
{
    private Float total;
    private static Float x;
    private static Float y;
    private static String operator;

    public Calculator()
    {
        this.total = null;
    }

    public float addition(float x, float y)
    {
        return x + y;
    }
    public float subtraction(float x, float y)
    {
        return x - y;
    }
    public float multiplication(float x, float y)
    {
        return x * y;
    }
    public float division(float x, float y)
    {
        return x / y;
    }

    public Float calc(String ops){

        float x = this.x;
        float y = this.y;

        switch(ops)
        {
            case("+"):
                this.total = addition(x, y);
                break;
            case("-"):
                this.total = subtraction(x, y);
                break;
            case("*"):
                this.total = multiplication(x, y);
                break;
            case("/"):
                this.total = division(x, y);
                break;
        }

        return total;
    }

    public void setX(Float x) {
        this.x = x;
    }

    public void setY(Float Y) {
        this.y = Y;
    }

    public Float getY() {
        return this.y;
    }

    public Float getX() {
        return this.x;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return this.operator;
    }

}