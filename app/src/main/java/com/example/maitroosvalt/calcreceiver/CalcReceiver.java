package com.example.maitroosvalt.calcreceiver;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;


import java.math.BigDecimal;
import java.math.RoundingMode;


public class CalcReceiver extends BroadcastReceiver {
    Calculator calc = new Calculator();
    public CalcReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (isOrderedBroadcast()) {
            Bundle extras = intent.getExtras();

            if (extras != null) {
                UOW uow = new UOW(context);

                String button = extras.getString("button");
                String screen = extras.getString("screen");

                switch (button) {
                    case "=":
                        Double nr1  = new Double(screen);
                        Double nr2 =  new Double(calc.getX());
                        String op = calc.getOperator();

                        Float answer = OnEquals(screen);

                        uow.addNewRowToStats(op, nr1, nr2,  new Double(answer.toString()));

                        extras.putString("screen_val", Float.toString(answer));

                        setResultExtras(extras);

                        break;
                    default:
                        onOperator(button, screen);
                        extras.putString("screen_val", "");
                        setResultExtras(extras);

                        break;
                }
            }
        }

    }

    public Float OnEquals(String value) {
        calc.setY(Float.parseFloat(value));

        float total = calc.calc(calc.getOperator());

        calc.setY(null);
        calc.setX(null);
        calc.setOperator(null);

        return total;
    }

    public void onOperator(String operator, String value) {
        calc.setOperator(operator);

        calc.setX(Float.parseFloat(value));
    }
}
