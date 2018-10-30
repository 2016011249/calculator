package com.example.a000.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;


public class calculator extends AppCompatActivity implements View.OnClickListener{

    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;
    Button zero;
    Button add;
    Button dian;
    Button gang;
    Button deng;
    Button minus;
    Button clear;
    Button X;
    Button delete;
    TextView TextView;
    private String smybol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        zero = (Button) findViewById(R.id.zero);
        add = (Button) findViewById(R.id.add);
        dian = (Button) findViewById(R.id.dian);
        gang = (Button) findViewById(R.id.gang);
        deng = (Button) findViewById(R.id.deng);
        minus = (Button) findViewById(R.id.minus);
        clear = (Button) findViewById(R.id.clear);
        X = (Button) findViewById(R.id.X);
        delete = (Button)findViewById(R.id.delete);
        TextView = (TextView)findViewById(R.id.Textview);


        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        zero.setOnClickListener(this);
        add.setOnClickListener(this);
        dian.setOnClickListener(this);
        deng.setOnClickListener(this);
        minus.setOnClickListener(this);
        clear.setOnClickListener(this);
        gang.setOnClickListener(this);
        X.setOnClickListener(this);
        delete.setOnClickListener(this);

    }

    @Override
        public void onClick(View v){
            String str = TextView.getText().toString();
            switch(v.getId()) {
                case R.id.one:
                case R.id.two:
                case R.id.three:
                case R.id.four:
                case R.id.five:
                case R.id.six:
                case R.id.seven:
                case R.id.eight:
                case R.id.nine:
                case R.id.zero:
                case R.id.dian:
                    TextView.setText(str + ((Button) v).getText());
                    break;
                case R.id.minus:
                  smybol="-";
                    TextView.setText(str+((Button) v).getText());
                    break;
                case R.id.X:
                 smybol="*";
                    TextView.setText(str+((Button) v).getText());
                    break;
                case R.id.add:
                 smybol="+";
                    TextView.setText(str+((Button) v).getText());
                    break;
                case R.id.gang:
                    smybol="/";
                    TextView.setText(str+((Button) v).getText());
                    break;
                case R.id.clear:
                    str = " ";
                   TextView.setText("");
                    break;
                case R.id.deng:
                    getResult();
                    break;
                case R.id.delete:
                    Delete();
                    break;
                }

            }
        private void getResult() {
            String exp = TextView.getText().toString();


            String s1 = exp.substring(0, exp.indexOf(smybol));
            String s2 = exp.substring(exp.indexOf(smybol) + 1, exp.length());
            TextView.setText(String.valueOf(jisuan(s1,s2)));

        }
        public double jisuan(String s1,String s2){
            switch (smybol){
                case "+":
                    return new BigDecimal(s1).add(new BigDecimal(s2)).doubleValue();
                case "-":
                    return new BigDecimal(s1).subtract(new BigDecimal(s2)).doubleValue();
                case "*":
                    return new BigDecimal(s1).multiply(new BigDecimal(s2)).doubleValue();
                case "/":
                    return new BigDecimal(s1).divide(new BigDecimal(s2)).doubleValue();
            }
            return 0;
        }
        private void Delete(){
            String exp = TextView.getText().toString();
            String d1 = exp.substring(0,exp.length()-1);
            TextView.setText(d1);
        }
    }

