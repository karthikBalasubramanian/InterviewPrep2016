package com.interview.stack;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class StackInArray {
	// stack is a LIFO
	// Four operations
	// push
	// pop
	// top  sometimes pop and top are combined
	// isEmpty
	// All in order of 1
	
	int top = -1;
	int[] numArr= new int[3];
	
	public void push(int num){
//		System.out.println("top value: "+ top +" candidates length: "+numArr.length);
		if(top==numArr.length-1){
			//get twice the size of current candidates and copy elements in the
			//stack to the new candidates.
//			System.out.println("length maxed out. Adding new length. "
//					+ "Size of the candidates before "+numArr.length);
			expandArray();
//			System.out.println("Size of the candidates after "+numArr.length);
		}
		
		numArr[++top] = num;
		
		
		
	}
	
	
	
	public int pop(){
		int removeTopMost = numArr[top];
		top -=1;
		return removeTopMost;
	}
	
	public void expandArray(){
		int newLength = 2*numArr.length;
		numArr = Arrays.copyOf(numArr, newLength);
	}
	
	public int getTop(){
		
		return numArr[top];
	}
	public boolean isEmpty(){
		if(top==-1) return true;
		else return false;
	}
	
	public void print(){
		StringBuffer sBuff = new StringBuffer();
		sBuff.append("[");
		for(int i=0; i<=top; i++){
			
			sBuff.append(" "+numArr[i]+",");
		}
		sBuff.append("]");
		System.out.println(sBuff);
	}
	
	public String reverseAStringUsingStack(String value){
		char[] valueArray = value.toCharArray();
		// build stack
		Deque<Character> myStack = new ArrayDeque<Character>();
		for(int i=0; i<valueArray.length; i++){
			myStack.push(valueArray[i]);
		}
		for(int i=0; i<valueArray.length; i++){
			valueArray[i]= myStack.pop().charValue();
		}
		return new String(valueArray);
	}
	
	public boolean arePairs(char firstChar, char lastChar){
		if(firstChar=='('&& lastChar==')') return true;
		else if(firstChar=='['&& lastChar==']') return true;
		else if(firstChar=='{'&& lastChar=='}') return true;
		else return false;
	}
	
	public boolean paranthesisCheck(String s){
		char[] charArray = s.toCharArray();
		Deque <Character> myStack = new ArrayDeque<Character>();
		for(int i=0; i<charArray.length; i++){
			if(charArray[i]=='('|| charArray[i]=='{'||charArray[i]=='['){
				myStack.push(charArray[i]);
			}
			else if(charArray[i]==')'||charArray[i]=='}'||charArray[i]==']'){
				if(myStack.isEmpty() || !arePairs(myStack.getFirst(), charArray[i])){
					return false;
				}
				else{
					myStack.pop();
				}
			}
		}
		
		if (myStack.isEmpty()) return true;
		else return false;
		
	}
	
	public int compute(String symbol, int num1,int num2){
		if(symbol.equals("*")){
			return num1*num2;
		}else if(symbol.equals("/")){
			return num1/num2;
		}else if(symbol.equals("+")){
			return num1+num2;
		}else if(symbol.equals("-")){
			return num1-num2;
		}
		return -1;
	}
	
	public int evalRPN(String[] tokens) {
		Deque<Integer> myStack = new ArrayDeque<Integer>();
		for(int i=0; i<tokens.length; i++){
			if (tokens[i].equals("*")||tokens[i].equals("/")|| tokens[i].equals("+")||tokens[i].equals("-")){
				int num1 =  myStack.pop();
				int num2 = myStack.pop();
				int computedNum =  compute(tokens[i], num1, num2);
				myStack.push(computedNum);
			}else{
				int num = Integer.parseInt(tokens[i]);
				myStack.push(num);
				 
			}
		}
		return myStack.peek();
    }
	
	public int calculate(String s){
		StringBuilder sb = new StringBuilder();
		Deque<Character> operatorStack = new ArrayDeque<Character>();
		char[] compute =  s.toCharArray();
		for(int i=0; i<compute.length; i++){
			if(compute[i]== ' '){
				continue;
			}
			else if(compute[i]=='+'||compute[i]=='-'||compute[i]=='*'||compute[i]=='/') {
// will be continued
				System.out.println(compute[i]);
			}
			else{
				sb.append(compute[i]);
			}
		}
		return -1;
		
	}
	
	
	public static void main(String[] args){
		
		StackInArray obj = new StackInArray();
		System.out.println("is Empty? "+obj.isEmpty());
		obj.push(1);
		obj.push(2);
		obj.push(3);
		obj.print();
		obj.push(4);
		obj.push(5);
		obj.push(6);
		
		obj.print();
		obj.pop();
		obj.print();
		obj.pop();
		obj.print();
		System.out.println(obj.getTop());
		System.out.println("reversing  Hello to "+obj.reverseAStringUsingStack("Hello"));
		System.out.println("checking if this returns false [] "+obj.paranthesisCheck("[(])"));
		System.out.println();
		String[] strArray = {"12","-3","*","5","4","*","+","9","-"};
		System.out.println("final value of evaluation is "+ obj.evalRPN(strArray));
		System.out.println("evaluating PN. Just reverse the candidates");
		String[] nStrArray ={"-","+","*","2","3","*","5","4","9"};
		List<String> list =  Arrays.asList(nStrArray);
		Collections.reverse(list);
		String[] rStrArray =  (String[]) list.toArray();
		System.out.println("PN value is "+ obj.evalRPN(rStrArray));
		System.out.println();
		System.out.println(obj.calculate("1 + 2"));
		
	}
}
