package com.practice.stacks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class StackUtil {
	
	public static String infixToPostfix(String infix) {
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		char[] infixArray = infix.toCharArray();
		
		for (int i = 0; i < infixArray.length; i++) {
			char ch = infixArray[i];
			if (isDigitOrAlphabet(ch)) {
				sb.append(ch);
			} else {
				if (stack.isEmpty()) {
					stack.push(ch);
				} else {
					if (ch == '(') {
						stack.push(ch);
					} else if (ch == ')') {
						while (true) {
							char popped = stack.pop();
							if (popped != '(') {
								sb.append(popped);
							} else {
								break;
							}
						}
					} else {
						// Is an operator
						int incomingPrecedence = precedence(ch);
						if (incomingPrecedence > precedence(stack.peek())) {
							stack.push(ch);
						} else {
							while (!stack.isEmpty() && stack.peek() != '(' && incomingPrecedence <= precedence(stack.peek())) {
								sb.append(stack.pop());
							}
							stack.push(ch);
						}
					}
				}
			}
		}
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.toString();
	}
	
	public static String infixToPrefix(String infix) {
		String reversed = new StringBuilder(infix).reverse().toString();
		
		char[] infixArray = reversed.toCharArray();
		for (int i=0; i < infixArray.length; i++) {
			if (infixArray[i] == '(') {
				infixArray[i] = ')';
			} else if (infixArray[i] == ')') {
				infixArray[i] = '(';
			}
		}
		String postfix = infixToPostfix(new String(infixArray));
		
		return new StringBuilder(postfix).reverse().toString();
		
	}
	
	public static String infixToPrefixUsing2Stacks(String infix) {
		Stack<Character> operatorStack = new Stack<>();
		Stack<String> operandStack = new Stack<>();
		char[] infixArray = infix.toCharArray();
		
		for (int i=0; i < infixArray.length; i++) {
			char ch = infixArray[i];
			if (isDigitOrAlphabet(ch)) {
				operandStack.push(String.valueOf(ch));
			} else {
				if (operatorStack.isEmpty()) {
					operatorStack.push(ch);
				} else {
					if (precedence(ch) > precedence((Character)operatorStack.peek())) {
						operatorStack.push(ch);
					} else {
						while (!operatorStack.isEmpty() && precedence(ch) <= precedence(operatorStack.peek())) {
							StringBuilder temp = new StringBuilder();
							temp.append(operandStack.pop());
							temp.append(operandStack.pop());
							temp.append(operatorStack.pop());
							operandStack.push(temp.toString());
						}
						operatorStack.push(ch);
					}
				}
			}	
		}
		while (!operatorStack.isEmpty()) {
			StringBuilder temp = new StringBuilder();
			temp.append(operandStack.pop());
			temp.append(operandStack.pop());
			temp.append(operatorStack.pop());
			operandStack.push(temp.toString());
		}
		String result = "";
		if (!operandStack.isEmpty()) {
			result = new StringBuilder(operandStack.pop()).reverse().toString();
		}
		return result;
	}
	
	public static int evaluateExpression(String infix) {
		Stack<Character> stack = new Stack<>();
		char[] infixArray = infix.toCharArray();
		LinkedList<String> list = new LinkedList<>();		
		
		for (int i = 0; i < infixArray.length; i++) {
			char ch = infixArray[i];
			if (isDigitOrAlphabet(ch)) {
				list.add(String.valueOf(ch));
			} else {
				if (stack.isEmpty()) {
					stack.push(ch);
				} else {
					if (ch == '(') {
						stack.push(ch);
					} else if (ch == ')') {
						while (true) {
							char popped = stack.pop();
							if (popped != '(') {
								int operand2 = Integer.valueOf(list.removeLast());
								int operand1 = Integer.valueOf(list.removeLast());
								list.add(String.valueOf(operation(operand1, operand2, popped)));
							} else {
								break;
							}
						}
					} else {
						// Is an operator
						int incomingPrecedence = precedence(ch);
						if (incomingPrecedence > precedence(stack.peek())) {
							stack.push(ch);
						} else {
							while (!stack.isEmpty() && stack.peek() != '(' && incomingPrecedence <= precedence(stack.peek())) {
								char popped = stack.pop();
								int operand2 = Integer.valueOf(list.removeLast());
								int operand1 = Integer.valueOf(list.removeLast());
								list.add(String.valueOf(operation(operand1, operand2, popped)));
							}
							stack.push(ch);
						}
					}
				}
			}
		}
		while (!stack.isEmpty()) {
			char popped = stack.pop();
			int operand2 = Integer.valueOf(list.removeLast());
			int operand1 = Integer.valueOf(list.removeLast());
			list.add(String.valueOf(operation(operand1, operand2, popped)));
		}
		return Integer.parseInt(list.removeLast());
	}
	
	public static boolean isDigitOrAlphabet(char ch) {
		if (ch >= 48 && ch <=57 ||
			ch >= 65 && ch <= 90 ||
			ch >= 97 && ch <= 122) {
			return true;
		}
		return false;
	}
	
	private static int precedence(char ch) {
		switch (ch) {
		case '+':
		case '-':
			return 0;
		case '*':
		case '/':
			return 1;
		case '^':
			return 2;
		default:
			return -1;
		}
	}
	
	private static int operation(int operand1, int operand2, char operator) {
		switch(operator) {
		case '+':
			return operand1 + operand2;
		case '-':
			return operand1 - operand2;
		case '*':
			return operand1 * operand2;
		case '/':
			return operand1 / operand2;
		case '^':
			return operand1 ^ operand2;
		default:
			throw new RuntimeException("Illegal operator");
		}
	}
}
