package com.interview.alexandria;

public class Sample {
	
	public static void main(String[] args){
		String s1 = "abc";
		String s2 = "abc";
		System.out.println("s1==s2?"+(s1==s2));
		String s3 = new String("abc");
		System.out.println("s1==s3?"+(s1==s3));
		s3 = "abc";
		System.out.println("s1==s3?"+(s1==s3));
		System.out.println("s2==s3?"+s2==s3);
		s2="zz";
		System.out.println("s1==s2?"+(s1==s2));
		
	}

}
