package weixiaokang.caculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.LinkedList;

import weixiaokang.caculator.component.AboveView;
import weixiaokang.caculator.component.BelowView;
import weixiaokang.caculator.component.CircleButton;
import weixiaokang.caculator.util.Caculate;


public class MyActivity extends Activity {

    private CircleButton div_button, mul_button, c_button,del_button
         , plu_button, min_button, equ_button, dot_button
         , zero_button, one_button, two_button, three_button
         , four_button, five_button, six_button, seven_button
         , eight_button, nine_button;
    private BelowView edit_view;
    private AboveView result_view;

    private RelativeLayout relativelayout;

    private StringBuffer str = new StringBuffer("");

    private Caculate caculator = new Caculate();

    private LinkedList<Double> number = new LinkedList<Double>();
    private LinkedList<Character> character = new LinkedList<Character>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        initView();

        one_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str.append("1");
                edit_view.setText(str);
            }
        });

        two_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str.append("2");
                edit_view.setText(str);
            }
        });

        three_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str.append("3");
                edit_view.setText(str);
            }
        });

        four_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str.append("4");
                edit_view.setText(str);
            }
        });

        five_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str.append("5");
                edit_view.setText(str);
            }
        });

        six_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str.append("6");
                edit_view.setText(str);
            }
        });

        seven_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str.append("7");
                edit_view.setText(str);
            }
        });

        eight_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str.append("8");
                edit_view.setText(str);
            }
        });

        nine_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str.append("9");
                edit_view.setText(str);
            }
        });

        zero_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str.append("0");
                edit_view.setText(str);
            }
        });

        dot_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str.append(".");
                caculator.testString(str);
                edit_view.setText(str);
            }
        });

        min_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str.append("-");
                caculator.testString(str);
                edit_view.setText(str);
            }
        });

        mul_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str.append("×");
                caculator.testString(str);
                edit_view.setText(str);
            }
        });

        div_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str.append("÷");
                caculator.testString(str);
                edit_view.setText(str);
            }
        });

        plu_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str.append("+");
                caculator.testString(str);
                edit_view.setText(str);
            }
        });

        c_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str.delete(0, str.length());
                edit_view.setText(str);
                result_view.setText("0");
            }
        });

        del_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (str.length()==0) {

                } else {
                    str.delete(str.length() - 1, str.length());
                    edit_view.setText(str);
                }
            }
        });

        equ_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str.append("=");
                boolean flag = caculator.testString(str);
                edit_view.setText(str);
                caculator.addElement(str, number, character);
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
                }
            }
        });
    }

    /**
     * initialize the view
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
}