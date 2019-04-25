package com;

import java.math.BigInteger;

public class Fibonacci {
	
	public static BigInteger Fibonacci_of(int count){
		if(count == 1) {
			return new BigInteger("1");
		}
		
		BigInteger n1 = new BigInteger("0"), n2 = new BigInteger("1"), n3 = new BigInteger("0");
		for(int i = 0; i < count-1; i++) {
			n3 = n1.add(n2);
			n1 = n2;
			n2 = n3;
		}
		return n3;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 200;
		for(int i=1; i <= count; i++) {
			System.out.print("Fibonacci.of(" + i + ") == " + Fibonacci_of(i) + "\n");
		}	
	}
}
