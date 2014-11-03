package weixiaokang.caculator.util;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Stack;

/**
 * 本学期学了数据结构后，想到的新的计算方法
 * convertToRPN方法将中缀表达式转为后缀表达式
 * caculate方法遍历表达式中的字符，数字直接push到Stack中
 * 遇到操作符就调出Stack中的两个数字计算将结果压入Stack中
 * 最后Stack中剩下的数字就是结果
 */
public class Calculate {
	private String exp;
	private StringBuilder stBuilder;
	private HashMap<String, Integer> map;
	private Stack<String> stack;

    public Calculate() {
        this("");
    }

	public Calculate(String exp) {
		this.exp = exp;
		stBuilder = new StringBuilder();
		stack = new Stack<String>();
		map = new HashMap<String, Integer>();
		map.put("=", 0);
		map.put("+", 1);
		map.put("-", 1);
		map.put("×", 2);
		map.put("÷", 2);
		map.put("(", 3);
		map.put(")", 3);
	}

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String convertToRPN() {
		int start = 0;
		for (int i = 0; i < exp.length(); i++) {
			if (exp.charAt(i)=='='
					||exp.charAt(i)=='-'
					||exp.charAt(i)=='+'
					||exp.charAt(i)=='×'
					||exp.charAt(i)=='÷'
					||exp.charAt(i)=='('
					||exp.charAt(i)==')') {
				if (exp.charAt(start)>='0'&&exp.charAt(start)<='9') {
					stBuilder.append(exp.substring(start, i) + " ");
				}
				start = i + 1;
				putIntoStack(String.valueOf(exp.charAt(i)));
			}
		}
		if (!stack.empty()) {
		   stBuilder.append(stack.pop());
		}
		return stBuilder.toString();
	}

	private void putIntoStack(String operation) {
			while (!stack.empty()) {
				String top = stack.peek();
				if (operation.equals("(")) {
					stack.push(operation);
					break;
				} else if (operation.equals(")")) {
					while (!top.equals("(")) {
						stBuilder.append(top + " ");
						top = stack.peek();
					}
					stack.pop();
					break;
				} else if (top.equals("(")) {
					stack.push(operation);
					break;
				} else if(map.get(top) >= map.get(operation)) {
					stBuilder.append(top + " ");
					stack.pop();
				} else {
					stack.push(operation);
					break;
				}
			}
			if (stack.empty()) {
				stack.push(operation);
			}
			System.out.println(stack.toString());
	}
	
	public String caculate(String exp) {
		Stack<Double> stack = new Stack<Double>();
		for (String s : exp.split(" ")) {
			if (s.charAt(0) >= '0' && s.charAt(0) <= '9') {
				stack.push(Double.parseDouble(s));
			} else {
                BigDecimal a, b, d;
				switch (s.charAt(0)) {
				case '+':
					a = BigDecimal.valueOf(stack.pop());
					b = BigDecimal.valueOf(stack.pop());
					d = a.add(b);
					stack.push(d.doubleValue());
					break;
				case '-':
                    a = BigDecimal.valueOf(stack.pop());
                    b = BigDecimal.valueOf(stack.pop());
                    d = a.subtract(b);
                    stack.push(d.doubleValue());
					break;
				case '×':
                    a = BigDecimal.valueOf(stack.pop());
                    b = BigDecimal.valueOf(stack.pop());
                    d = a.multiply(b);
                    stack.push(d.doubleValue());
					break;
				case '÷':
                    a = BigDecimal.valueOf(stack.pop());
                    b = BigDecimal.valueOf(stack.pop());
                    d = a.divide(b, 16, BigDecimal.ROUND_HALF_EVEN);
                    stack.push(d.doubleValue());
					break;
				}
			}
		}
		return String.valueOf(stack.pop());
	}
}