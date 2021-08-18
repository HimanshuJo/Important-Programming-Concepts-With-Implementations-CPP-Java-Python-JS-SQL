/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sun.testingalgoswithajax;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

/**
 *
 * @author hjoshi
 */
public class DemoAlgos {

	private int num;
	private long result;

	private String text;
	private boolean newResult;

	private String inputString;
	private String resultString;
	private int resultStringLength;

	public int getResultStringLength() {
		return resultStringLength;
	}

	public void setResultStringLength(int resultStringLength) {
		this.resultStringLength = resultStringLength;
	}

	public String getInputString() {
		return inputString;
	}

	public void setInputString(String inputString) {
		this.inputString = inputString;
	}

	public String getResultString() {
		return resultString;
	}

	public void setResultString(String resultString) {
		this.resultString = resultString;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isNewResult() {
		return newResult;
	}

	public void setNewResult(boolean newResult) {
		this.newResult = newResult;
	}

	/**
	 * Creates a new instance of DemoAlgos
	 */
	public DemoAlgos() {
		num = 0;
		result = 0;
		text = " ";
		newResult = true;
		inputString = " ";
		resultString = " ";
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public long getResult() {
		return result;
	}

	public void setResult(long result) {
		this.result = result;
	}

	public int lengthOfLongestSubString(String n) {
		int len_input = n.length();
		if (len_input == 0) {
			return 0;
		}
		int max_len = 0;
		int curr_len = 0;
		int curr_start = 0;

		Map<Character, Integer> string_map = new HashMap<>();
		for (int i = 0; i < len_input; i++) {
			Integer offset = string_map.get(n.charAt(i));
			if (offset == null) {
				curr_len++;
			} else if (offset >= curr_start) {
				curr_len = i - offset;
				curr_start = offset + 1;
			} else {
				curr_len++;
			}
			string_map.put(n.charAt(i), i);
			if (curr_len > max_len) {
				max_len = curr_len;
			}
		}
		return max_len;
	}

	public void displayLongestStringSubsequenceRes() {
		if (" ".equals(inputString)) {
			setResultStringLength(0);
		} else {
			setResultStringLength(lengthOfLongestSubString(inputString));
		}

		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"For the input string " + inputString + " the max length is: " + resultStringLength, " ");
		FacesContext.getCurrentInstance().addMessage(null, facesMsg);
	}

	public void ajaxPerformLongestStringSubsequencesRes(final AjaxBehaviorEvent event) {
		if (" ".equals(inputString)) {
			setResultStringLength(0);
		} else {
			setResultStringLength(lengthOfLongestSubString(inputString));
		}

		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"For the input string: " + inputString + " the ajax reply is: " + resultStringLength, " ");
		FacesContext.getCurrentInstance().addMessage(null, facesMsg);
	}

	public long firstAlgoCheckFib(int number) {
		long current = 1;
		long next = 1;
		long sum = 0;

		if (number == 1 || number == 2) {
			return 1;
		} else {
			for (int i = 2; i < number; i++) {
				sum = current + next;
				current = next;
				next = sum;
			}
			return sum;
		}
	}

	public void displayFirstAlgoRes() {
		if (num <= 0) {
			setResult(0L);
		} else {
			setResult(firstAlgoCheckFib(num));
		}

		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Fibonacci Calculation for " + num + " is: " + result, "Fibonacci  Calculation");
		FacesContext.getCurrentInstance().addMessage(null, facesMsg);
	}

	public void ajaxPerformFibonnaciOperation(final AjaxBehaviorEvent event) {

		if (num <= 0) {
			setResult(0L);
		} else {
			setResult(firstAlgoCheckFib(num));
		}

		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"With Ajax " + num + " the result is: " + result, "Fib Calc");
		FacesContext.getCurrentInstance().addMessage(null, facesMsg);
	}

	public void displaySecondAlgoRes() {
		if ("".equals(text)) {
			setNewResult(true);
		} else {
			setNewResult(secondAlgoCheckString(text));
		}

		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Palind. calculated for " + text + " and it: " + newResult, " ");
		FacesContext.getCurrentInstance().addMessage(null, facesMsg);
	}

	private boolean secondAlgoCheckString(String s) {
		boolean res = true;

		if (s.isEmpty()) {
			return res;
		}
		Stack<Character> stack = new Stack<>();

		char[] my_char = s.toCharArray();
		System.out.println(my_char);

		for (int i = 0; i < s.length(); i++) {

			switch (my_char[i]) {
			case ')':
				try {
					int current = stack.pop();
					if (current != '(') {
						res = false;
					}
				} catch (Exception e) {
					res = false;
				}
				break;
			case '}':
				try {
					int current = stack.pop();
					if (current != '{') {
						res = false;
					}
				} catch (Exception e) {
					res = false;
				}
				break;
			case ']':
				try {
					int current = stack.pop();
					if (current != '[') {
						res = false;
					}
				} catch (Exception e) {
					res = false;
				}
				break;
			default:
				stack.push(my_char[i]);
				break;
			}
		}
		if (stack.empty()) {
			return res;
		} else {
			res = false;
		}
		return res;
	}

	public void ajaxPerformStringOperation(final AjaxBehaviorEvent event) {

		if (" ".equals(text)) {
			setNewResult(true);
		} else {
			setNewResult(secondAlgoCheckString(text));
		}

		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"With Ajax the result for " + text + " is: " + newResult, " ");
		FacesContext.getCurrentInstance().addMessage(null, facesMsg);
	}
}
