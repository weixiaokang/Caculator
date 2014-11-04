package weixiaokang.caculator;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import weixiaokang.caculator.component.AboveView;
import weixiaokang.caculator.component.BelowView;
import weixiaokang.caculator.component.CircleButton;
import weixiaokang.caculator.util.Calculate;
import weixiaokang.caculator.util.Calculator;


public class MyActivity extends Activity implements View.OnClickListener, TextWatcher{

    private CircleButton div_button, mul_button, c_button,del_button
         , plu_button, min_button, equ_button, dot_button
         , zero_button, one_button, two_button, three_button
         , four_button, five_button, six_button, seven_button
         , eight_button, nine_button;
    private BelowView edit_view;
    private AboveView result_view;

    private Calculate calculate;
    private StringBuffer str = new StringBuffer("");

    private Calculator calculator = new Calculator();

    private boolean isFrag = false, isChanged = true;

/*    private LinkedList<Double> number = new LinkedList<Double>();
    private LinkedList<Character> character = new LinkedList<Character>();*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        initView();

        setAllClickListener();
    }

    /**
     * 初始化组件
     */
    private void initView() {
        result_view = (AboveView)findViewById(R.id.result_view);
        edit_view = (BelowView)findViewById(R.id.edit_view);
        c_button = (CircleButton)findViewById(R.id.c_button);
        del_button = (CircleButton)findViewById(R.id.del_button);
        div_button = (CircleButton)findViewById(R.id.div_button);
        mul_button = (CircleButton)findViewById(R.id.mul_button);
        plu_button = (CircleButton)findViewById(R.id.plus);
        min_button = (CircleButton)findViewById(R.id.minus);
        equ_button = (CircleButton)findViewById(R.id.equ);
        dot_button = (CircleButton)findViewById(R.id.dot);
        zero_button = (CircleButton)findViewById(R.id.zero);
        one_button = (CircleButton)findViewById(R.id.one);
        two_button = (CircleButton)findViewById(R.id.two);
        three_button = (CircleButton)findViewById(R.id.three);
        four_button = (CircleButton)findViewById(R.id.four);
        five_button = (CircleButton)findViewById(R.id.five);
        six_button = (CircleButton)findViewById(R.id.six);
        seven_button = (CircleButton)findViewById(R.id.seven);
        eight_button = (CircleButton)findViewById(R.id.eight);
        nine_button = (CircleButton)findViewById(R.id.nine);
    }

    private void setAllClickListener() {
        c_button.setOnClickListener(this);
        del_button.setOnClickListener(this);
        div_button.setOnClickListener(this);
        mul_button.setOnClickListener(this);
        plu_button.setOnClickListener(this);
        min_button.setOnClickListener(this);
        equ_button.setOnClickListener(this);
        dot_button.setOnClickListener(this);
        zero_button.setOnClickListener(this);
        one_button.setOnClickListener(this);
        two_button.setOnClickListener(this);
        three_button.setOnClickListener(this);
        four_button.setOnClickListener(this);
        five_button.setOnClickListener(this);
        six_button.setOnClickListener(this);
        seven_button.setOnClickListener(this);
        eight_button.setOnClickListener(this);
        nine_button.setOnClickListener(this);
        edit_view.addTextChangedListener(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Log.i("test", "-->onClick()");
        switch (v.getId()) {
            case R.id.one:
                str.append("1");
                edit_view.setText(str);
                break;
            case R.id.two:
                str.append("2");
                edit_view.setText(str);
                break;
            case R.id.three:
                str.append("3");
                edit_view.setText(str);
                break;
            case R.id.four:
                str.append("4");
                edit_view.setText(str);
                break;
            case R.id.five:
                str.append("5");
                edit_view.setText(str);
                break;
            case R.id.six:
                str.append("6");
                edit_view.setText(str);
                break;
            case R.id.seven:
                str.append("7");
                edit_view.setText(str);
                break;
            case R.id.eight:
                str.append("8");
                edit_view.setText(str);
                break;
            case R.id.nine:
                str.append("9");
                edit_view.setText(str);
                break;
            case R.id.zero:
                str.append("0");
                edit_view.setText(str);
                break;
            case R.id.dot:
                str.append(".");
                edit_view.setText(str);
                break;
            case R.id.plus:
                str.append("+");
                edit_view.setText(str);
                break;
            case R.id.minus:
                str.append("-");
                edit_view.setText(str);
                break;
            case R.id.div_button:
                str.append("÷");
                edit_view.setText(str);
                break;
            case R.id.mul_button:
                str.append("×");
                edit_view.setText(str);
                break;
            case R.id.del_button:
                if (str.length()==0) {

                } else {
                    str.delete(str.length() - 1, str.length());
                    edit_view.setText(str);
                }
                break;
            case R.id.c_button:
                str.delete(0, str.length());
                edit_view.setText(str);
                result_view.setText("0");
                break;
            case R.id.equ:
                str.append("=");
                boolean flag = calculator.testString(str);
                edit_view.setText(str);
                if (flag) {
                    calculate = new Calculate(str.toString());
                    String result = calculate.caculate(calculate.convertToRPN());
                    result_view.setText(result.replaceAll("0+?$", "").replaceAll("[.]$", ""));
                    str.delete(0, str.length());
                    calculate = null;
                } else {
                    edit_view.setText("0");
                    result_view.setText("0");
                }
               /* caculator.addElement(str, number, character);
                if (number.size() != 0 && flag) {
                    double result = caculator.computer(number, character);
                    result_view.setText(String.valueOf(result).replaceAll("0+?$", "").replaceAll("[.]$", ""));
                    str.delete(0, str.length());
                    number.remove(0);
                    character.remove(0);
                } else if (flag){
                    edit_view.setText("0");
                    result_view.setText("0");
                } else {
                    number.clear();
                    character.clear();
                }*/
                break;
            default:
                break;
        }

        }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Log.i("test", "-->onTextChanged()");
        if (isChanged && str.length()!=0) {
            char c = str.charAt(count - 1);
            if (c == '.' && isFrag) {
                str.delete(str.length() - 1, str.length());
            } else if (c == '.') {
                if (str.length() != 1) {
                    isFrag = true;
                }
                calculator.testString(str);
            } else if (c == '+'
                    ||c == '-'
                    ||c == '×'
                    ||c == '÷'
                    ||c == '=') {
                isFrag = false;
                calculator.testString(str);
            }
            isChanged = false;
            edit_view.setText(str);
        } else {
            isChanged = true;
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}