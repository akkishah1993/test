package com.example.gateway;

public class TestClass {

	public static void main(String[] args) {
		
		new TestClass().test(2);
	}

	public void test(int param) {
		switch (param) {
		  case 0:
		    doSomething();
		    break;
		  default: // default clause should be the last one
		    error();
		    break;
		  case 1:
		    doSomethingElse();
		    break;
		}
	}
	public void doSomething() {
		System.out.println("Do Something");
	}
	public void error() {
		System.out.println("Error");
	}
	public void doSomethingElse() {
		System.out.println("Else");
	}
}
