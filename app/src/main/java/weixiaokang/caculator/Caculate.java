package weixiaokang.caculator;


import android.util.Log;

import java.util.LinkedList;

/**
 * Created by Administrator on 2014/7/7.
 */
public class Caculate {

    public boolean testString(StringBuffer str) {

        int location = str.length();
        if (str.length() == 1 && (str.charAt(0) < '0' || str.charAt(0) > '9')) {
            str.delete(location - 1, location);
        } else if (str.charAt(location - 2) < '0' || str.charAt(location - 2) > '9') {
            char c = str.charAt(location - 1);
            str.delete(location - 1, location);
            if (c == '=') {
                return false;
            }
        }
        return true;
    }

    public void addElement(StringBuffer str, LinkedList<Double> number, LinkedList<Character> c) {

        int start = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '×' || str.charAt(i) == '÷' || str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '=') {
                    number.add(Double.parseDouble(str.substring(start, i)));
//                Log.i("test", ""+Double.parseDouble(str.substring(start, i)));
                    c.add(str.charAt(i));
//                Log.i("test", ""+str.charAt(i));
                    start = i + 1;
                }
            }
    }

    public double computer(LinkedList<Double> number, LinkedList<Character> c) {

        int md_count = 0, mp_count = 0;
        if (c.size() == 1) {
            return number.get(0);
        }
        for (int i = 0; i < c.size(); i++) {
            if (c.get(i)=='×'||c.get(i)=='÷') {
                md_count++;
            }
            if (c.get(i)=='+'||c.get(i)=='-') {
                mp_count++;
            }
        }

        for (int i = 0; i < md_count; i++) {
            for (int j = 0; j < c.size(); j++) {
                if (c.get(j) == '×') {
                    number.set(j, number.get(j) * number.get(j + 1));
                    number.remove(j + 1);
                    c.remove(j);
                    break;
                } else if (c.get(j) == '÷') {
                    number.set(j, number.get(j)/number.get(j+1));
                    number.remove(j + 1);
                    c.remove(j);
                    break;
                }
            }
        }

        for (int i = 0; i < mp_count; i++) {
            for (int j = 0; j < c.size(); j++) {
                if (c.get(j)=='+') {
                    number.set(j, number.get(j)+number.get(j + 1));
                    number.remove(j + 1);
                    c.remove(j);
                } else if (c.get(j)=='-') {
                    number.set(j, number.get(j)-number.get(j + 1));
                    number.remove(j + 1);
                    c.remove(j);
                }
            }
        }
        return number.get(0);
    }
}