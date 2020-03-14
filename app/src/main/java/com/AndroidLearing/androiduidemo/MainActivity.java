package com.AndroidLearing.androiduidemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    static String TAG = "MAINACTIVITY";
    private TextView mCancel;
    private TextView mBack;
    private TextView mMod;
    private TextView mDivider;
    private TextView mNumberone;
    private TextView mNumbertwo;
    private TextView mNumberthree;
    private TextView mMulti;
    private TextView mNumberfour;
    private TextView mNumberfive;
    private TextView mNumbersix;
    private TextView mMinus;
    private TextView mNumberseven;
    private TextView mNumbereight;
    private TextView mNumbernine;
    private TextView mPlus;
    private TextView mNumberzero;
    private TextView mPoint;
    private TextView mEqual;
    private TextView mResult;
    private String  oldValue="" ;
    private String  newValue;
    Stack<Double> opNumbers = new Stack<Double>();
    Stack<String> opOperators = new Stack<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_layout);
        //找控件
        initView();
        //设置点击事件
        initClickEvent();
    }

    private void initClickEvent() {
        //清空按钮的事件
        mCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mResult.setText("0");
                oldValue ="";
            }
        });
        //回退按钮的事件
        mBack.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

            }
        });
        //数字和小数点按钮的事件
        mNumberone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value= mNumberone.getText().toString();
                mResult.setText(oldValue+value+" ");
                oldValue += value+" ";
            }
        });
        mNumbertwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value= mNumbertwo.getText().toString();
                mResult.setText(oldValue+value+" ");
                oldValue += value+" ";
            }
        });
        mNumberthree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value= mNumberthree.getText().toString();
                mResult.setText(oldValue+value+" ");
                oldValue += value+" ";
            }
        });
        mNumberfour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value= mNumberfour.getText().toString();
                mResult.setText(oldValue+value+" ");
                oldValue += value+" ";
            }
        });
        mNumberfive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value= mNumberfive.getText().toString();
                mResult.setText(oldValue+value+" ");
                oldValue += value+" ";
            }
        });
        mNumbersix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value= mNumbersix.getText().toString();
                mResult.setText(oldValue+value+" ");
                oldValue += value+" ";
            }
        });
        mNumberseven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value= mNumberseven.getText().toString();
                mResult.setText(oldValue+value+" ");
                oldValue += value+" ";
            }
        });
        mNumbereight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value= mNumbereight.getText().toString();
                mResult.setText(oldValue+value+" ");
                oldValue += value+" ";
            }
        });
        mNumbernine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value= mNumbernine.getText().toString();
                mResult.setText(oldValue+value+" ");
                oldValue += value+" ";
            }
        });
        mNumberzero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value= mNumberzero.getText().toString();
                mResult.setText(oldValue+value+" ");
                oldValue += value+" ";
            }
        });
        /*
        mPoint.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String value= mPoint.getText().toString();
                mResult.setText(oldValue+value);
                oldValue += value;
            }
        });*/
        //运算符号的点击事件
        mDivider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value= mDivider.getText().toString();
                mResult.setText(oldValue+value+" ");
                oldValue += value+" ";
            }
        });
        mMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value= mMod.getText().toString();
                mResult.setText(oldValue+value+" ");
                oldValue += value+" ";
            }
        });
        mMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value= "*";
                mResult.setText(oldValue+value+" ");
                oldValue += value+" ";
            }
        });
        mMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value= mMinus.getText().toString();
                mResult.setText(oldValue+value+" ");
                oldValue += value+" ";
            }
        });
        mPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value= mPlus.getText().toString();
                mResult.setText(oldValue+value+" ");
                oldValue += value+" ";
            }
        });
        //等于号的点击事件
        mEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int length=0;
                String [] formulaArr = oldValue.split(" ");
                String operators = "+-*/";
                opOperators.add("#");//字符栈存个#,防止栈空
                Log.e(TAG,formulaArr[0]);
                while(length<formulaArr.length) {
                    String op = formulaArr[length++];
                    //如果是运算符，判断优先级
                    //indexof方法,判断字符串第一次出现的位置，找不到为-1
                    if(operators.contains(op)) {
                        String sign = opOperators.peek();//顶部出栈
                        int priority = compare(op,sign);//比较优先级
                        if(priority>=0) {//如果要入栈的运算符优先级高或相等,出栈两个数字，和之前的运算符计算后数字和字符分别入栈
                            opNumbers.add(compute(opOperators,opNumbers));
                            Log.e(TAG,opNumbers.pop().toString());
                            opOperators.add(op);
                        }else {//入栈运算符优先级低，直接入栈
                            opOperators.add(op);

                        }
                        continue;
                    }
                    //若是数字，则入栈
                    opNumbers.add(Double.parseDouble(op.replace("(", "").replace(")", "")));//将括号忽略掉
                }
                while (opOperators.peek()!="#") {
                    opNumbers.add(compute(opOperators, opNumbers));
                }
                mResult.setText(String.valueOf(opNumbers.pop()));
                oldValue="";
            }
        });

    }
    private Double compute(Stack<String> opOperators, Stack<Double> opNumbers) {
        double num2 = opNumbers.pop();
        double num1 = opNumbers.pop();
        String _op = opOperators.pop();
        double result =0.0;
        switch(_op) {
            case "+":
                result=num1+num2;
                break;
            case "-":
                result =num1-num2;
                break;
            case "*":
                result =num1*num2;
                break;
            case "/":
                result =num1/num2;
                break;
        }
        return result;
    }

    private int compare(String operator1, String operator2) {
        int res=0;
        switch(operator1) {
            case "+":
            case "-":
                if(operator2.equals("+")||operator2.equals("-")||operator2.equals("*")||operator2.equals("/")) {
                    res=1;
                }else {
                    res=-1;
                }
                break;
            case "*":
            case "/":
                if(operator2.equals("*")||operator2.equals("/")) {
                    res=1;
                }else {
                    res=-1;
                }
                break;
        }
        return res;
    }

    private void initView() {
        mCancel = this.findViewById(R.id.tv_cancel);
        mBack = this.findViewById(R.id.tv_back);
        mMod = this.findViewById(R.id.tv_mod);
        mDivider = this.findViewById(R.id.tv_divider);
        mNumberone = this.findViewById(R.id.tv_number_one);
        mNumbertwo = this.findViewById(R.id.tv_number_two);
        mNumberthree = this.findViewById(R.id.tv_number_three);
        mMulti = this.findViewById(R.id.tv_multi);
        mNumberfour = this.findViewById(R.id.tv_number_four);
        mNumberfive = this.findViewById(R.id.tv_number_five);
        mNumbersix = this.findViewById(R.id.tv_number_six);
        mMinus = this.findViewById(R.id.tv_minus);
        mNumberseven = this.findViewById(R.id.tv_number_seven);
        mNumbereight = this.findViewById(R.id.tv_number_eight);
        mNumbernine = this.findViewById(R.id.tv_number_nine);
        mPlus = this.findViewById(R.id.tv_plus);
        mNumberzero = this.findViewById(R.id.tv_number_zero);
        mPoint = this.findViewById(R.id.tv_point);
        mEqual = this.findViewById(R.id.tv_equal);
        mResult = this.findViewById(R.id.tv_result);
    }
}
